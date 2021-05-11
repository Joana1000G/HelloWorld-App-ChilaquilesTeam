package com.example.hellochilaquilesteam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hellochilaquilesteam.models.Food;
import com.example.hellochilaquilesteam.models.FoodAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.AbstractSequentialList;
import java.util.ArrayList;

public class ListActivity
        extends AppCompatActivity implements FoodAdapter.OnItemClickListener {

    private RecyclerView recyclerListFood;
    private ArrayList<Food> listFood;

    //Firebase
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference foodReference;

    private FoodAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        firebaseDatabase = FirebaseDatabase.getInstance();

        recyclerListFood = findViewById(R.id.recyclerListFood);

        LinearLayoutManager acomodador = new LinearLayoutManager(this);
        recyclerListFood.setLayoutManager(acomodador);

        Food chilaquiles = new Food(1, "Chilaquiles", "Muy ricos" );
        Food chilaquilesVerdes = new Food(2, "Chilaquiles", "Muy ricos" );

        //Guardar en la lista
        listFood.add(chilaquiles);
        listFood.add(chilaquilesVerdes);

        adapter = new FoodAdapter(listFood, this);

        recyclerListFood.setAdapter(adapter);
        getFood();

    }

    //Crea y muestra una ventana como un dialogo (botton sheet) que sale de abajo
    private void showFoodDetailsDialog(int id) {
        FoodDetallDialogFragment.newInstance(id).show(
                getSupportFragmentManager(), "food_detail_dialog");
    }


    @Override
    public void onItemClick(Food food) {
        int foodId = food.getId();
        showFoodDetailsDialog(foodId);
    }

    private void  getFood() {
        foodReference = firebaseDatabase.getReference("food");
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Food food = snapshot.getValue(Food.class);
                adapter.addFood(food);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        //Registrar para que escuche los
        foodReference.addValueEventListener(valueEventListener);

    }

}