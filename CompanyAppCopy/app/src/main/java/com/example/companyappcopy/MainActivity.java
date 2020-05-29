package com.example.companyappcopy;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.companyappcopy.com.dbtask.DbManager;
import com.example.companyappcopy.com.dbtask.EmpConstant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText empid,empname,empemail,empphone;
    Button addEmp;

    DbManager dbManager;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empid=findViewById(R.id.empid);
        empname=findViewById(R.id.empname);
        empemail=findViewById(R.id.empemail);
        empphone=findViewById(R.id.empphone);
        addEmp=findViewById(R.id.addEmp);
        addEmp.setOnClickListener(this);

        dbManager=new DbManager(this);
        sqLiteDatabase=dbManager.OpenDB();


    }

    @Override
    public void onClick(View v) {

        int id= Integer.parseInt(empid.getText().toString());
        String name=empname.getText().toString();
        String phone=empphone.getText().toString();
        String emial=empemail.getText().toString();

        long t=InsertData(id,name,phone,emial);
        if(t>0)
        {
            Toast.makeText(this,"Success",Toast.LENGTH_LONG).show();
            init(id,name,phone,emial);



        }else{
            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
        }
    }
    public void init(int id,String name,String phone,String email){
        TableLayout ll = (TableLayout) findViewById(R.id.table);

        TextView t1,t2,t3,t4;

        for (int i = 0; i <2; i++) {

            TableRow row= new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            t1=new TextView(this);
            t1.setText(id);
            t2=new TextView(this);
            t2.setText(name);
            t3=new TextView(this);
            t3.setText(phone);
            t4=new TextView(this);
            t4.setText(email);
            row.addView(t1);
            row.addView(t2);
            row.addView(t3);
            row.addView(t4);
            ll.addView(row,i);
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
