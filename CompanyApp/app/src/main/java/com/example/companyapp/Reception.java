package com.example.companyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reception extends AppCompatActivity implements View.OnClickListener{

    Button add,view,search,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reception);

        add=findViewById(R.id.addemployee);
        view=findViewById(R.id.viewemployee);
        search=findViewById(R.id.searhemployee);
        delete=findViewById(R.id.deleteemployee);

        add.setOnClickListener(this);
        search.setOnClickListener(this);
        view.setOnClickListener(this);
        delete.setOnClickListener(this);

    }

    public void AddEmp(View view) {
        Intent intent=new Intent(this,Employee.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()){
            case R.id.addemployee:
                 intent=new Intent(this,Employee.class);
                startActivity(intent);
                break;
            case R.id.viewemployee:
                 intent=new Intent(this,ViewEmployee.class);
                startActivity(intent);
                break;
            case R.id.searhemployee:
                intent=new Intent(this,SearchEmployee.class);
                startActivity(intent);
                break;
            case R.id.deleteemployee:
                intent=new Intent(this,DeleteEmployee.class);
                startActivity(intent);
                break;
        }
    }
}
