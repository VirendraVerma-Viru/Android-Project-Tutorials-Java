package com.example.feedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class Registration extends AppCompatActivity {

    EditText id,pass;

    SharedPreferences.Editor editor;//used for edditimg shared prefrences
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        id=findViewById(R.id.id);
        pass=findViewById(R.id.pass);


        sharedPreferences=getSharedPreferences("registration",MODE_PRIVATE);
        editor=sharedPreferences.edit();

    }

    public void SubmitButton(View view) {
        String ids=id.getText().toString();
        String passs=pass.getText().toString();


        if(TextUtils.isEmpty(ids)||TextUtils.isEmpty(passs)) {
            //error
        }else{
            editor.putString("id", ids);
            editor.putString("pass", passs);
            editor.commit();

                Intent intent=new Intent(this,LogIn.class);
                startActivity(intent);
                this.finish();


        }
    }
}
