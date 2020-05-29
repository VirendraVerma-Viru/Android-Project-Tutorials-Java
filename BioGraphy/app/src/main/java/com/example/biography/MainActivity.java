package com.example.biography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void navigate(View view) {

        Intent intentFather=new Intent(this,fa.class);
        Intent intentMother=new Intent(this,mo.class);
        Intent intentSister=new Intent(this,sis.class);
        Intent intentBrother=new Intent(this,bro.class);

        switch (view.getId())
        {
            case R.id.father:
                startActivity(intentFather);
                break;
            case R.id.mother:
                startActivity(intentMother);
                break;
            case R.id.sister:
                startActivity(intentSister);
                break;
            case R.id.brother:
                startActivity(intentBrother);
                break;

        }

        

    }
}
