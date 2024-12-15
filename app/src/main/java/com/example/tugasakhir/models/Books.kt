package com.example.tugasakhir.models

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("author") val author: String,
    @SerializedName("publishedYear") val publishedYear: Int,
    @SerializedName("imageUrl") val imageUrl: String
)

