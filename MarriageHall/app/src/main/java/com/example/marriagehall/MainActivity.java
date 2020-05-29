package com.example.marriagehall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll=findViewById(R.id.linearLayOut);
        TextView tv=new TextView(getApplicationContext());
        tv.setText("This is a sample TextView...");
        tv.setGravity(0);
        // Set a text color for TextView text
        tv.setTextColor(Color.parseColor("#ff0000"));

        // Add newly created TextView to parent view group (RelativeLayout)
        ll.addView(tv);

        Intent intent=new Intent(this,UserDetails.class);
        startActivity(intent);
        this.finish();
    }
}
