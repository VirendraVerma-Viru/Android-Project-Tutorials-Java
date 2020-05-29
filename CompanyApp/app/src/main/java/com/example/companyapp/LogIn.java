package com.example.companyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class LogIn extends AppCompatActivity {

    EditText id,pass;

    SharedPreferences.Editor editor;//used for edditimg shared prefrences
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        id=findViewById(R.id.idlog);
        pass=findViewById(R.id.passlog);

        sharedPreferences=getSharedPreferences("registration",MODE_PRIVATE);
        editor=sharedPreferences.edit();

    }

    public void LogIn(View view) {
        String ids=id.getText().toString();
        String passs=pass.getText().toString();

        if(TextUtils.isEmpty(ids)||TextUtils.isEmpty(passs)) {
            //error
        }else{
            String ida=sharedPreferences.getString("id",null);
            String passa=sharedPreferences.getString("pass",null);
            String type=sharedPreferences.getString("type",null);

            if(ida.equals(ids)&&passs.equals(passa))
            {
                if(type.equals("Admin"))
                {
                    Intent intent=new Intent(this,Admin.class);
                    startActivity(intent);
                    this.finish();
                }else{
                    Intent intent=new Intent(this,Reception.class);
                    startActivity(intent);
                    this.finish();
                }
            }else{
                //user id and password is not match
            }
        }
    }
}
