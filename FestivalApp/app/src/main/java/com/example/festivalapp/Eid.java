package com.example.festivalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Eid extends AppCompatActivity {

    ImageView prayboy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eid);

        prayboy=findViewById(R.id.prayboy);

        Animation ani= AnimationUtils.loadAnimation(this,R.anim.translate);

        prayboy.startAnimation(ani);
    }
}
