package com.example.speakdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener , TextToSpeech.OnInitListener {

    Button btnspeak;

    TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnspeak=findViewById(R.id.btnspeak);
        btnspeak.setOnClickListener(this);
        textToSpeech=new TextToSpeech(this,this);

    }

    @Override
    public void onClick(View v) {

       textToSpeech.speak("नमस्ते आपका स्वागत है",TextToSpeech.QUEUE_FLUSH,null);

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
