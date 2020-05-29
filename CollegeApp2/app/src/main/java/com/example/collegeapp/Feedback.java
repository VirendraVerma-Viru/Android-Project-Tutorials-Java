package com.example.collegeapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Feedback extends AppCompatActivity implements View.OnClickListener , DialogInterface.OnClickListener {

    EditText name,message;
    Button btnfeedback;

    FileOutputStream fileOutputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        name=findViewById(R.id.name);
        message=findViewById(R.id.feedback);
        btnfeedback=findViewById(R.id.btnfeedback);

        btnfeedback.setOnClickListener(this);
    }

    public static String STUNAME=null;
    @Override
    public void onClick(View v) {
        String username=name.getText().toString();
        STUNAME=username;
        String usermessage=message.getText().toString();



        try {
            fileOutputStream=openFileOutput(username,MODE_PRIVATE);//file output stream belongs to byte stream(read, write)
            byte[] msgarr=usermessage.getBytes();
            fileOutputStream.write(msgarr);

            ShowDialog("Successfully stored in file","Success");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
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
}
