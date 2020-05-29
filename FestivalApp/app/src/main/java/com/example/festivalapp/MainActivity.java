package com.example.festivalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Navigate(View view) {

        Intent diwali=new Intent(this,Diwali.class);
        Intent eid=new Intent(this,Eid.class);
        Intent christmas=new Intent(this,Christmas.class);

        switch (view.getId()){
            case R.id.diwaliPic:
                startActivity(diwali);
                break;
            case R.id.eid:
                startActivity(eid);
                break;
            case R.id.christmas:
                startActivity(christmas);
                break;

        }
    }

    @Override
    public void onClick(View v) {

        Intent diwali=new Intent(this,Diwali.class);
        Intent eid=new Intent(this,Eid.class);
        Intent christmas=new Intent(this,Christmas.class);

        switch (v.getId()){
            case R.id.diwaliPic:
                startActivity(diwali);
                break;
            case R.id.eid:
                startActivity(eid);
                break;
            case R.id.christmas:
                startActivity(christmas);
                break;

        }
    }
}
