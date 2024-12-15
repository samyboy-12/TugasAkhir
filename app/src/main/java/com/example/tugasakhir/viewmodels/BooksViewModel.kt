package com.example.tugasakhir.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasakhir.models.Book
import com.example.tugasakhir.network.ApiClient
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {
    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> get() = _books

    fun fetchBooks() {
        viewModelScope.launch {
            try {
                val bookList = ApiClient.getInstance().getBooks()
                _books.postValue(bookList)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
