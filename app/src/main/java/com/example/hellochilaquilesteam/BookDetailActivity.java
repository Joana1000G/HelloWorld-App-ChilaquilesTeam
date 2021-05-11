package com.example.hellochilaquilesteam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BookDetailActivity extends AppCompatActivity {

    private String bookId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        //TODO falta implementar como obtener un valor de otra pantalla
        //Por envio de valores
        //Stores
        bookId = "u4197sfxt-fa214";

        Button btnComments = findViewById(R.id.btnComments);
        btnComments.setOnClickListener(this::navigateToCommentsFragments);

    }

    public void navigateToCommentsFragments(View view) {
        //Creamos un objeto para la ventana de comentarios que se va a mostrar
        CommentListFragment fragmentWindow= CommentListFragment.newInstance(bookId);

        //Obtenemos un objeto administrador de Fragmentos
        //Significa que es un objeto que quita y pone fragmentos (ventanas)
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Mostramos la ventana fragmento por medio de decirle quien la administra
        // y como se llama
        fragmentWindow.show(fragmentManager, "Comments_dialog");
    }
}