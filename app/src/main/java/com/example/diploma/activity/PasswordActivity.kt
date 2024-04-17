package com.example.diploma.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.diploma.R

class PasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_password)

        val admin = findViewById<EditText>(R.id.pass_admmin)

        admin.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                val intent: Intent
                when (s.toString()) {
                    "12345" -> {
                        intent = Intent(
                            this@PasswordActivity,
                            AdminActivity::class.java
                        )
                        startActivity(intent)
                        finish()
                    }
                }
            }
        })
    }
}