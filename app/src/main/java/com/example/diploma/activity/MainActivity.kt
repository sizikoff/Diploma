package com.example.diploma.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.diploma.R

class MainActivity : AppCompatActivity() {
    private lateinit var login: EditText
    private lateinit var password: EditText
    private lateinit var enter: Button
    private lateinit var adminBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login = findViewById(R.id.login)
        password = findViewById(R.id.pass)
        enter = findViewById(R.id.enter)
        adminBtn = findViewById(R.id.enter_admin)

        enter.setOnClickListener {
            if (login.getText().toString().isEmpty() && password.getText().toString().isEmpty()) {
                Toast.makeText(this@MainActivity, "Проблема с вводом", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@MainActivity, SplashActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        adminBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, PasswordActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}