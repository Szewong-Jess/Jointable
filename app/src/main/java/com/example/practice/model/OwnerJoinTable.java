package com.example.practice.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

public class OwnerJoinTable {

    @ColumnInfo(name="dogname")
    @NonNull
    String dogName;

    @ColumnInfo(name="name")
    @NonNull
    String ownerName;

    public OwnerJoinTable() {
    }

    public OwnerJoinTable(@NonNull String dogName, @NonNull String ownerName) {
        this.dogName = dogName;
        this.ownerName = ownerName;
    }

    @NonNull
    public String getDogName() {
        return dogName;
    }

    public void setDogName(@NonNull String dogName) {
        this.dogName = dogName;
    }

    @NonNull
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(@NonNull String ownerName) {
        this.ownerName = ownerName;
    }
}
