package com.example.tugasakhir.network

import com.example.tugasakhir.models.Book
import retrofit2.http.GET

interface ApiService {
    @GET("0BoBP/books")
    suspend fun getBooks(): List<Book>
}
