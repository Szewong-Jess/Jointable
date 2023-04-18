package com.example.practice.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.practice.interfaces.DogDao;
import com.example.practice.interfaces.JoinDao;
import com.example.practice.interfaces.OwnerDao;
import com.example.practice.model.Dog;
import com.example.practice.model.Owner;
import com.example.practice.model.OwnerJoinTable;

@Database(entities = {Dog.class, Owner.class}, version = 2,exportSchema = false)
public abstract class Dogdatabase extends RoomDatabase {

    public abstract DogDao dogDao();
    public abstract OwnerDao ownerDao();

    public abstract JoinDao ownerJoinDao();
}
