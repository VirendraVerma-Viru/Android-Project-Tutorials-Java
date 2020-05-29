package com.example.companyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.companyapp.com.dbtask.DbManager;
import com.example.companyapp.com.dbtask.EmpConstant;

import javax.microedition.khronos.egl.EGLDisplay;

public class Employee extends AppCompatActivity {

    EditText id,name,email,phone;

    DbManager dbManager;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        dbManager=new DbManager(this);
        sqLiteDatabase=dbManager.OpenDB();


        id=findViewById(R.id.empid);
        name=findViewById(R.id.empname);
        email=findViewById(R.id.empemail);
        phone=findViewById(R.id.empphone);

    }

    public void AddEmpData(View view) {
        String empid=id.getText().toString();
        String empname=name.getText().toString();
        String empemail=email.getText().toString();
        String empphone=phone.getText().toString();

        if(TextUtils.isEmpty(empid)||TextUtils.isEmpty(empname)||TextUtils.isEmpty(empemail)||TextUtils.isEmpty(empphone)) {
            //error
        }else{
            long t=InsertData(Integer.parseInt(empid),empname,empphone,empemail);
            if(t>0)
            {
                Toast.makeText(this,"Success",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(this,Reception.class);
                startActivity(intent);
                this.finish();

            }else{
                Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
            }
        }
    }

    public long InsertData(int id,String name,String phone,String email)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(EmpConstant.COL_ID,id);
        contentValues.put(EmpConstant.COL_NAME,name);
        contentValues.put(EmpConstant.COL_PHONE,phone);
        contentValues.put(EmpConstant.COL_EMAIL,email);

        long status=sqLiteDatabase.insert(EmpConstant.TABLENAME,null,contentValues);
        return status;
    }
}
