package com.example.friendsapp;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SMS extends AppCompatActivity implements View.OnClickListener {

    EditText smsText;
    Button busms;
    TextView phoneTxt;

    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        smsText=findViewById(R.id.smsText);
        busms=findViewById(R.id.busms);
        busms.setOnClickListener(this);

        Intent i=getIntent();
        phone=i.getStringExtra("phone");
    }

    @Override
    public void onClick(View v) {
        String smsa=smsText.getText().toString();

        String phoneNumber="9452955620";

        Intent obj=new Intent(this,SMS.class);

        PendingIntent intent=PendingIntent.getActivity(this,1,obj,PendingIntent.FLAG_ONE_SHOT);//pass application permission to foreign application

        SmsManager smsManager=SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber,"7651889649",smsa,intent,null);
        Toast.makeText(this,"message sent="+smsa,Toast.LENGTH_LONG).show();
    }
}
