package com.example.alphabetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button alphabet;
    Button number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number=findViewById(R.id.number);
        alphabet=findViewById(R.id.alphabet);
        alphabet.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this,Alphabet.class);
        startActivity(intent);
    }

    public void NumberButton(View view) {
        Intent intent=new Intent(this,Number.class);
        startActivity(intent);
    }
}
