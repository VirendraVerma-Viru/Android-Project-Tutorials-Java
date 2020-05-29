package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText idText,passText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idText=findViewById(R.id.idText);
        passText=findViewById(R.id.passText);
    }

    public void Submit(View view) {
        String idNu="12345";
        String passNu="12345";
        Intent intent=new Intent(this,Welcome.class);//Formulass.class is called class literals
        //first parameter  is source to destination

        if(TextUtils.isEmpty(idText.getText().toString().trim()) && TextUtils.isEmpty(passText.getText().toString().trim())) {
            Toast.makeText(this,"Enter Id and password",Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(idText.getText().toString().trim())) {
            Toast.makeText(this,"Enter Id",Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(passText.getText().toString().trim())) {
            Toast.makeText(this,"Enter Password",Toast.LENGTH_LONG).show();
        }else {

            if(Integer.valueOf(idText.getText().toString())==12345 && Integer.valueOf(passText.getText().toString())==12345){
                startActivity(intent);
            }else{
                if(Integer.valueOf(idText.getText().toString()) !=12345 && passText.getText().toString()!=passNu){
                    Toast.makeText(this,"Wrong id "+idText.getText().toString()+" and password "+passText.getText().toString(),Toast.LENGTH_LONG).show();
                }else if(passText.getText().toString()!=passNu){
                    Toast.makeText(this,"Wrong password",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"Wrong id",Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
