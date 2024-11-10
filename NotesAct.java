package com.ryzhovdd.expensecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAct extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RectangleAdapter adapter;
    private AppDatabase db;
    private int groupId; // ID группы, к которой принадлежат заметки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note); // Измените на ваше имя layout

        // Получите ID группы из Intent
        groupId = getIntent().getIntExtra("groupId", -1);

        // Инициализация базы данных
        db = AppDatabase.getDatabase(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Инициализация адаптера с передачей контекста
        adapter = new RectangleAdapter(this, new ArrayList<>()); // Начинаем с пустого списка
        recyclerView.setAdapter(adapter);

        // Получение заметок для определенной группы
        db.noteDao().getNotesByGroupId(groupId).observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                // Обновляем адаптер с новыми заметками
                adapter.updateNotes(notes);
            }
        });

        // Обрабатываем нажатие на кнопку "Добавить заметку"
        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(NotesAct.this, NoteActivity.class);
            intent.putExtra("groupId", groupId); // Передаем groupId в качестве идентификатора
            startActivity(intent);
        });
    }
}
