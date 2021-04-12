package com.example.hellochilaquilesteam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SingUpActivity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPasswordSingUp;
    private EditText editTextConfirmPassword;
    private CheckBox checkBoxSecurityPolitics;
    private Button btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPasswordSingUp = findViewById(R.id.editTextPasswordSingUp);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        checkBoxSecurityPolitics = findViewById(R.id.checkBoxSecurityPolitics);
        btnJoin = findViewById(R.id.btnJoin);

        btnJoin.setOnClickListener(this:: ClickSingUp);
    }

    private void ClickSingUp (View view) {
        String email = "";
        String password = "";
        String confirmPassword = "";
        boolean securityPolitics = false;
       //TODO preguntar a Leo como rejuntar los datos de la CheckBox

        email = editTextEmail.getText().toString().trim();
        password = editTextPasswordSingUp.getText().toString();
        confirmPassword = editTextConfirmPassword.getText().toString();
        securityPolitics = checkBoxSecurityPolitics.isChecked();


        // Operodores Lógicos
        // ! not
        // && and
        // || or

        if (!email.equals("") && !password.equals("") && confirmPassword.equals(password) && securityPolitics) {
            NavigateToHome();
        } else {
            Toast.makeText(this,"Incorrect data",Toast.LENGTH_SHORT).show();
        }

    }

    private void NavigateToHome() {
        Intent intentHome = new Intent(SingUpActivity.this,MainActivity2.class);
        startActivity(intentHome);
    }
}