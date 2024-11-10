package com.ryzhovdd.expensecalculator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<MyItem> itemList;

    // Конструктор адаптера
    public MyAdapter(List<MyItem> itemList) {
        this.itemList = itemList;
    }

    // Внутренний класс ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView descriptionTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewTitle);
            descriptionTextView = itemView.findViewById(R.id.textViewDescription);
        }
    }

    // Создание нового ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cardview, parent, false);
        return new ViewHolder(view);
    }

    // Привязка данных к ViewHolder
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyItem currentItem = itemList.get(position);
        holder.titleTextView.setText(currentItem.getTitle());
        holder.descriptionTextView.setText(currentItem.getDescription());

        // Обработка клика на карточку
        holder.itemView.findViewById(R.id.buttonOpenNote).setOnClickListener(v -> {
            // Интент для открытия активности NoteActivity
            Intent intent = new Intent(holder.itemView.getContext(), NotesAct.class);
            intent.putExtra("groupId", currentItem.getId()); // Передача идентификатора группы
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
