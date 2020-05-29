package com.example.videotest;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView video;
    MediaController mediaController;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        video=findViewById(R.id.videov);
        //Set MediaController  to enable play, pause, forward, etc options.
         mediaController= new MediaController(this);
        mediaController.setAnchorView(video);
        //Location of Media File
         uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.one);
        //Starting VideView By Setting MediaController and URI

    }


    public void videoStart(View view) {
        video.setMediaController(mediaController);
        video.setVideoURI(uri);
        video.requestFocus();
        video.start();
    }


}
