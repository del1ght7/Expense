package com.ryzhovdd.expensecalculator;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RectangleAdapter extends RecyclerView.Adapter<RectangleAdapter.RectangleViewHolder> {

    private List<Note> notes; // Список заметок
    private Context context;   // Контекст для использования в адаптере

    // Изменяем конструктор
    public RectangleAdapter(Context context, List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public RectangleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rectangle, parent, false);
        return new RectangleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RectangleViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.textView.setText(note.getContent());
        holder.amountView.setText(String.format("%.2f", note.getPrice()));
        holder.currencyView.setText("BYN");

        // Добавляем обработчик нажатия на элемент CardView
        holder.itemView.setOnClickListener(v -> {
            // Интент для перехода на новую активность NoteActivity
            Intent intent = new Intent(context, NoteActivity.class);
            intent.putExtra("groupId", note.getGroupId()); // Передаем groupId в качестве идентификатора
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void updateNotes(List<Note> newNotes) {
        this.notes = newNotes;
        notifyDataSetChanged();
    }

    public static class RectangleViewHolder extends RecyclerView.ViewHolder {
        TextView textView, amountView, currencyView;

        public RectangleViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            amountView = itemView.findViewById(R.id.amountView);
            currencyView = itemView.findViewById(R.id.currencyView);
        }
    }
}
