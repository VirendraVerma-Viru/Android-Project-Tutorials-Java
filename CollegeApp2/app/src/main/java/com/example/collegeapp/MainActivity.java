package com.example.collegeapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnClickListener {

    EditText txtid,txtpass;
    Button btnlogin,btnregistration;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;//used for edditimg shared prefrences

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtid=findViewById(R.id.idt);
        txtpass=findViewById(R.id.pass);
        btnlogin=findViewById(R.id.btnlogin);
        btnregistration=findViewById(R.id.btnreg);

        btnregistration.setOnClickListener(this);
        btnlogin.setOnClickListener(this);
        sharedPreferences=getSharedPreferences("registration",MODE_PRIVATE);
        editor=sharedPreferences.edit();



    }

    @Override
    public void onClick(View v) {
        String userid=txtid.getText().toString().trim();
        String userpass=txtpass.getText().toString().trim();

        if(v.getId()==R.id.btnlogin){

            String ids=sharedPreferences.getString("id",null);
            String passw=sharedPreferences.getString("pass",null);

            if(userid.equals(ids)&&userpass.equals(passw))
            {
                Intent intent=new Intent(this,Feedback.class);
                startActivity(intent);


            }else{
                ShowDialog("Error id and password","Failed");
            }
        }
        if(v.getId()==R.id.btnreg) {
            if (TextUtils.isEmpty(userid) || TextUtils.isEmpty(userpass)) {
                ShowDialog("Enter user id and password", "Fill");
            } else {
                editor.putString("id", userid);
                editor.putString("pass", userpass);
                editor.commit();
                ShowDialog("Registration Successfull", "Registred");
            }
        }

    }


    public void ShowDialog(String msg,String title)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setIcon(R.drawable.ic_launcher_background);
        builder.setPositiveButton("OK",this);

        //anonymous class
        /*builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        */

        builder.setNeutralButton("cancel",this);//dialog interface listner not view onclicklistner
        builder.setNegativeButton("NO",null);
        AlertDialog alertDialog=builder.create();
        alertDialog.show();


    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which){
            case DialogInterface.BUTTON_POSITIVE:
                Toast.makeText(this, "Positive", Toast.LENGTH_SHORT).show();
                break;

            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(this, "Negative", Toast.LENGTH_SHORT).show();
                break;

            case DialogInterface.BUTTON_NEUTRAL:
                Toast.makeText(this, "Neutral", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void readfeedback(View view) {
        Intent intent =new Intent(this,ViewFeedBack.class);
        startActivity(intent);
    }
}
