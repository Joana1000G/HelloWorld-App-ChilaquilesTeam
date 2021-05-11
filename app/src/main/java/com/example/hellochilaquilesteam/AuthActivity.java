package com.example.hellochilaquilesteam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

import android.content.Intent;


public class AuthActivity extends AppCompatActivity {

    //Variables de Instancia tienen relación con la pantalla
    private EditText editTextUsername; // Lenguaje fuertemente tipado
    private EditText editTextPassword;
    private Button btnLogin;
    private Button btnSingUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buscar los elementos visules para meterlos a los objetos (inflate (inflado))

        // Cajas de texto - interaccion: escribir texto y va a ser tomado
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

        // Botones - interaccion: dar click para navegar a otra pantalla
        btnLogin = findViewById(R.id.btnLogin);
        btnSingUp = findViewById(R.id.btnSingUp);

        //Asignación de una acción al botón cuando se toca
        // Asignación de evento
        btnLogin.setOnClickListener(this::clickLogin);
        btnSingUp.setOnClickListener(this::navigateToSingUp);
    }

    private void clickLogin(View view) {
        //Asignación de valores iniciales a las variables
        String username = ""; // asignación de valor vacío
        String password = "";

        // Tomar los valores dde las cajas de texto

        // get [nombre del atributo] = obtener el valor
        // set [nombre del atributo] = guarda el valor
        username = editTextUsername.getText().toString().trim();
        password = editTextPassword.getText().toString();

        // Analisis o procesamiento

        // Tablas de verdad
        // si es un 'AND' con otro verdadero = Verdadero
        // 'AND' verdadero y Falso = Falso
        // 'AND' Falso, Falso = Falso
        // 'OR' verdadero, verdadero = verdadero
        // 'OR' verdadero, Falso = verdadero
        // 'OR' Falso, Falso = Falso

        // Operodores Lógicos
        // ! not
        // && and
        // || or

        if(username.equals("Joana100G") && password.equals("651013")) {

            // TODO Llamar a una acción para registrar que ya se inició sesión

            // llamar a la acción para cambiar de pantalla
            navigateToHome();
        } else {
            Toast.makeText( this, "Datos Incorrectos", Toast.LENGTH_SHORT).show();
        }

    }

    private void navigateToSingUp(View view) {
        Intent intentSingUp = new  Intent(AuthActivity.this,SingUpActivity.class);
        startActivity(intentSingUp);

    }

    private void navigateToHome() {
        // Creo la intenion de abrir el home  desde la loing activity
        Intent intentHome = new Intent(AuthActivity.this,MainActivity2.class); // Constructor predeterminado o parametrisado (ciertos atributos)

        // Ir a la nueva pantalla a la que queremos ir
        startActivity(intentHome);


    }
}