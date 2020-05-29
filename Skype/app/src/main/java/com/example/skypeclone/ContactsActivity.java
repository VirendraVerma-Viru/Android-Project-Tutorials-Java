package com.example.skypeclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ContactsActivity extends AppCompatActivity {

    BottomNavigationView navView;
    RecyclerView myContactsList;
    ImageView findPeopleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        //BottomNavigationView navView = findViewById(R.id.nav_view);
        navView=findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        findPeopleBtn=findViewById(R.id.find_people_btn);
        myContactsList=findViewById(R.id.contact_list);
        myContactsList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        findPeopleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsintent=new Intent(ContactsActivity.this,SettingActivity.class);
                startActivity(settingsintent);
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId())
            {

                case R.id.navigation_home:
                    Intent MainIntent=new Intent(ContactsActivity.this, ContactsActivity.class);
                    startActivity(MainIntent);
                    break;
                case R.id.navigation_settings:
                    Intent settingIntent=new Intent(ContactsActivity.this,SettingActivity.class);
                    startActivity(settingIntent);
                    break;
                case R.id.navigation_notifications:
                    Intent nortificationIntent=new Intent(ContactsActivity.this,NortificationActivity.class);
                    startActivity(nortificationIntent);
                    break;

                case R.id.navigation_logout:
                    FirebaseAuth.getInstance().signOut();
                    Intent logoutIntent=new Intent(ContactsActivity.this,NortificationActivity.class);
                    startActivity(logoutIntent);
                    finish();
                    break;

            }
            return true;
        }
    };

}
