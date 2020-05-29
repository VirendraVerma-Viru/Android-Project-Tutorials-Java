package com.example.animationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview=findViewById(R.id.imageview);


    }

    public void animateA(View view) {
        Animation animation=AnimationUtils.loadAnimation(this,R.anim.fadeinfadeout);
        Animation animation1=AnimationUtils.loadAnimation(this,R.anim.rotate);
        Animation animation2=AnimationUtils.loadAnimation(this,R.anim.translate);
        imageview.startAnimation(animation);
        imageview.startAnimation(animation1);
        imageview.startAnimation(animation2);

    }

    //animation(we can use in any object)
    //fade
    //rotation
    //scale
    //translate
}
