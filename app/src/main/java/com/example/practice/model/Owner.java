package com.example.practice.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "owners",primaryKeys = {"dogid","ownerid"},
foreignKeys = @ForeignKey(entity = Dog.class,parentColumns = "dogid",childColumns = "dogid",
        onDelete = ForeignKey.CASCADE),indices = {@Index("dogid")}
)
public class Owner {
    @ColumnInfo(name="dogid")
    @NonNull
    private String DogId;

    @ColumnInfo(name="name")
    @NonNull
    private String OwnerName;

    @ColumnInfo(name="dept")
    @NonNull
    private String Dept;

    @ColumnInfo(name="ownerid")
    @NonNull
    private String OwnerId;

    public Owner(@NonNull String dogId, @NonNull String ownerName, @NonNull String dept, @NonNull String ownerId) {
        DogId = dogId;
        OwnerName = ownerName;
        Dept = dept;
        OwnerId = ownerId;
    }

    public Owner() {
    }

    @NonNull
    public String getDogId() {
        return DogId;
    }

    public void setDogId(@NonNull String dogId) {
        DogId = dogId;
    }

    @NonNull
    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(@NonNull String ownerName) {
        OwnerName = ownerName;
    }

    @NonNull
    public String getDept() {
        return Dept;
    }

    public void setDept(@NonNull String dept) {
        Dept = dept;
    }

    @NonNull
    public String getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(@NonNull String ownerId) {
        OwnerId = ownerId;
    }
}
