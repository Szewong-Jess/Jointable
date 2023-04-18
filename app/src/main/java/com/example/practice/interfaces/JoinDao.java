package com.example.practice.interfaces;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.practice.model.OwnerJoinTable;

import java.util.List;

@Dao
public interface JoinDao {
    @Query("SELECT dogname,name FROM dogs INNER JOIN owners "+"WHERE dogs.dogid=owners.dogid")
    List<OwnerJoinTable> GetDogsAndOwners();
}
