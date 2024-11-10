package com.ryzhovdd.expensecalculator;

public class MyItem {
    private int id;  // Добавьте поле id
    private String title;
    private String description;

    // Конструктор
    public MyItem(int id, String title, String description) {
        this.id = id;  // Инициализация id
        this.title = title;
        this.description = description;
    }

    // Геттер для id
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
