package com.example.collegeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ViewFeedBack extends AppCompatActivity {

    TextView textFeedback;

    BufferedReader bufferedReader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_feed_back);

        textFeedback=findViewById(R.id.textFeedback);
        String data="";
        StringBuilder builder=new StringBuilder();//string class is imutable but stringbuilder is mutable

        try {
            FileInputStream fis =openFileInput(Feedback.STUNAME);
            bufferedReader=new BufferedReader(new InputStreamReader(fis));
            while((data=bufferedReader.readLine())!=null){
                builder.append(data);
            }
            textFeedback.setText(builder.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
