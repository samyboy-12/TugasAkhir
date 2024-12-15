package com.example.tugasakhir

// Di dalam MainActivity.kt
import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Layout pertama yang Anda berikan

        val button1 = findViewById<RelativeLayout>(R.id.button_1) // Tombol Get Started
        button1.setOnClickListener {
            // Membuka Activity Login saat tombol diklik
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
