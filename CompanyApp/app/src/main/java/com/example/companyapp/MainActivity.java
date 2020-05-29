package com.example.companyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;//used for edditimg shared prefrences

    ImageView loadingImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main );

        loadingImage=findViewById(R.id.loadingicon);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.rotation);
        loadingImage.startAnimation(animation);

        sharedPreferences=getSharedPreferences("registration",MODE_PRIVATE);
        editor=sharedPreferences.edit();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                String ids=sharedPreferences.getString("id",null);
                String passw=sharedPreferences.getString("pass",null);
                String type=sharedPreferences.getString("type",null);

                if(ids==null) {
                    Intent i = new Intent(MainActivity.this, Registration.class);
                    startActivity(i);
                    finish();
                }else{
                    Intent i = new Intent(MainActivity.this, Reception.class);
                    startActivity(i);
                    finish();
                }

            }
        }, 1000);

    }
}
