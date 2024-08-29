package com.example.javasql;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    EditText firstname, lastname, username;
    Button enter;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        firstname = findViewById(R.id.firstName);
        lastname = findViewById(R.id.lastName);
        username = findViewById(R.id.userName);
        enter = findViewById(R.id.enterButton);
         enter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity.this);
                myDB.addCred(firstname.getText().toString().trim(),
                            lastname.getText().toString().trim(),
                            username.getText().toString().trim());
            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

}