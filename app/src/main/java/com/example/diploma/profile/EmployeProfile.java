package com.example.diploma.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.diploma.R;


public class EmployeProfile extends Fragment {

    TextView fio;
    ImageView foto;
    TextView obyazannosti;
    TextView contact;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_employe_profile, container, false);

        String text = getArguments().getString("fio");
        String description = getArguments().getString("obyazannost");
        Integer foto1 = getArguments().getInt("foto");
        fio = view.findViewById(R.id.fio1);
        obyazannosti = view.findViewById(R.id.dolznost1);
        foto = view.findViewById(R.id.foto1);
        contact = view.findViewById(R.id.contact);
        fio.setText(text);
        foto.setImageResource(foto1);
        obyazannosti.setText(description);
        contact.setText("+7 (914) 558-99-96");

        return view;
    }
}