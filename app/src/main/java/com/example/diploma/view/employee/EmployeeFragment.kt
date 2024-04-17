package com.example.diploma.view.employee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diploma.R
import com.example.diploma.data.DataSource.getEmployees

class EmployeeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_employee, container, false).apply {
        val description3: TextView = findViewById(R.id.description1)
        val tw11: TextView = findViewById(R.id.tw1)

        tw11.text = arguments?.getString("key")
        description3.text = arguments?.getString("cap")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val states = getEmployees()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_employee)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = EmployeeAdapter(states, parentFragmentManager)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(context, VERTICAL))
    }
}