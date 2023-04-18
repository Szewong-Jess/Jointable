package com.example.practice.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import com.example.practice.R;
import com.example.practice.database.Dogdatabase;
import com.example.practice.interfaces.DogDao;
import com.example.practice.interfaces.OwnerDao;
import com.example.practice.model.Dog;
import com.example.practice.model.Owner;
import com.example.practice.model.OwnerJoinTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NextActivity extends AppCompatActivity {

    Dogdatabase odb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        List<Owner> OwnerFromFile = readOwnerCSV();
        StringBuilder outputText = new StringBuilder();
        TextView joinText = findViewById(R.id.textViewDogAndOwner);


        odb = Room.databaseBuilder(getApplicationContext(), Dogdatabase.class,"dogs.db").build();

        OwnerDao onwerDao = odb.ownerDao();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                onwerDao.InsertOwners(OwnerFromFile);

                List<OwnerJoinTable> ownerJoin = odb.ownerJoinDao().GetDogsAndOwners();
                for(OwnerJoinTable od:ownerJoin){
                    outputText.append(String.format("%-10s%-10s\n",od.getOwnerName(),od.getDogName()));
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        joinText.setText(outputText);
                    }
                });

            }
        });
    }


    private List<Owner> readOwnerCSV(){
        List<Owner> OwnerList = new ArrayList<>();
        InputStream inputStream = getResources().openRawResource(R.raw.students);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try{
            String ownerLine;
            while ((ownerLine=reader.readLine())!=null){
                String[] eachOwnerField = ownerLine.split(",");

                Owner eachOwner = new Owner(eachOwnerField[0],eachOwnerField[1],eachOwnerField[2],eachOwnerField[3]);
                OwnerList.add(eachOwner);
            }
        }catch (IOException ex){
            throw new RuntimeException("Error reading file");
        }finally {
            try{
                inputStream.close();
            }catch (IOException ex){
                throw new RuntimeException("Error closing file");
            }
        }
        return OwnerList;

    }
}