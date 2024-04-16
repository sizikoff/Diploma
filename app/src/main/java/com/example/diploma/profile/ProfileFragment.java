package com.example.diploma.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.diploma.MainActivity;
import com.example.diploma.R;
import com.example.diploma.WebViewActivity;


public class ProfileFragment extends Fragment {

    TextView fio,tw;
    ImageView foto;
    TextView obyazannosti;
    TextView contact;

    Button button;
    Button webview1;
    Button letter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        // Inflate the layout for this fragment

        fio = view.findViewById(R.id.fio_profile);
        obyazannosti = view.findViewById(R.id.dolznost_profile);
        foto = view.findViewById(R.id.foto_profile);
        contact = view.findViewById(R.id.contact1);
        button = view.findViewById(R.id.exit);
        webview1 = view.findViewById(R.id.webview12);
        letter = view.findViewById(R.id.letter);
        fio.setText("Сазонтов Василий Дмитриевич");
        foto.setImageResource(R.drawable.man5);
        obyazannosti.setText("Айтишник");
        contact.setText("+7 (914) 558-99-96");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        webview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), WebViewActivity.class);
                startActivity(intent);
            }
        });

        letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEmail = new Intent(Intent.ACTION_SENDTO);
                Uri uri = Uri.parse("mailto:info@dis-group.ru");
                intentEmail.setData(uri);
                startActivity(intentEmail);
            }
        });



        return view;
    }

}