package com.example.diploma.profile

import android.content.Intent
import android.content.Intent.ACTION_SENDTO
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.diploma.MainActivity
import com.example.diploma.R
import com.example.diploma.WebViewActivity


class ProfileFragment : Fragment() {
    private lateinit var fio: TextView
    private lateinit var foto: ImageView
    private lateinit var obyazannosti: TextView
    private lateinit var contact: TextView
    private lateinit var button: Button
    private lateinit var webView: Button
    private lateinit var letter: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(
        R.layout.fragment_profile, container, false
    ).apply {
        fio = findViewById(R.id.fio_profile)
        obyazannosti = findViewById(R.id.dolznost_profile)
        foto = findViewById(R.id.foto_profile)
        contact = findViewById(R.id.contact1)
        button = findViewById(R.id.exit)
        webView = findViewById(R.id.webview12)
        letter = findViewById(R.id.letter)

        fio.text = "Сазонтов Василий Дмитриевич"
        foto.setImageResource(R.drawable.man5)
        obyazannosti.text = "Айтишник"
        contact.text = "+7 (914) 558-99-96"

        button.setOnClickListener {
            val intent = Intent(
                context,
                MainActivity::class.java
            )
            startActivity(intent)
        }

        webView.setOnClickListener {
            val intent = Intent(
                context,
                WebViewActivity::class.java
            )
            startActivity(intent)
        }

        letter.setOnClickListener {
            val intentEmail = Intent(ACTION_SENDTO)
            val uri = Uri.parse("mailto:info@dis-group.ru")
            intentEmail.setData(uri)
            startActivity(intentEmail)
        }
    }
}