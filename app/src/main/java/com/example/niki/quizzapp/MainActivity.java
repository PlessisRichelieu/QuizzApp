package com.example.niki.quizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button easyDif=findViewById(R.id.easy);
        final Button mediumDif=findViewById(R.id.medium);
        final Button hardDif = findViewById(R.id.hard);


        easyDif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent (MainActivity.this, EasyMode.class);
            startActivity(i);
            }
        });

        mediumDif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent (MainActivity.this, MediumMode.class);
                startActivity(a);
            }

        });

        hardDif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b= new Intent (MainActivity.this, HardMode.class);
                startActivity(b);
            }
        });
    }
}
