package com.example.companyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.companyapp.bean.EmployeeBean;
import com.example.companyapp.com.dbtask.DbManager;
import com.example.companyapp.com.dbtask.EmpConstant;

public class SearchEmployee extends AppCompatActivity implements View.OnClickListener{

    EditText id,name,phone,email;
    Button go,update;

    DbManager dbManager;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_employee);
        dbManager=new DbManager(this);
        sqLiteDatabase=dbManager.OpenDB();

        id=findViewById(R.id.searchid);
        name=findViewById(R.id.searchname);
        phone=findViewById(R.id.searchphone);
        email=findViewById(R.id.searchemail);
        go=findViewById(R.id.goemployee);
        update=findViewById(R.id.updateemployee);

        go.setOnClickListener(this);
        update.setOnClickListener(this);

    }

    int SelectedID=0;
    String empName;
    String empEmail;
    String empPhone;

    @Override
    public void onClick(View v) {
        SelectedID=Integer.parseInt(id.getText().toString());
        Log.i("h","5");
        Toast.makeText(this,"Success",Toast.LENGTH_LONG).show();
        if(v.getId()==R.id.goemployee)
        {

            Log.i("h","4");
            Cursor cursor=fetch();

            if(cursor.moveToFirst())
            {
                Toast.makeText(this,"Success",Toast.LENGTH_LONG).show();
                Log.wtf("h","1");
                name.setText("");
                phone.setText("");
                email.setText("");
                do{
                    Log.i("h","2");
                    if(SelectedID==Integer.parseInt(cursor.getString(0)))
                    {
                        Log.i("h","3");
                        empName=cursor.getString(1);
                        empPhone=cursor.getString(2);
                        empEmail=cursor.getString(3);
                        name.setText(empName);
                        phone.setText(empPhone);
                        email.setText(empEmail);
                        break;
                    }
                }while(cursor.moveToNext());

            }
        }else if(v.getId()==R.id.updateemployee)
        {

            empName=name.getText().toString();
            empEmail=email.getText().toString();
            empPhone=phone.getText().toString();
            long t=UpdateData(SelectedID,empName,empPhone,empEmail);
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

    public Cursor fetch() {
        Toast.makeText(this,"Success",Toast.LENGTH_LONG).show();
        Cursor cursor = sqLiteDatabase.query(EmpConstant.TABLENAME, new String[]{EmpConstant.COL_ID, EmpConstant.COL_NAME,EmpConstant.COL_PHONE, EmpConstant.COL_EMAIL}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public long UpdateData(int id,String name,String phone,String email)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(EmpConstant.COL_ID,id);
        contentValues.put(EmpConstant.COL_NAME,name);
        contentValues.put(EmpConstant.COL_PHONE,phone);
        contentValues.put(EmpConstant.COL_EMAIL,email);

        long status=sqLiteDatabase.update(EmpConstant.TABLENAME,contentValues,"empid="+SelectedID,null);
        return status;
    }
}
