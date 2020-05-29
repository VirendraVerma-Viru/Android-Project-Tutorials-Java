package com.example.companyappcopy.com.dbtask;

public class EmpConstant {

    public static final String DBNAME="company";
    public static final String TABLENAME="employee";
    public static final int DATABASEVERSION=1;
    public static final String COL_ID="empid";
    public static final String COL_NAME="NAME";
    public static final String COL_PHONE="phone";
    public static final String COL_EMAIL="email";

   // public static final String TBL_QUERY="create table employee(empid integer primary key,name text,phone text,email text)";
   public static final String TBL_QUERY="create table "+TABLENAME+"("+COL_ID+" integer primary key,"+COL_NAME+" text,"+COL_PHONE+" text,"+COL_EMAIL+" text)";


}
