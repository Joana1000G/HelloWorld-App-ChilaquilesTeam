package com.example.hellochilaquilesteam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.example.hellochilaquilesteam.models.Book;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateBookActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextAuthor;
    private EditText editTextYear;
    private Button btnCreate;

    private FirebaseDatabase firebaseDatabase; //API - Real time Database services
    private DatabaseReference booksReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_book);

        firebaseDatabase = FirebaseDatabase.getInstance(); //Obtener base de datos

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextAuthor = findViewById(R.id.editTextAuthor);
        editTextYear = findViewById(R.id.editTextYear);

        Button btnCreate = findViewById(R.id.btnCreate)
    }

    public void createBook() {
        String title = editTextTitle.getText().toString().trim();
        String Author = editTextAuthor.getText().toString().trim();
        String Year = editTextYear.getText().toString().trim();

        //TODO faltan las validaciones

        Book book = new Book(id 1, title, author, year);

    }

    private void createBookInDatabase(Book book) {
        //Obtenemos donde guardas datos
        //Si no la crea la trae
        booksReference = firebaseDatabase.getReference("Books");

        //Obtenemos Referencia para crear un nuevo libro (espacio que se llena)
        DatabaseReference newBookReference = booksReference.push();

        String key = newBookReference.getKey();//Un valor único

        //Guardar los datos del libro en la key
        booksReference.child(key).setValue(book).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    showMessage("Se guardó el libro correctamente");
                } else {
                    showMessage("Error al guardar ellibro");
                }
            }
        });
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}