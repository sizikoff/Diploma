package com.example.diploma.view.employee;

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
import com.example.diploma.model.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder>{


    private final List<Employee> states;
    private final FragmentManager fragmentManager;


    EmployeeAdapter(List<Employee> states, FragmentManager fragmentManager) {
        this.states = states;
        this.fragmentManager = fragmentManager;

    }
    @NonNull
    @Override
    public EmployeeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_employe, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.ViewHolder holder, int position) {
        Employee state = states.get(position);
        holder.foto.setImageResource(state.getPhoto());
        holder.fio.setText(state.getFio());
        holder.dolzhnost.setText(state.getPost());


        holder.itemView.setOnClickListener(v -> {
            Fragment fragment = new EmployeeInfoFragment();
            Bundle bundle = new Bundle();
            bundle.putString("fio", state.getFio());
            bundle.putString("obyazannost", state.getResponsibilities());
            bundle.putInt("foto", state.getPhoto());
            fragment.setArguments(bundle);

            // Замените текущий фрагмент на новый
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
        final ImageView foto;
        final TextView fio,dolzhnost;
        ViewHolder(View view){
            super(view);
            foto = view.findViewById(R.id.foto);
            fio = view.findViewById(R.id.fio);
            dolzhnost = view.findViewById(R.id.dolznost);
        }
    }
}
