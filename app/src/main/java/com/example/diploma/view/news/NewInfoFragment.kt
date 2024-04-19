package com.example.diploma.view.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import com.example.diploma.R
import com.example.diploma.model.New

class NewInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        arguments?.apply {
            val title = getString("title") ?: ""
            val text = getString("text") ?: ""
            val image = getInt("image")
            val new = New(title, image, text)
            setContent { NewInfoScreen(new) }
        } ?: run {
            @Suppress("DEPRECATION")
            fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragment_container, NewsFragment())
                ?.setTransition(TRANSIT_FRAGMENT_FADE)
                ?.commit()
        }
    }
}