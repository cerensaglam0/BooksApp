package com.example.booksapp.ui.homepage

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.booksapp.Repository
import com.example.booksapp.data.response.Book
import com.example.booksapp.data.response.BookResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    private val disposable = CompositeDisposable()
    private val repository = Repository()

    val responseLiveData = MutableLiveData<ArrayList<Book>>()
    val errorLiveData = MutableLiveData<Throwable>()
    val loadingLiveData = MutableLiveData<Boolean>()


    fun getBook() {
        loadingLiveData.value = true
        disposable.add(
            repository.getBook()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getBookListObserverRx())
        )
    }

    private fun getBookListObserverRx(): DisposableObserver<BookResponse> {
        return object : DisposableObserver<BookResponse>() {
            override fun onComplete() {
                loadingLiveData.value = false
            }

            override fun onNext(t: BookResponse) {
                responseLiveData.value = t.result ?: arrayListOf()
            }

            override fun onError(e: Throwable) {
                errorLiveData.value = e
                Log.d("testestes", e.message.toString())
            }
        }
    }

    override fun onCleared() {  //viewmodel destroy olduğunda
        super.onCleared()
        disposable.clear()
    }
}