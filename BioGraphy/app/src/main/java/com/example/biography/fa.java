package com.example.biography;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class fa extends AppCompatActivity {

    TextView fatherText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa2);
        fatherText=findViewById(R.id.myFather);
        String a="My father respects his own\nparents, my mother and each \nmember of my family.\nHe maintains cordial relationsn\nwith our relatives, friends and \nneighbours. He drops me and \nmy sister to school and my \nmother to work every day.\nHe helps me and my younger \nsister in our studies every day.";
        fatherText.setText(a);
    }

}
