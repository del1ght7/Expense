package com.ryzhovdd.expensecalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NoteActivity extends AppCompatActivity {

    private EditText noteEditPrice;
    private EditText noteEditText;
    private Button addButton;

    private int groupId;  // ID группы, к которой принадлежит заметка
    private AppDatabase db; // База данных

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note2);

        groupId = getIntent().getIntExtra("groupId", -1);
        db = AppDatabase.getDatabase(this);

        initViews();

        addButton.setOnClickListener(v -> {
            String content = noteEditText.getText().toString();
            float price = Float.parseFloat(noteEditPrice.getText().toString());

            Note newNote = new Note(groupId, content, price);
            db.noteDao().insert(newNote); // Сохраняем заметку в базе данных
            finish(); // Закрываем активность после добавления заметки
        });
    }

    private void initViews() {
        noteEditPrice = findViewById(R.id.noteEditPrice);
        noteEditText = findViewById(R.id.noteEditText);
        addButton = findViewById(R.id.addButton);
    }
}
