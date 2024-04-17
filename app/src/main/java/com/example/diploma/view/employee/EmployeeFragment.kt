package com.example.diploma.view.employee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diploma.R;
import com.example.diploma.model.Employee;

import java.util.ArrayList;
import java.util.Random;

public class EmployeeFragment extends Fragment {

    TextView tw11;
    TextView description3;

    ArrayList<Employee> states = new ArrayList<Employee>();

    int[] images = {
            R.drawable.man4, R.drawable.man, R.drawable.man2,R.drawable.man5,R.drawable.man7,R.drawable.man8,R.drawable.men,R.drawable.men2,R.drawable.men1 };

    Random r1=new Random();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee, container, false);
        String text = getArguments().getString("key");
        String description = getArguments().getString("cap");
        tw11 = view.findViewById(R.id.tw1);
        description3 = view.findViewById(R.id.description1);
        tw11.setText(text);
        description3.setText(description);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setInitialData();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_employee);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));
        // создаем адаптер
        EmployeeAdapter adapter = new EmployeeAdapter(states,getParentFragmentManager());
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));

        super.onViewCreated(view, savedInstanceState);
    }

    private void setInitialData() {
        states.add(new Employee(randomFi0(), randomDolznost(),"Организовывает рабочие процессы в команде", getRandomCard()));
        states.add(new Employee(randomFi0(), randomDolznost(),"Отвечает за стратегическое развитие основного продукта", getRandomCard()));
        states.add(new Employee(randomFi0(), randomDolznost(),"Заряжает позитивом на целый день и не дает соскучиться",getRandomCard()));
        states.add(new Employee(randomFi0(), randomDolznost(),"Контролирует важные стратегические решения в компании",getRandomCard()));
        states.add(new Employee(randomFi0(), randomDolznost(),"Организовывает встречи с лидерами отделов и предприятий",getRandomCard()));
        states.add(new Employee(randomFi0(), randomDolznost(),"Помогает компании достичь своих финансовых и маркетинговых целей, используя инновационный технологический подход",getRandomCard()));
        states.add(new Employee(randomFi0(), randomDolznost(),"Управляет всеми сферами деятельности, поэтому он несёт полную законодательную ответственность за работу компании и её последствия",getRandomCard()));
    }

    public int getRandomCard() {
        return this.images[r1.nextInt(8)];
    }


    public String randomDolznost(){
        String finalname;

        Random generate = new Random();
        String[] name = {"TeamLead", "CTO", "Senior", "Middle","Junior","CEO","Тестировщик","DevOps","Завхох"};

        finalname = name[generate.nextInt(8)];
        return finalname;
    }

    public String randomFi0(){
        String finalname;

        Random generate = new Random();
        String[] name = {"Виктор", "Алексей", "Владимир", "Евгений","Антон","Сергей","Данил","Жорж","Владислав"};
        String[] surname = {"Фролов", "Кулагин", "Дмитриев", "Ткачев","Павлов","Котов","Козлов","Иванов","Поляков"};

        finalname = name[generate.nextInt(8)]+ " " +surname[generate.nextInt(8)];
        return finalname;
    }
}