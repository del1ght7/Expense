package com.ryzhovdd.expensecalculator;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<MyItem> itemList;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Инициализация базы данных
        db = AppDatabase.getDatabase(this);

        // Инициализация RecyclerView
        recyclerView = findViewById(R.id.cardRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Инициализация списка элементов
        itemList = new ArrayList<>();
        adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);

        // Найти кнопку добавления
        Button addButton = findViewById(R.id.addButton);

        // Обработчик нажатия на кнопку "Добавить группу"
        addButton.setOnClickListener(v -> {
            // Генерация нового идентификатора
            int newId = itemList.size(); // Здесь используется текущий размер списка как идентификатор
            MyItem newItem = new MyItem(newId, "Новая группа", "Описание группы");
            itemList.add(newItem); // Добавляем группу в список
            adapter.notifyDataSetChanged(); // Обновляем адаптер

            // Сохранение группы в базе данных
            // Замените на вашу логику сохранения группы
        });
    }

}
