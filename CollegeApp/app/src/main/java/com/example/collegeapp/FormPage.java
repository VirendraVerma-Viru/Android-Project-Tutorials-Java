package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FormPage extends AppCompatActivity {

    EditText id,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_page);

        id=findViewById(R.id.idText);
        pass=findViewById(R.id.passwordid);

    }

    public void LogIn(View view) {

        String ids=id.getText().toString();
        String password=pass.getText().toString();
        if(TextUtils.isEmpty(id.getText().toString().trim()) && TextUtils.isEmpty(pass.getText().toString().trim())) {
            Toast.makeText(this,"Enter Id and password",Toast.LENGTH_LONG).show();
            Log.i("test","Enter Id and password");
        }else{

            if(ids.equals( "abc" ) && password.equals( "abc" ))
            {
                Toast.makeText(this,"Successfully Loged In",Toast.LENGTH_LONG).show();
                Log.i("test","Successfully Loged In");
            }else if(ids.equals( "abc" )){
                Toast.makeText(this,"Password Incorrect",Toast.LENGTH_LONG).show();
                Log.i("test","Password Incorrect");
            }
            else if(password.equals( "abc" )){
                Toast.makeText(this,"ID Incorrect",Toast.LENGTH_LONG).show();
                Log.i("test","ID Incorrect");
            }
            else {
                Toast.makeText(this,"Id and Password Incorrect",Toast.LENGTH_LONG).show();
                Log.i("test","Id="+ids+" and Password="+password+" Incorrect");
            }
        }
    }

    public void Registration(View view) {
        String ids=id.getText().toString();
        String password=pass.getText().toString();
        if(TextUtils.isEmpty(id.getText().toString().trim()) && TextUtils.isEmpty(pass.getText().toString().trim())) {
            Toast.makeText(this,"Enter Id and password",Toast.LENGTH_LONG).show();
            Log.i("test","Enter Id and password");
        }else{

            if(ids.equals( "abc" ) && password.equals( "abc" ))
            {
                Toast.makeText(this,"Successfully Registered",Toast.LENGTH_LONG).show();
                Log.i("test","Successfully Registered");
            }else if(ids.equals( "abc" )){
                Toast.makeText(this,"Password Incorrect",Toast.LENGTH_LONG).show();
                Log.i("test","Password Incorrect");
            }
            else if(password.equals( "abc" )){
                Toast.makeText(this,"ID Incorrect",Toast.LENGTH_LONG).show();
                Log.i("test","ID Incorrect");
            }
            else {
                Toast.makeText(this,"Id and Password Incorrect",Toast.LENGTH_LONG).show();
                Log.i("test","Id="+ids+" and Password="+password+" Incorrect");
            }
        }
    }
}
