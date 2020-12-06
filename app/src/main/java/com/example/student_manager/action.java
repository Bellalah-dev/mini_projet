package com.example.student_manager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class action extends AppCompatActivity {
    Button u,d;
    EditText n,c;
    int position;
    params p=new params();
    HashMap<String,String> m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear);

        u=findViewById(R.id.update);
        d=findViewById(R.id.delete);
        n=findViewById(R.id.anom);
        c=findViewById(R.id.aclasse);

        Bundle extras=getIntent().getExtras();

        if(extras!=null){
            position=extras.getInt("position");
        }


        m=p.values.get(position);
        n.setText(m.get("nom"));
        c.setText(m.get("classe"));


        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(n.getText().toString().equals("")|| c.getText().toString().equals(""))){
                    m.put("nom",n.getText().toString());
                    m.put("classe",c.getText().toString());
                    Intent i=new Intent(getApplicationContext(),Students.class);
                    startActivity(i);
                    finish();
            } else
                {
                    AlertDialog.Builder alert=new AlertDialog.Builder(action.this);
                    alert.setTitle("empty field !");
                    alert.setMessage("aie! you forgot to change a field please verify your informations!");
                    alert.setNegativeButton("ok",null);
                    alert.show();
                }
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.values.remove(position);
                Intent i=new Intent(getApplicationContext(),Students.class);
                startActivity(i);
                finish();

            }
        });

    }
}