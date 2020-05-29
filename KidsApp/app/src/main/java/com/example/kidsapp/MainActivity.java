package com.example.kidsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.kidsapp.beans.story;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener ,TextToSpeech.OnInitListener  {

    Button btnplay ;
    Spinner spinner;


    VideoView videoView;

    String path;

    ArrayList<story> storylist;

    TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        textToSpeech=new TextToSpeech(this,this);

        videoView=findViewById(R.id.videoview);

        spinner=findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);


        storylist=new ArrayList<>();
        populateSpinner();



    }










    public void populateSpinner()
    {
        storylist.add(new story("video1",R.raw.vdo1));
        storylist.add(new story("video2",R.raw.vdo));

        ArrayAdapter<story> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,storylist);
        spinner.setAdapter(arrayAdapter);


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        story story= (story) spinner.getSelectedItem();
        Toast.makeText(this, "playing   "+ story.getName(), Toast.LENGTH_SHORT).show();


        path="android.resource://"+getPackageName()+"/"+story.getId();
        videoView.setVideoPath(path);
        videoView.setMediaController(new MediaController(this));
        videoView.start();

    }






    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onInit(int status) {

        textToSpeech.speak("WELCOME TO KIDS APP",TextToSpeech.QUEUE_FLUSH,null);

        if (status==TextToSpeech.LANG_NOT_SUPPORTED||status==TextToSpeech.LANG_MISSING_DATA)
        {
            Toast.makeText(this, "no support for the language", Toast.LENGTH_SHORT).show();
        }




    }


}

