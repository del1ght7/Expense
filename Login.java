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

public class Login extends AppCompatActivity {
    private EditText emailText;
    private EditText passwordText;
    private Button login;
    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_activity);
        initViews();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем текст из полей ввода
                String email = emailText.getText().toString().trim();
                String password = passwordText.getText().toString().trim();

                // Проверка заполненности полей
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Login.this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                } else {
                    // Создаем Intent для перехода на MainActivity
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Закрываем LoginActivity, чтобы пользователь не мог вернуться к ней нажав "Назад"
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void initViews() {
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
    }
}