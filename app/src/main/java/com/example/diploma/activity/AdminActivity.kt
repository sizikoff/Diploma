package com.example.diploma.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.diploma.R

class AdminActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_admin)
        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val btnRead = findViewById<Button>(R.id.btnRead)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val etPost = findViewById<EditText>(R.id.etDolzhnost)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val simpleProgressBar = findViewById<ProgressBar>(R.id.determinateBar)

        btnAdd.setOnClickListener {
            if (etName.getText().toString().isEmpty()
                || etEmail.getText().toString().isEmpty()
                || etPost.getText().toString().isEmpty()
            ) {
                Toast.makeText(
                    this@AdminActivity,
                    getString(R.string.enter_error),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                simpleProgressBar.visibility = View.VISIBLE

                @Suppress("DEPRECATION")
                val handler = Handler()

                handler.postDelayed({
                    simpleProgressBar.visibility = View.GONE
                    Toast.makeText(
                        this@AdminActivity,
                        getString(R.string.send_data_to_hr_departament),
                        Toast.LENGTH_SHORT
                    ).show()
                    etName.text = null
                    etEmail.text = null
                    etPost.text = null
                }, 5000)
            }
        }

        btnRead.setOnClickListener {
            startActivity(Intent(this@AdminActivity, MainActivity::class.java))
            finish()
        }

        btnClear.setOnClickListener {
            AlertDialog
                .Builder(this@AdminActivity)
                .setMessage(getString(R.string.only_servants))
                .setPositiveButton(getString(R.string.ok)) { dialog, _ -> dialog.cancel() }
                .setTitle(getString(R.string.faq))
                .create()
                .show()
        }
    }
}