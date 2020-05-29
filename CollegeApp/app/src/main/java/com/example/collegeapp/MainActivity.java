package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    WebView webview;
    ImageView loadingImage;

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview=findViewById(R.id.webview);
        webview.loadUrl("file:///android_asset/Files/display.html");

        loadingImage=findViewById(R.id.loadingImage);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.rotation);
        loadingImage.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this,
                        HomePage.class);
                //Intent is used to switch from one activity to another.

                startActivity(i);
                //invoke the SecondActivity.

                finish();
                //the current activity will get finished.
            }
        }, 1000);

        textToSpeech=new TextToSpeech(this,this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        textToSpeech.speak("Welcome to the college portal App",TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    public void onInit(int status) {

        if (status==TextToSpeech.LANG_NOT_SUPPORTED||status==TextToSpeech.LANG_MISSING_DATA)
        {
            Toast.makeText(this, "no support for the language", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Locale locale=new Locale("hi");
            textToSpeech.setLanguage(locale);
        }


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (textToSpeech!=null)
            textToSpeech.shutdown();
    }
}
