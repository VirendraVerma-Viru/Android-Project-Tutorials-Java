package com.example.companyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class Registration extends AppCompatActivity {

    EditText id,pass;
    Spinner type;
    SharedPreferences.Editor editor;//used for edditimg shared prefrences
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        id=findViewById(R.id.id);
        pass=findViewById(R.id.pass);
        type=findViewById(R.id.type);

        sharedPreferences=getSharedPreferences("registration",MODE_PRIVATE);
        editor=sharedPreferences.edit();

    }

    public void SubmitButton(View view) {
        String ids=id.getText().toString();
        String passs=pass.getText().toString();
        String acctype=(String)type.getSelectedItem().toString();

        if(TextUtils.isEmpty(ids)||TextUtils.isEmpty(passs)||TextUtils.isEmpty(acctype)) {
            //error
        }else{
            editor.putString("id", ids);
            editor.putString("pass", passs);
            editor.putString("type", acctype);
            editor.commit();

            if(acctype.equals("Admin")){
                Intent intent=new Intent(this,Admin.class);
                startActivity(intent);
                this.finish();
            }else{
                Intent intent=new Intent(this,Reception.class);
                startActivity(intent);
                this.finish();
            }

        }
    }
}
