package com.example.companyapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.companyapp.com.dbtask.DbManager;
import com.example.companyapp.com.dbtask.EmpConstant;

public class DeleteEmployee extends AppCompatActivity implements View.OnClickListener{

    EditText id;
    Button go;

    DbManager dbManager;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_employee);

        dbManager=new DbManager(this);
        sqLiteDatabase=dbManager.OpenDB();

        id=findViewById(R.id.deleteid);
        go=findViewById(R.id.godeleteemployee);

        go.setOnClickListener(this);
    }

    int SelectedID;

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.godeleteemployee)
        {
            ShowDialog("Are you Sure?","Delete");
        }
    }

    public void ShowDialog(String msg,String title)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setIcon(R.drawable.ic_launcher_background);

        //anonymous class
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SelectedID=Integer.parseInt(id.getText().toString());
                int t=DeleteRow(SelectedID);
                if(t>0) {
                    Toast.makeText(DeleteEmployee.this, "Success", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(DeleteEmployee.this,Reception.class);
                    startActivity(intent);
                    finish();
                } else{
                    Toast.makeText(DeleteEmployee.this,"Error",Toast.LENGTH_LONG).show();
                }
            }
        });
        builder.setNegativeButton("Cancel",null);
        AlertDialog alertDialog=builder.create();
        alertDialog.show();


    }

    public int DeleteRow(int id)
    {

        int t=sqLiteDatabase.delete(EmpConstant.TABLENAME,EmpConstant.COL_ID+"="+id,null);
        return t;
    }
}
