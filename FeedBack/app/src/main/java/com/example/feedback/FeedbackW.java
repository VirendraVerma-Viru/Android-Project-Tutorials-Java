package com.example.feedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FeedbackW extends AppCompatActivity {

    EditText name,feedback;

    FileOutputStream fileOutputStream;
    String names,feedbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_w);
        name=findViewById(R.id.nametext);
        feedback=findViewById(R.id.feedbacktext);

    }

    public void FeedbackButton(View view) {
         names=name.getText().toString();
         feedbacks=feedback.getText().toString();

        if(TextUtils.isEmpty(names)||TextUtils.isEmpty(feedbacks)) {
            //error
        }else{
            try {
                fileOutputStream=openFileOutput(names,MODE_PRIVATE);//file output stream belongs to byte stream(read, write)
                byte[] msgarr=names.getBytes();
                fileOutputStream.write(msgarr);

                Intent intent=new Intent(this,Feedback.class);
                startActivity(intent);
                this.finish();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
