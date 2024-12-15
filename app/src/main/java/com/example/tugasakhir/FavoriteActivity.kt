package com.example.tugasakhir

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasakhir.FavoriteAdapter
import com.example.tugasakhir.database.FavoriteBookDatabase
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoriteActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        recyclerView = findViewById(R.id.favorite_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        loadFavorites()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.navigation_favorite -> true // Stay on Favorite
                R.id.navigation_logout -> {
                    logout()
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFavorites() {
        CoroutineScope(Dispatchers.IO).launch {
            val db = FavoriteBookDatabase.getDatabase(applicationContext)
            val favoriteBooks = db.favoriteBookDao().getAllFavoriteBooks()
            withContext(Dispatchers.Main) {
                favoriteAdapter = FavoriteAdapter(favoriteBooks)
                recyclerView.adapter = favoriteAdapter
            }
        }
    }

    private fun logout() {
        val sharedPreferences = getSharedPreferences("user_session", MODE_PRIVATE)
        sharedPreferences.edit().apply {
            putBoolean("is_logged_in", false)
            apply()
        }
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
