package com.example.tugasakhir.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteBookDao {
    @Insert
    suspend fun insertFavoriteBook(book: FavoriteBook)

    @Query("SELECT * FROM favorite_books")
    suspend fun getAllFavoriteBooks(): List<FavoriteBook>
}
