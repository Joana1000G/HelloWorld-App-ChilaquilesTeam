package com.example.hellochilaquilesteam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hellochilaquilesteam.models.Food;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerListFood;
    private ArrayList<Food> listFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerListFood = findViewById(R.id.recyclerListFood);

        LinearLayoutManager acomodador = new LinearLayoutManager(this);
        recyclerListFood.setLayoutManager(acomodador);

        Food chilaquiles = new Food(1, "Chilaquiles", "Muy ricos" );

        Food quekas = new Food()



    }
}