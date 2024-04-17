package com.example.diploma.view.employee

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.diploma.R

class EmployeeInfoFragment : Fragment() {
    private lateinit var fio: TextView
    private lateinit var foto: ImageView
    private lateinit var obyazannosti: TextView
    private lateinit var contact: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(
        R.layout.fragment_employe_profile, container, false
    ).apply {
        assert(arguments != null)
        obyazannosti = findViewById(R.id.dolznost1)
        contact = findViewById(R.id.contact)
        foto = findViewById(R.id.foto1)
        fio = findViewById(R.id.fio1)

        obyazannosti.text = arguments?.getString("obyazannost")
        fio.text = arguments?.getString("fio")
        contact.text = "+7 (914) 558-99-96"
        arguments?.getInt("foto")?.let {
            foto.setImageResource(it)
        }
    }
}