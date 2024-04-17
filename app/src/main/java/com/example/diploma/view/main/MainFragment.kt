package com.example.diploma.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.diploma.R
import com.example.diploma.data.DataSource.getDivisionsList
import com.example.diploma.view.employee.EmployeeFragment

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        val categories = getDivisionsList()
        setContent {
            MainScreen(categories) { division ->
                val fragment: Fragment = EmployeeFragment()
                val bundle = Bundle()
                bundle.putString("key", division.title)
                bundle.putString("cap", division.description)
                fragment.arguments = bundle

                @Suppress("DEPRECATION")
                requireFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit()
            }
        }
    }
}