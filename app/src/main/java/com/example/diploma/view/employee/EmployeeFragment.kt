package com.example.diploma.view.employee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.diploma.R
import com.example.diploma.data.DataSource.getEmployees

class EmployeeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        val employees = getEmployees()
        setContent {
            EmployeeScreen(employees) { employee ->
                val fragment: Fragment = EmployeeInfoFragment()
                val bundle = Bundle()
                bundle.putString("responsibilities", employee.responsibilities)
                bundle.putString("fio", employee.fio)
                bundle.putString("post", employee.post)
                bundle.putInt("photo", employee.photo)
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