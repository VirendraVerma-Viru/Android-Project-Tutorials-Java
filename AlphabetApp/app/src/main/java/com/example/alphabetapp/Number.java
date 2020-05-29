package com.example.alphabetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;


public class Number extends AppCompatActivity implements  TextToSpeech.OnInitListener {

    Button BU;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        textToSpeech=new TextToSpeech(this,this);
    }

    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                textToSpeech.speak("One",TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.two:
                textToSpeech.speak("Two",TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.three:
                textToSpeech.speak("Three",TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.four:
                textToSpeech.speak("Four",TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.five:
                textToSpeech.speak("Five",TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.six:
                textToSpeech.speak("Six",TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.seven:
                textToSpeech.speak("Seven",TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.eight:
                textToSpeech.speak("Eight",TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.nine:
                textToSpeech.speak("Nine",TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.zero:
                textToSpeech.speak("Zero",TextToSpeech.QUEUE_FLUSH,null);
                break;
        }
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
