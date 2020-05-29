package com.example.feedback;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.feedback.com.feedbackdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

import static android.os.Environment.*;

public class Feedback extends AppCompatActivity {

    BufferedReader bufferedReader;
    public static String STUNAME="V";

    TextView t;

    ListView listview;
    ArrayList<feedbackdata> feedbackdataArrayList;
    AdapterView.AdapterContextMenuInfo menuInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        File directoryDefault = new File(DIRECTORY_DOCUMENTS, "File");
        if (!directoryDefault.exists()) {
            directoryDefault.mkdir();
        }
        ArrayList<String> namesArray = new ArrayList<>();
        File[] arrayFiles = directoryDefault.listFiles();

        for (File file : arrayFiles) {
            namesArray.add(file.getName());
        }

        feedbackdataArrayList=new ArrayList<>();
        populateList();

        String data="";
        StringBuilder builder=new StringBuilder();//string class is imutable but stringbuilder is mutable

        try {
            FileInputStream fis =openFileInput(Feedback.STUNAME);
            bufferedReader=new BufferedReader(new InputStreamReader(fis));
            while((data=bufferedReader.readLine())!=null){
                builder.append(data);
            }
            t.setText(builder.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void populateList()
    {
        //add  names dynamically
        feedbackdataArrayList.add(new feedbackdata("Scott","9452955620"));
        feedbackdataArrayList.add(new feedbackdata("Jack","9452956540"));
        feedbackdataArrayList.add(new feedbackdata("King","9415993328"));

        ArrayAdapter<feedbackdata> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,feedbackdataArrayList);
        listview.setAdapter(arrayAdapter);
        registerForContextMenu(listview);
    }

}
