package com.example.tugasakhir.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoriteBook::class], version = 1)
abstract class FavoriteBookDatabase : RoomDatabase() {
    abstract fun favoriteBookDao(): FavoriteBookDao

    companion object {
        @Volatile
        private var INSTANCE: FavoriteBookDatabase? = null

        fun getDatabase(context: Context): FavoriteBookDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavoriteBookDatabase::class.java,
                    "favorite_books_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
