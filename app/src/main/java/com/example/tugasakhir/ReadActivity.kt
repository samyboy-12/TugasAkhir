package com.example.tugasakhir

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ReadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)

        // Ambil data dari Intent
        val bookId = intent.getIntExtra("BOOK_ID", -1)

        // Temukan views
        val textView: TextView = findViewById(R.id.text_read)

        // Tampilkan data (contoh placeholder)
        if (bookId != -1) {
            textView.text = "Reading book with ID: $bookId"
        } else {
            textView.text = "Book not found"
        }
    }
}
