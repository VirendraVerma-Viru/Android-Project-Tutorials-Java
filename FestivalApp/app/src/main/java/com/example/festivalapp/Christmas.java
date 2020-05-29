package com.example.festivalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Christmas extends AppCompatActivity {

    ImageView santa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_christmas);

        santa=findViewById(R.id.santa);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.santascale);
        santa.startAnimation(animation);
    }
}
