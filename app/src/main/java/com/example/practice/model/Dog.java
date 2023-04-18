package com.example.practice.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NonNls;

@Entity(tableName="dogs")
public class Dog {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name="dogid")
    private String Dogid;

    @NonNull
    @ColumnInfo(name="dogpic")
    private int DogPic;

    @NonNull
    @ColumnInfo(name="dogtype")
    private String DogType;

    @NonNull
    @ColumnInfo(name="dogname")
    private String DogName;

    @NonNull
    @ColumnInfo(name="dogddob")
    private String DogDob;

    public Dog(@NonNull String dogid, int dogPic, @NonNull String dogType, @NonNull String dogName, @NonNull String dogDob) {
        Dogid = dogid;
        DogPic = dogPic;
        DogType = dogType;
        DogName = dogName;
        DogDob = dogDob;
    }

    public Dog() {
    }

    @NonNull
    public String getDogid() {
        return Dogid;
    }

    public void setDogid(@NonNull String dogid) {
        Dogid = dogid;
    }

    public int getDogPic() {
        return DogPic;
    }

    public void setDogPic(int dogPic) {
        DogPic = dogPic;
    }

    @NonNull
    public String getDogType() {
        return DogType;
    }

    public void setDogType(@NonNull String dogType) {
        DogType = dogType;
    }

    @NonNull
    public String getDogName() {
        return DogName;
    }

    public void setDogName(@NonNull String dogName) {
        DogName = dogName;
    }

    @NonNull
    public String getDogDob() {
        return DogDob;
    }

    public void setDogDob(@NonNull String dogDob) {
        DogDob = dogDob;
    }
}
