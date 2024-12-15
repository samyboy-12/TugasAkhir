package com.example.tugasakhir

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugasakhir.database.FavoriteBook

class FavoriteAdapter(private val favoriteBooks: List<FavoriteBook>) : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    inner class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bookImage: ImageView = view.findViewById(R.id.book_image)
        val bookTitle: TextView = view.findViewById(R.id.book_title)
        val bookAuthor: TextView = view.findViewById(R.id.book_author)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val book = favoriteBooks[position]
        holder.bookTitle.text = book.title
        holder.bookAuthor.text = book.author

        // Load image using Glide
        Glide.with(holder.itemView.context)
            .load(book.imageUrl)
            .into(holder.bookImage)
    }

    override fun getItemCount(): Int = favoriteBooks.size
}
