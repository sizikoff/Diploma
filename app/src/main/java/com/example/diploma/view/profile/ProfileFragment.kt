package com.example.diploma.view.profile

import android.content.Intent
import android.content.Intent.ACTION_SENDTO
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.diploma.activity.MainActivity
import com.example.diploma.activity.WebViewActivity


class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            ProfileScreen(
                callback = object : ProfileState {
                    override fun goToWeb() {
                        val intent = Intent(
                            context,
                            WebViewActivity::class.java
                        )
                        startActivity(intent)
                    }

                    override fun contactUs() {
                        val intentEmail = Intent(ACTION_SENDTO)
                        val uri = Uri.parse("mailto:info@dis-group.ru")
                        intentEmail.setData(uri)
                        startActivity(intentEmail)
                    }

                    override fun onExit() {
                        val intent = Intent(
                            context,
                            MainActivity::class.java
                        )
                        startActivity(intent)
                    }
                }
            )
        }
    }
}