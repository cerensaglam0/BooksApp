package com.example.booksapp.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booksapp.data.response.Book
import com.example.booksapp.databinding.ItemBookBinding

class BookAdapter(private val bookList: ArrayList<Book>, private val callBack: BookAdapterCallback) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    class BookViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBookBinding.inflate(layoutInflater, parent, false)
        return BookViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val currentItem = bookList[position]

        with(holder) {
            binding.book = currentItem
            itemView.setOnClickListener {
                callBack.onBookItemClick(currentItem)
            }
            binding.textViewMainPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    fun submitNewList(newBookList: ArrayList<Book>) {
        bookList.clear()
        bookList.addAll(newBookList)
        notifyDataSetChanged()
    }
}
