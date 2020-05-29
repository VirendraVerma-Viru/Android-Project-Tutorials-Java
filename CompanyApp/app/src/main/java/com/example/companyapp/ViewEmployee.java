package com.example.companyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.companyapp.bean.EmployeeBean;
import com.example.companyapp.com.dbtask.DbManager;
import com.example.companyapp.com.dbtask.EmpConstant;

import java.util.ArrayList;

public class ViewEmployee extends AppCompatActivity{

    ListView viewEmployee;

    EmployeeBean eb;
    String Femail;

    ArrayList<EmployeeBean> employeeBeanArrayList;
    AdapterView.AdapterContextMenuInfo menuInfo;

    DbManager dbManager;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee);
        dbManager=new DbManager(this);
        sqLiteDatabase=dbManager.OpenDB();

        viewEmployee=findViewById(R.id.employeelist);
        employeeBeanArrayList=new ArrayList<>();
        populateList();
        viewEmployee.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                eb=employeeBeanArrayList.get(position);
                Femail=eb.getEmail();
                //Toast.makeText(this,"test="+Femail,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(ViewEmployee.this,SendEmail.class);
                intent.putExtra("email",Femail);
                startActivity(intent);

            }

        });

    }

    public void populateList()
    {
        //add  names dynamically
        Cursor cursor=fetch();
        if(cursor.moveToFirst())
        {
            do{
                employeeBeanArrayList.add(new EmployeeBean(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
            }while(cursor.moveToNext());
        }




        ArrayAdapter<EmployeeBean> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,employeeBeanArrayList);
        viewEmployee.setAdapter(arrayAdapter);
        registerForContextMenu(viewEmployee);
    }

    public Cursor fetch() {
        Cursor cursor = sqLiteDatabase.query(EmpConstant.TABLENAME, new String[]{EmpConstant.COL_ID, EmpConstant.COL_NAME,EmpConstant.COL_PHONE, EmpConstant.COL_EMAIL}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }




}
