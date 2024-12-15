package com.example.tugasakhir

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailEditText = findViewById(R.id.your_email_)
        passwordEditText = findViewById(R.id.enter_your_)
        loginButton = findViewById(R.id.button_2)
        registerText = findViewById(R.id.sign_up_text)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (validateLogin(email, password)) {
                // Save login status in SharedPreferences
                val sharedPreferences = getSharedPreferences("user_session", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putBoolean("is_logged_in", true)
                editor.apply()

                // Navigate to HomeActivity
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
                finish() // Finish LoginActivity so user cannot go back to it
            } else {
                Toast.makeText(this, "Invalid credentials!", Toast.LENGTH_SHORT).show()
            }
        }

        registerText.setOnClickListener {
            // Navigate to RegisterActivity
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateLogin(email: String, password: String): Boolean {
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val savedEmail = sharedPreferences.getString("email", null)
        val savedPassword = sharedPreferences.getString("password", null)

        return email == savedEmail && password == savedPassword
    }
}
