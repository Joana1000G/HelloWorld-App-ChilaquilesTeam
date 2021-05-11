package com.example.hellochilaquilesteam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView menuNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fedd_main);

        menuNavigation = findViewById(R.id.bottomNavigationView);
        menuNavigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.option_home) {
            navigateToScreen();

        } else if (item.getItemId()== R.id.option_pets) {

        } else if (item.getItemId() == R.id.option_settings) {

        }
        return true;

    }
    public void navigateToScreen() {
        Intent intentScreen = new Intent(MainActivity2.this,ListActivity.class);
        startActivity(intentScreen);
    }
}