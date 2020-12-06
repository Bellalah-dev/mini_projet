package com.example.student_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText nom,classe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.add);
        nom=findViewById(R.id.name);
        classe=findViewById(R.id.classe);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Students.class);
                i.putExtra("nom",nom.getText().toString());
                i.putExtra("classe",classe.getText().toString());
                startActivity(i);
            }
        });
    }
}