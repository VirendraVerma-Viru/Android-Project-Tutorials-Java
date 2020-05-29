package com.example.firebasetutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button Add_Value_to_firebase;
    ListView listViewArtist;
List<ArtistData> artistList;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        databaseReference= FirebaseDatabase.getInstance().getReference("artists");
        name=findViewById(R.id.name_text);
        listViewArtist.findViewById(R.id.list_view_artist);
        artistList=new ArrayList<>();
        Add_Value_to_firebase=findViewById(R.id.addvaluetofirebase);
        Add_Value_to_firebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArtist();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "NSd", Toast.LENGTH_SHORT).show();
/*
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                artistList.clear();
                Toast.makeText(MainActivity.this, "NSd", Toast.LENGTH_SHORT).show();
                for(DataSnapshot artistSnapsot: dataSnapshot.getChildren())
                {

                    ArtistData artistData=artistSnapsot.getValue(ArtistData.class);
                    artistList.add(artistData);
                }
                ArtistList adapter=new ArtistList (MainActivity.this,artistList);
                listViewArtist.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

 */
    }



    private void addArtist()
    {
        String names=name.getText().toString().trim();

        if(!TextUtils.isEmpty(names))
        {
            String id=databaseReference.push().getKey();
            ArtistData artist=new ArtistData(id,names);
           databaseReference.child(id).setValue(artist);
            Toast.makeText(this, "Data Entered", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Enter the name", Toast.LENGTH_SHORT).show();
        }

    }
}
