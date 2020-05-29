package com.example.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;//widget is a package
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number1,number2,result;

    @Override
    //initialization task do in onCreate method
    protected void onCreate(Bundle savedInstanceState) {//very first method call by program  (compulsory to override)
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//is used to set the layout of an activity
        //R is a buid in final(cant get inherited) class
        //layout is a static class inside R calss
        //activity_main it is converted into hexadecimal code which is defined in  layout class
        //all the component will be in static(to reduce memory) which is converted in hexadecimal code
        //all the inner class is in static


        number1=findViewById(R.id.number1);//number1 is a int static
        number2=findViewById(R.id.number2);
        result=findViewById(R.id.result);

        Toast t=Toast.makeText(this,"in on create",Toast.LENGTH_LONG);//toast is a class and makeText is a static class
        // in t we will get variable from it
        t.show();//show is a method
        //context,text is a method of class
    }

    public void add(View v)
    {
        if(TextUtils.isEmpty(number1.getText().toString().trim())) {
            Toast.makeText(this,"number needed",Toast.LENGTH_LONG).show();
          }else{

            int num1= Integer.parseInt( number1.getText().toString().trim());//trim remove space
            int num2= Integer.parseInt( number2.getText().toString().trim());

            int res =num1+num2;
            result.setText(String.valueOf(res));
        }


    }

    public void sub(View view) {
        if(TextUtils.isEmpty(number1.getText().toString().trim())) {
            Toast.makeText(this,"number needed",Toast.LENGTH_LONG).show();
        }else{

            int num1= Integer.parseInt( number1.getText().toString().trim());//trim remove space
            int num2= Integer.parseInt( number2.getText().toString().trim());

            int res =num1-num2;
            result.setText(String.valueOf(res));
        }
    }

    public void calculation(View view) {//view is a component

        int num1= Integer.parseInt( number1.getText().toString().trim());
        int num2= Integer.parseInt( number2.getText().toString().trim());
        int res=0;
        switch (view.getId())
        {
            case R.id.add:
                res=num1+num2;
                break;
            case R.id.sub:
                res=num1-num2;
                break;

        }
        result.setText(String.valueOf(res));
    }

    //intent is use for navigation or moving one activity to another activity
    public void navigate(View view) {
        Intent intent=new Intent(this,Formulas.class);//Formulass.class is called class literals
        //first parameter  is source to destination
        startActivity(intent);

        //this.finish();
        //it is used to destroy the current activity

    }
}
