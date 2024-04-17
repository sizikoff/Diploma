package com.example.diploma.view.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.diploma.R

class NewsAboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(
        R.layout.fragment_news_about, container, false
    ).apply {
        val photoNews: ImageView = findViewById(R.id.foto_news)
        val section1: TextView = findViewById(R.id.section1)
        val title1: TextView = findViewById(R.id.title1)
        arguments?.getString("title")
            ?.let { title1.text = it }
        arguments?.getInt("author")
            ?.let { photoNews.setImageResource(it) }
        arguments?.getString("desc")
            ?.let { section1.text = it }
    }
}