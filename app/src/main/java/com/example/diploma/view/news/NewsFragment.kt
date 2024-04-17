package com.example.diploma.view.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import com.example.diploma.data.DataSource.getNews
import com.example.diploma.R

class NewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        val news = getNews()
        setContent {
            NewsMainScreen(news) { new ->
                val fragment: Fragment = NewsAboutFragment()
                val bundle = Bundle()
                bundle.putString("title", new.title)
                bundle.putString("text", new.text)
                bundle.putInt("image", new.image)
                fragment.arguments = bundle

                @Suppress("DEPRECATION")
                fragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fragment_container, fragment)
                    ?.setTransition(TRANSIT_FRAGMENT_FADE)
                    ?.commit()
            }
        }
    }
}