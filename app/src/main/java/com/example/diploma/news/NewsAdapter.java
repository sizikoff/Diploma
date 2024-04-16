package com.example.diploma.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diploma.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{


    public final List<News> states;
    public FragmentManager fragmentManager;


    public NewsAdapter(List<News> states, FragmentManager fragmentManager) {
        this.states = states;
        this.fragmentManager = fragmentManager;

    }
    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        News state = states.get(position);
        holder.title.setText(state.getUrl());
        holder.img.setImageResource(state.getAuthor());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new NewsAboutFragment();
                Bundle bundle = new Bundle();
                bundle.putString("desc", state.getSection());
                bundle.putString("title", state.getUrl());
                bundle.putInt("author", state.getAuthor());
                fragment.setArguments(bundle);

                // Замените текущий фрагмент на новый
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
            }
       });
    }

    @Override
    public int getItemCount() {
        return states.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img;
        ViewHolder(View view){
            super(view);
            title = view.findViewById(R.id.title);
            img = view.findViewById(R.id.foto_news1);
        }
    }
}
