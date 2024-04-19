package com.example.diploma.view.employee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.diploma.R
import com.example.diploma.model.Employee

class EmployeeInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        arguments?.apply {
            val responsibilities = getString("responsibilities") ?: ""
            val fio = getString("fio") ?: ""
            val post = getString("post") ?: ""
            val photo = getInt("photo")
            val employee = Employee(fio, post, responsibilities, photo)
            setContent { EmployeeInfoScreen(employee) }
        } ?: run {
            @Suppress("DEPRECATION")
            requireFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, EmployeeFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
        }
    }
}