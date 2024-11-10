package com.ryzhovdd.expensecalculator;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id; // Сделаем поле private

    private int groupId; // ID группы, к которой принадлежит заметка
    private String content;
    private float price;

    // Конструктор
    public Note(int groupId, String content, float price) {
        this.groupId = groupId;
        this.content = content;
        this.price = price;
    }

    // Геттеры
    public int getId() {
        return id;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getContent() {
        return content;
    }

    public float getPrice() {
        return price;
    }

    // Сеттеры
    public void setId(int id) {
        this.id = id;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
