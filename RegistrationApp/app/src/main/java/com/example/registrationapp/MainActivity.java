package com.example.registrationapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.registrationapp.com.beans.Student;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button submit;
    EditText name,phone;
    RadioGroup gender;
    CheckBox java,android;
    Spinner city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(this);//this refers to main activity because onclicklistner is implement on this file
        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        java=findViewById(R.id.java);
        android=findViewById(R.id.android);
        city=findViewById(R.id.city);
        gender=findViewById(R.id.gender);

    }

    @Override
    public void onClick(View v)
    {
        String nm=name.getText().toString();
        String ph=phone.getText().toString();
        String course="";
        if(java.isChecked())
        {
            course=java.getText().toString();
        }
        if(android.isChecked())
        {
            course=course+","+android.getText().toString();
        }

        int rdid=gender.getCheckedRadioButtonId();
        RadioButton rb=gender.findViewById(rdid);
        String gen=rb.getText().toString();

        String cityname=(String)city.getSelectedItem().toString();

        Intent intent=new Intent(this,Details.class);

        //intent.putExtra("keyname",nm);
        //intent.putExtra("keyphone",ph);

        Student student =new Student(nm,ph,cityname,gen,course);

        //Toast.makeText(this,"cityname="+cityname+"|gen="+gen+"|course="+course,Toast.LENGTH_LONG).show();
        intent.putExtra("studentkey",student);
        startActivity(intent);


    }
}
