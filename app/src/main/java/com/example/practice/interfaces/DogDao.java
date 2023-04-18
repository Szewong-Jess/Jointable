package com.example.practice.interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.practice.model.Dog;

import java.util.List;

@Dao
public interface DogDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void InsertDogs(List<Dog> dogs);

    @Query("SELECT * FROM dogs")
    List<Dog> GetAllDogs();
}
