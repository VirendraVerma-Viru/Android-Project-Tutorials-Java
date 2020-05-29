package com.example.enquiryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.enquiryapp.com.EnquiryData;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText name,email,phone;
    CheckBox android,java,csharp,python;
    String date;
    Button submit;
    DatePicker datea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        android=findViewById(R.id.android);
        java=findViewById(R.id.java);
        csharp=findViewById(R.id.csharp);
        python=findViewById(R.id.python);
        datea=findViewById(R.id.date);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(TextUtils.isEmpty(name.getText().toString().trim())||TextUtils.isEmpty(name.getText().toString().trim())||TextUtils.isEmpty(name.getText().toString().trim())) {
            Toast.makeText(this,"Fill all Fields",Toast.LENGTH_LONG).show();
        }else{
            String sname=name.getText().toString();
            String semail=email.getText().toString();
            String sphone=phone.getText().toString();

            String courseSelected="";

            if(java.isChecked())
            {
                courseSelected=java.getText().toString();
            }
            if(android.isChecked())
            {
                courseSelected=courseSelected+","+android.getText().toString();
            }
            if(csharp.isChecked())
            {
                courseSelected=courseSelected+","+csharp.getText().toString();
            }
            if(python.isChecked())
            {
                courseSelected=courseSelected+","+python.getText().toString();
            }

            Intent intent=new Intent(this,Data.class);

            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String sdate = getCurrentDate();

            EnquiryData student =new EnquiryData(sname,sdate,semail,sphone,courseSelected);

            //Toast.makeText(this,"sdate="+sdate,Toast.LENGTH_LONG).show();
            intent.putExtra("studentkey",student);
            startActivity(intent);

        }
    }

    public String getCurrentDate(){
        StringBuilder builder=new StringBuilder();;
        builder.append((datea.getMonth() + 1)+"/");//month is 0 based
        builder.append(datea.getDayOfMonth()+"/");
        builder.append(datea.getYear());
        return builder.toString();
    }
}
