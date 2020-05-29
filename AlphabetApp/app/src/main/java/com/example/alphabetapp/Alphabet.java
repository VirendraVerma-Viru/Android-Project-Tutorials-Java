package com.example.alphabetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Alphabet extends AppCompatActivity implements  TextToSpeech.OnInitListener  {

    private GestureDetector gesture;
    TextToSpeech textToSpeech;
    TextView CharecterText,CharecterName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        gesture = new GestureDetector(new SwipeGestureDetector());

        CharecterText=findViewById(R.id.Charecter);
        CharecterName=findViewById(R.id.Data);

        CharecterText.setText(charecters[index]);
        CharecterName.setText(CNames[index]);

        textToSpeech=new TextToSpeech(this,this);
        textToSpeech.speak(charecters[index]+" for "+CNames[index],TextToSpeech.QUEUE_FLUSH,null);
    }







    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (gesture.onTouchEvent(event))
        {
            return true;
        }
        return super.onTouchEvent(event);
    }

    String[] charecters = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String[] CNames = new String[]{"Apple","Boy","Cat","Dog","Elephant","Fox","Girl","Honey","Ice","Jam","King","Lion","Monkey","Neon","Orrange","Pipe","Qeen","Rat","Sun","Tree","Umbrella","Van","Wagon","Xmas Tree","Yak","Zebra"};

    int index=0;
    private void onRight()
    {
        index--;
        if(index<0)
            index=25;
        CharecterText.setText(charecters[index]);
        CharecterName.setText(CNames[index]);
        textToSpeech.speak(charecters[index]+" for "+CNames[index],TextToSpeech.QUEUE_FLUSH,null);
    }

    private void onLeft()
    {
        index++;
        if(index>25)
            index=0;
        CharecterText.setText(charecters[index]);
        CharecterName.setText(CNames[index]);
        textToSpeech.speak(charecters[index]+" for "+CNames[index],TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    public void onInit(int status) {
        if (status==TextToSpeech.LANG_NOT_SUPPORTED||status==TextToSpeech.LANG_MISSING_DATA)
        {
            Toast.makeText(this, "no support for the language", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Locale locale=new Locale("hi");
            textToSpeech.setLanguage(locale);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (textToSpeech!=null)
            textToSpeech.shutdown();
    }

    // Private class for gestures
    private class SwipeGestureDetector  extends SimpleOnGestureListener
    {
        private static final int SWIPE_MIN_DISTANCE = 120;
        private static final int SWIPE_MAX_OFF_PATH = 200;
        private static final int SWIPE_THRESHOLD_VELOCITY = 200;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2,float velocityX, float velocityY)
        {
            try
            {
                float diffAbs = Math.abs(e1.getY() - e2.getY());
                float diff = e1.getX() - e2.getX();

                if (diffAbs > SWIPE_MAX_OFF_PATH)
                    return false;

                // Left swipe
                if (diff > SWIPE_MIN_DISTANCE&& Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
                {
                    Alphabet.this.onLeft();
                }
                // Right swipe

                else if (-diff > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
                {
                    Alphabet.this.onRight();
                }
            }
            catch (Exception e)
            {

                Log.e("MainActivity", "Error on gestures");
            }
            return false;
        }
    }

}
