package com.example.enquiryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.enquiryapp.com.EnquiryData;

public class Data extends AppCompatActivity {

    TextView statement;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        statement=findViewById(R.id.statement);

        intent=getIntent();
        EnquiryData student=(EnquiryData)intent.getSerializableExtra("studentkey");



        /*String sText="Hello "+student.getName()+"\n" +
                "        \n\n" +
                "        \n\n" +
                "        you have enquiry on "+student.getName()+"\n" +
                "        \n\n" +
                "        for "+student.getCourseSelected()+" courses\n" +
                "        \n\n" +
                "        \n\n" +
                "        we will contact you\n" +
                "        \n\n" +
                "        On <font color='#EE0000'>"+student.getPhone()+"</font>\n" +
                "        \n\n" +
                "        Email <font color='#EE0000'>"+student.getEmail()+"</font>";



         */

        String mtext="Hello "+student.getName()+" \n \nyou have enquiry on date "+student.getDate()+"\nfor "+student.getCourseSelected()+" cources\n\nwe will contact you\nOn "+student.getPhone()+"\nemail "+student.getEmail()+"";
        String mhtext="Hello "+student.getName()+" <br> <br>you have enquiry on date "+student.getDate()+"<br>for "+student.getCourseSelected()+" cources<br><br>we will contact you<br>On <font color='#EE0000'>"+student.getPhone()+"</font><br>email <font color='#EE0000'>"+student.getEmail()+"</font>";

        //statement.setText(mtext);
        statement.setText(Html.fromHtml(mhtext));
    }
}
