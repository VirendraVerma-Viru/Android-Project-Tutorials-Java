package com.example.festivalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Diwali extends AppCompatActivity {

    ImageView bulb1,bulb2,bulb3,bulb4,bulb5,chakri;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diwali);

        bulb1=findViewById(R.id.diwalilight1);
        bulb2=findViewById(R.id.diwalilight2);
        bulb3=findViewById(R.id.diwalilight3);
        bulb4=findViewById(R.id.diwalilight4);
        bulb5=findViewById(R.id.diwalilight5);
        chakri=findViewById(R.id.chakri);

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.scale);
        Animation animationroation= AnimationUtils.loadAnimation(this,R.anim.rotation);

        chakri.startAnimation(animationroation);
        bulb1.startAnimation(animation);
        bulb2.startAnimation(animation);
        bulb3.startAnimation(animation);
        bulb4.startAnimation(animation);
        bulb5.startAnimation(animation);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.test);





    }
boolean t=false;
    

    public void BombMusic(View view) {
        if(!t){
            mediaPlayer.start();
        }else{

            mediaPlayer.stop();
        }

        //super.onPause();
    }
}
