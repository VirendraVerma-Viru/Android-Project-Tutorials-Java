package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText getValue;
    TextView showValue;
    Button showButton;

    ListView listView;

    String items[]=new String[] {"Hello","World","its","me"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getValue=findViewById(R.id.value1);
        showValue=findViewById(R.id.showvalue);
        showButton=findViewById(R.id.buttonpressed);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetText();
            }
        });


        listView=findViewById(R.id.listview);
        ArrayList<String> arrayList=new ArrayList<>();

        arrayList.add("Hello");
        arrayList.add("world");
        arrayList.add("asd");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.activity_main,arrayList);
        listView.setAdapter();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"message"+i,Toast.LENGTH_LONG).show();
            }
        });

    }


    void SetText()
    {
        String t=getValue.getText().toString();
        showValue.setText(t);
    }
}