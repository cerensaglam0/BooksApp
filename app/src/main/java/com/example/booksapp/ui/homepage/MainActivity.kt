package com.example.booksapp.ui.homepage

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.booksapp.R
import com.example.booksapp.adapter.BookAdapter
import com.example.booksapp.adapter.BookAdapterCallback
import com.example.booksapp.data.response.Book
import com.example.booksapp.databinding.ActivityMainBinding
import com.example.booksapp.ui.detailpage.DetailActivity

class MainActivity : AppCompatActivity(), BookAdapterCallback {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private val adapter = BookAdapter(arrayListOf(), this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.progressBarHomePage.isVisible = true

        binding.editTextSearch.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    filterSearch(v?.text.toString())
                    return true
                }
                return false
            }
        })

        viewModel.getBook()


        setUpObserve()


    }

    private fun setUpObserve() {
        viewModel.responseLiveData.observe(this, Observer {
            setUpRecyclerView(it)
        })

        viewModel.errorLiveData.observe(this, Observer {
            showAlertDialog()
        })

        viewModel.loadingLiveData.observe(this, Observer {
            updateProgressBar(it)
        })
    }

    private fun setUpRecyclerView(bookList: ArrayList<Book>) {
        binding.recyclerViewHomePage.adapter = adapter
        adapter.submitNewList(bookList)
    }

    private fun showAlertDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setMessage("Error")
        alertDialog.setTitle("Error")
        alertDialog.setIcon(R.drawable.ic_baseline_priority_high_24)

        alertDialog.setPositiveButton("OK") { _, _ -> }.show()
    }

    private fun updateProgressBar(isVisible: Boolean) {
        binding.progressBarHomePage.isVisible = isVisible
    }

    override fun onBookItemClick(book: Book) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("key_book", book)
        startActivity(intent)
    }

    private fun filterSearch(text: String) {

        val bookList = viewModel.responseLiveData.value ?: arrayListOf()
        val newBookList = ArrayList<Book>()
        for (book in bookList) {
            if (book.title?.toLowerCase()?.contains(text.toLowerCase()) == true) {
                newBookList.add(book)
            }
        }
        adapter.submitNewList(newBookList)
    }
}