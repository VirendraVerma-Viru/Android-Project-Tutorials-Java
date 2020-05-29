package com.example.marriagehall.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.marriagehall.R;
import com.google.android.material.snackbar.Snackbar;
import com.example.marriagehall.UserDetails;

public class loginfragment extends Fragment implements View.OnClickListener{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    EditText id,password;
    Button btnlogin;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.loginpage,container,false);
        id=view.findViewById(R.id.loginid);
        password=view.findViewById(R.id.loginpass);
        btnlogin=view.findViewById(R.id.loginButton);
        btnlogin.setOnClickListener(this);
        /*btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=username.getText().toString();
                Toast.makeText(getActivity(),name,Toast.LENGTH_LONG).show();//getActivity refers to the curretn activity
            }
        });
*/


        return view;//LayoutInflater is a class

    }

    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(id.getText().toString().trim()) && TextUtils.isEmpty(password.getText().toString().trim())) {
            //Toast.makeText(this,"Enter Id and password",Toast.LENGTH_LONG).show();
            ShowSnackbarMessage("Enter Id and password");
        }else {
            String ids = id.getText().toString();
            String pass = password.getText().toString();

            if(ids.equals("12345") && pass.equals("12345"))
            {
                //Intent intent=new Intent(this,DJFormPage.class);
                //startActivity(intent);
                ShowSnackbarMessage("Successfully Loged In");
            }else{
                ShowSnackbarMessage("Id or Password Did not match");

            }
        }

    }

    void ShowSnackbarMessage(String msg) {

        Snackbar snackbar=Snackbar.make(getActivity().findViewById(R.id.userDetails),msg,Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.YELLOW);
        //snackbar.setTextColor(Colo.YELLOW);

        snackbar.setAction("Cancel", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_LONG);
            }
        });

        View view=snackbar.getView();

        TextView textView=view.findViewById(com.google.android.material.R.id.snackbar_text);
        //com.google.android.material.R.id.snackbar_text

        //textView.setTextColor(Color.RED);
        //textView.setTextSize(30f);
        //textView.setPadding(200,20,20,20);
        //textView.setHeight(200);
        snackbar.show();
    }



}
