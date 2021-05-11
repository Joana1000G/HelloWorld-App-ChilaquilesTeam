package com.example.hellochilaquilesteam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//Local se usa en todos
public class FirebaseSingUpActivity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPasswordSingUp;
    private EditText editTextConfirmPassword;
    private CheckBox checkBoxSecurityPolitics;
    private Button btnJoin;

    private FirebaseAuth firebaseAuth; //API Firebase Authentication

    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        firebaseAuth = firebaseAuth.getInstance(); //necesitamos recuperar una instancia del serivio

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPasswordSingUp = findViewById(R.id.editTextPasswordSingUp);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        checkBoxSecurityPolitics = findViewById(R.id.checkBoxSecurityPolitics);
        btnJoin = findViewById(R.id.btnJoin);

        btnJoin.setOnClickListener(this:: ClickSingUp);

    }


    //Variables
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

        if (!email.equals("") && !password.equals("") && confirmPassword.equals(password)
                && securityPolitics) {
            //Validación de que la contraseña tenga 6 o más caracteres
           if (password.length() >= 6) {
               if(confirmPassword.equals(password)) {
                   registerUser(email, password);
               }

           } else {
               Toast.makeText(this, "The password needs more than 6 characters",
                       Toast.LENGTH_SHORT).show();
           }

        } else {
            Toast.makeText(this,"Incorrect data",Toast.LENGTH_SHORT).show();
        }

    }

    private void navigateToHome() {
        Intent intentHome = new
                Intent(FirebaseSingUpActivity.this,MainActivity2.class);
        startActivity(intentHome);
    }

    private void registerUser(String email, String passwordSingUp) {

        //Logica para registrar un nuevo usuario
        firebaseAuth.createUserWithEmailAndPassword(email, passwordSingUp)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //Preguntamos si se registro con exito de forma adecuada
                if (task.isSuccessful()) {
                    navigateToHome();
                } else {showMessage("Existio un problema");}
            }
        });

    }
    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}