package com.ryzhovdd.expensecalculator;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    void insert(Note note);

    @Query("SELECT * FROM notes WHERE groupId = :groupId")
    LiveData<List<Note>> getNotesByGroupId(int groupId); // Измените на LiveData
}



