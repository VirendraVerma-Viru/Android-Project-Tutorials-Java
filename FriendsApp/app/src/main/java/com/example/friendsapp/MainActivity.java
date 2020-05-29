package com.example.friendsapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.friendsapp.com.friend;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listview;
    ArrayList<friend> friendsArrayList;
    AdapterView.AdapterContextMenuInfo menuInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview=findViewById(R.id.listview);
        listview.setOnItemClickListener(this);

        friendsArrayList=new ArrayList<>();
        populateList();
    }

    public void populateList()
    {
        friendsArrayList.add(new friend("Scott","9452955620"));
        friendsArrayList.add(new friend("Jack","9452956540"));
        friendsArrayList.add(new friend("King","9415993328"));

        ArrayAdapter<friend> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,friendsArrayList);
        listview.setAdapter(arrayAdapter);
        registerForContextMenu(listview);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.call_msg,menu);
        menu.setHeaderTitle("choose your action");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        menuInfo=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        if(item.getItemId()==R.id.call)
        {
            int position=menuInfo.position;
            fr=friendsArrayList.get(position);
            phonenumber=fr.getPhone();
            MakeCall(phonenumber);

            Toast.makeText(this,"Call",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.sms)
        {
            Intent intent=new Intent(this,SMS.class);
            intent.putExtra("phone",phonenumber);
            startActivity(intent);
            Toast.makeText(this,"Call",Toast.LENGTH_LONG).show();
        }else {
            return false;
        }
        return true;
    }



    String phonenumber;
    friend fr;
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        fr=friendsArrayList.get(position);
        phonenumber=fr.getPhone();
        Toast.makeText(this,"test",Toast.LENGTH_LONG).show();
        MakeCall(phonenumber);

    }

    public void MakeCall(String phonenumber)
    {


        //Toast.makeText(this,"Name="+fr.getName()+"|Phone="+fr.getPhone(),Toast.LENGTH_LONG).show();

        Intent intent=new Intent(Intent.ACTION_CALL);


        Uri uri=Uri.parse("tel:"+phonenumber);//Uri provide a inique format
        intent.setData(uri);
        startActivity(intent);
    }


    //adapter is a bridge between source and data source
    //adapter
    //array adapter objecet (constructor)
    //pass datasource
    //ayout and listview
    //set adapter yo list view

}
