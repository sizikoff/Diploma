package com.example.diploma.view.main;

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
import com.example.diploma.model.Division;
import com.example.diploma.view.employee.EmployeeFragment;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder>{


    public final List<Division> states;
    public FragmentManager fragmentManager;


    public StateAdapter(List<Division> states, FragmentManager fragmentManager) {
        this.states = states;
        this.fragmentManager = fragmentManager;

    }
    @NonNull
    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateAdapter.ViewHolder holder, int position) {
        Division state = states.get(position);
        holder.flagView.setImageResource(state.getIcon());
        holder.nameView.setText(state.getTitle());

        holder.itemView.setOnClickListener(v -> {
            Fragment fragment = new EmployeeFragment();
            Bundle bundle = new Bundle();
            bundle.putString("key", state.getTitle());
            bundle.putString("cap", state.getDescription());
            fragment.setArguments(bundle);

            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView nameView;
        ViewHolder(View view){
            super(view);
            flagView = view.findViewById(R.id.flag);
            nameView = view.findViewById(R.id.name);
        }
    }
}
