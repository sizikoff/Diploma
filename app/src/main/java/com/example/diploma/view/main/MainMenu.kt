package com.example.diploma.view.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.diploma.R
import com.example.diploma.view.news.NewsFragment
import com.example.diploma.view.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        val bottomNavigationView = findViewById<View>(R.id.bottom_boot) as BottomNavigationView

        startFragment(MainFragment())


        bottomNavigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_map -> {
                    startFragment(NewsFragment())
                    return@OnItemSelectedListener true
                }

                R.id.action_dial -> {
                    startFragment(MainFragment())
                    return@OnItemSelectedListener true
                }

                R.id.action_mail -> {
                    startFragment(ProfileFragment())
                    return@OnItemSelectedListener true
                }
            }
            false
        })
    }

    private fun startFragment(fragment: Fragment) {
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()
        ft.replace(R.id.fragment_container, fragment)
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        ft.commit()
    }
}