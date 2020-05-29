package com.example.companyapp.com.dbtask;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbManager {

    CompanyHelper companyHelper;
    SQLiteDatabase sqLiteDatabase;

    public DbManager(Context context)
    {
        companyHelper=new CompanyHelper(context,EmpConstant.DBNAME,null,EmpConstant.DATABASEVERSION);

    }

    public SQLiteDatabase OpenDB()
    {
        sqLiteDatabase=companyHelper.getWritableDatabase();
        return sqLiteDatabase;
    }

    public void CloseDB()
    {
        if(companyHelper!=null)
            companyHelper.close();
    }
}
