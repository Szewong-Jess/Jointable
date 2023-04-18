package com.example.practice.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.practice.R;
import com.example.practice.adapter.DogAdapter;
import com.example.practice.database.Dogdatabase;
import com.example.practice.databinding.ActivityMainBinding;
import com.example.practice.interfaces.DogDao;
import com.example.practice.model.Dog;
import com.example.practice.model.Owner;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Dogdatabase ddb;
    Button btnNext;

    @Override
    @RequiresApi(api= Build.VERSION_CODES.O)
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        List<Dog> DogFromFile = readDogCSV();
        ddb = Room.databaseBuilder(getApplicationContext(),Dogdatabase.class,"dogs.db").build();
        DogDao dogDao = ddb.dogDao();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        binding.recyclerViewDog.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                dogDao.InsertDogs(DogFromFile);
                List<Dog> AllDBDogs = dogDao.GetAllDogs();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DogAdapter adapter = new DogAdapter(AllDBDogs);
                        binding.recyclerViewDog.setAdapter(adapter);
                    }
                });
            }
        });


        btnNext = findViewById(R.id.buttonNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NextActivity.class));
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private List<Dog> readDogCSV(){
        List<Dog> DogsList = new ArrayList<>();
        InputStream inputStream = getResources().openRawResource(R.raw.grades);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try{
            String doglines;
            while ((doglines=reader.readLine())!=null){
                String[] eachdogField = doglines.split(",");
                int dogDrawable = getResources().getIdentifier(eachdogField[1],"drawable",getPackageName());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
                LocalDate dob = LocalDate.parse(eachdogField[4],formatter);
                String formattedDob = dob.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                Dog eachDog = new Dog(eachdogField[0],dogDrawable,eachdogField[2],eachdogField[3],formattedDob);
                DogsList.add(eachDog);
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
        return DogsList;
    }



}