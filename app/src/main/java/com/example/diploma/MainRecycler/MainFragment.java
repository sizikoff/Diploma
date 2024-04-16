package com.example.diploma.MainRecycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diploma.R;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    ArrayList<Divisions> states = new ArrayList<Divisions>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setInitialData();
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));
        // создаем адаптер
        StateAdapter adapter = new StateAdapter(states,getParentFragmentManager());
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
        super.onViewCreated(view, savedInstanceState);
    }

    private void setInitialData() {
        states.add(new Divisions ("Консалтинг", "Консультирование предприятий, руководителей и управленческих кадров по разным вопросам", R.drawable.ico1));
        states.add(new Divisions ("Маркетинг", "Ставим своей целью получение прибыли с помощью удовлетворения потребностей покупателей", R.drawable.ico2));
        states.add(new Divisions ("Бухгалтерия", "Ведем  бухгалтерский учёт в компании, занимаемся документооборотом", R.drawable.ico3));
        states.add(new Divisions ("Клиентский сервис", "Помогаем компании обращаться со своими клиентами и решать их проблемы", R.drawable.ico4));
        states.add(new Divisions ("Бизнес-поддержка", "Реализуем важную функцию получения обратной связи от пользователей", R.drawable.ico5));
        states.add(new Divisions ("Разработка", "Создание программного обеспечения, приложений для смартфонов, сайтов.", R.drawable.ica));
    }
}