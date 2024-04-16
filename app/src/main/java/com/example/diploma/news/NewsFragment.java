package com.example.diploma.news;

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
import java.util.GregorianCalendar;
import java.util.*;



public class NewsFragment extends Fragment {

    ArrayList<News> states = new ArrayList<>();

    int[] images = {
            R.drawable.mark, R.drawable.serv, R.drawable.news,R.drawable.bugal,R.drawable.cons };

    Random r1=new Random();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news, container, false);
        // Inflate the layout for this fragment


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        setInitialData();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_news);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));
        // создаем адаптер
        NewsAdapter adapter = new NewsAdapter(states,getParentFragmentManager());
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));

        super.onViewCreated(view, savedInstanceState);
    }

    private void setInitialData() {
        states.add(new News("Консультирование",getRandomCard(),"Будет довольно прохладно.Новости на неделе:сегодня в городе произошел крупный пожар в районе Клинтон"));
        states.add(new News("Отмечвем день рождения начальника",getRandomCard(),"Сегодня сообщили точную дату выхода всеми ожидаемой игры Spore 2"));
        states.add(new News("Совещание по вопросам дверного нейминга",getRandomCard(),"Следующее в программе:Осуждение мемов в интернете"));
        states.add(new News("Турнир по футболу.Не опаздывайте",getRandomCard(),"Следующее в программе:Интервью с котом - только не пропустите!"));
        states.add(new News("Поднимите зарплату",getRandomCard(),"Новый фильм \"Рвущий\" рвёт все кинотеатры города и сборы фильма превысили 120 миллионов долларов\n"));
        states.add(new News("Сбережения",getRandomCard(),"Был построен новый жилой комплекс \"Дубовый\""));
        states.add(new News("Аналитики на выезде",getRandomCard(),"Следующее в программе:Обсуждение матча в спорте"));
        states.add(new News("Интервью с лидерами предприятия",getRandomCard(),"\n" +
                "Сегодня торжественная дата - День Города!"));


    }

    public int getRandomCard() {
        return this.images[r1.nextInt(4)];
    }

    public String division(){
        String finalname;

        Random generate = new Random();
        String[] name = {"Разработка", "Консалтинг", "Бухгалтерия", "ГеймДев","Тестирование","Завхоз","Маркетинг","Бизнес-поддержка"};

        finalname = name[generate.nextInt(7)];
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

    public String RandomDateTime (){
        String finalDate = "";

        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(2012,2024);
        gc.set(GregorianCalendar.YEAR,year);gc.set(GregorianCalendar.YEAR,year);
        int day = randBetween(1, gc.getActualMaximum(gc.DAY_OF_MONTH));
        gc.set(GregorianCalendar.DAY_OF_YEAR,year);
        finalDate =gc.get(GregorianCalendar.YEAR) + "-"+ gc.get(GregorianCalendar.MONTH + 1) + "-"+gc.get(GregorianCalendar.DAY_OF_MONTH);

        return finalDate;
    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}