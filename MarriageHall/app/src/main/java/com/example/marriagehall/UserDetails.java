package com.example.marriagehall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.marriagehall.Fragments.loginfragment;
import com.google.android.material.snackbar.Snackbar;

public class UserDetails extends AppCompatActivity implements View.OnClickListener {

    EditText id, pass, name, email, phone;
    Button submit;

    FrameLayout frameLayoutTOp;
    Fragment loginFragment;

    LinearLayout userDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        userDetails=findViewById(R.id.userDetails);
        id = findViewById(R.id.idRegister);
        pass = findViewById(R.id.passRegister);
        name = findViewById(R.id.nameRegister);
        email = findViewById(R.id.emailRegister);
        phone = findViewById(R.id.phoneRegister);
        submit = findViewById(R.id.submitRegister);
        submit.setOnClickListener(this);

        frameLayoutTOp = findViewById(R.id.loginlayout);
        loginFragment = new loginfragment();
        FragmentManager manager = getSupportFragmentManager();//
        FragmentTransaction transaction = manager.beginTransaction();//comit,replace,remove
        transaction.replace(R.id.loginlayout, loginFragment).commit();




        //getSupportFragmentManager().beginTransaction().replace(R.id.loginframe,new loginfragment()).commit();

    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(id.getText().toString().trim()) || TextUtils.isEmpty(pass.getText().toString().trim())||TextUtils.isEmpty(name.getText().toString().trim())|| TextUtils.isEmpty(email.getText().toString().trim())|| TextUtils.isEmpty(phone.getText().toString().trim())) {
            //Toast.makeText(this,"Enter Id and password",Toast.LENGTH_LONG).show();
            ShowSnackbarMessage("Enter Details");
        } else {
            String ids = id.getText().toString();
            String password = pass.getText().toString();
            String names = name.getText().toString();
            String emails = email.getText().toString();
            String phones = phone.getText().toString();

            ShowSnackbarMessage("Successfully Registered");
        }

    }

    void ShowSnackbarMessage(String msg) {

        Snackbar snackbar = Snackbar.make(userDetails, msg, Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.YELLOW);
        //snackbar.setTextColor(Colo.YELLOW);

        snackbar.setAction("Cancel", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_LONG);
            }
        });

        View view = snackbar.getView();

        TextView textView = view.findViewById(com.google.android.material.R.id.snackbar_text);
        //com.google.android.material.R.id.snackbar_text

        //textView.setTextColor(Color.RED);
        //textView.setTextSize(30f);
        //textView.setPadding(200,20,20,20);
        //textView.setHeight(200);
        snackbar.show();
    }

}