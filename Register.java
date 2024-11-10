package com.ryzhovdd.expensecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {
    private EditText registerLogin;
    private EditText registerPassword;
    private Button registerDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        initViews();

        registerDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем текст из полей ввода
                String loginReg = registerLogin.getText().toString().trim();
                String passwordReg = registerPassword.getText().toString().trim();

                // Проверка заполненности полей
                if (loginReg.isEmpty() || passwordReg.isEmpty()) {
                    Toast.makeText(Register.this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                } else {
                    // Создаем Intent для перехода на MainActivity
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                    finish(); // Закрываем LoginActivity, чтобы пользователь не мог вернуться к ней нажав "Назад"
                }
            }
        });
    }

    private void initViews() {
        registerLogin = findViewById(R.id.registerLogin);
        registerPassword = findViewById(R.id.registerPassword);
        registerDone = findViewById(R.id.registerDone);
    }
}