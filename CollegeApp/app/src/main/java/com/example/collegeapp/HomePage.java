package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class HomePage extends AppCompatActivity {

    WebView homeWebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        homeWebview=findViewById(R.id.homewebview);
        homeWebview.loadUrl("file:///android_asset/Files/home.html");

    }

    public void formPage(View view) {
        Intent intent=new Intent(this,FormPage.class);
        startActivity(intent);
    }
}
