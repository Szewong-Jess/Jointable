package com.example.practice.interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.practice.model.Dog;
import com.example.practice.model.Owner;

import java.util.List;

@Dao
public interface OwnerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void InsertOwners(List<Owner> owners);
}
