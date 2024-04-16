package com.example.diploma.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.diploma.R;


public class NewsAboutFragment extends Fragment {

    TextView title1,section1;
    ImageView foto_news;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_news_about, container, false);

        title1 = view.findViewById(R.id.title1);
        section1 = view.findViewById(R.id.section1);
        foto_news = view.findViewById(R.id.foto_news);

        String text = getArguments().getString("title");
        int author = getArguments().getInt("author");
        String descript = getArguments().getString("desc");

        title1.setText(text);
        foto_news.setImageResource(author);
        section1.setText(descript);

        return view;
    }
}