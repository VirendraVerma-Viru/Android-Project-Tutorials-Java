package com.example.registrationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.registrationapp.com.beans.Student;

public class Details extends AppCompatActivity
{
    Intent intent;
    String name,phone;

    TextView txtname,txtphone,txtcourse,txtgender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txtname=findViewById(R.id.txtname);
        txtphone=findViewById(R.id.txtphone);
        txtcourse=findViewById(R.id.txtcourse);
        txtgender=findViewById(R.id.txtgender);

        intent=getIntent();

         //name = intent.getStringExtra("keyname");
         //phone = intent.getStringExtra("keyphone");

        Student student=(Student)intent.getSerializableExtra("studentkey");

        txtname.setText(student.getName());
        txtphone.setText(student.getPhone());
        txtcourse.setText(student.getCourse());
        txtgender.setText(student.getGender());

    }


}
