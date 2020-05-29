package com.example.skypeclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class NortificationActivity extends AppCompatActivity {

    private RecyclerView notification_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nortification);

        notification_list=findViewById(R.id.notification_list);
        notification_list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    public static class NotificationViewHolder extends RecyclerView.ViewHolder
    {
        TextView userNameTxt;
        Button videoCallBtn;
        ImageView profileImageView;
        RelativeLayout cardView;

        public NotificationViewHolder(@NonNull View itemView )
        {
            super(itemView);

            userNameTxt=itemView.findViewById(R.id.name_contact);
            videoCallBtn=itemView.findViewById(R.id.call_btn);
            profileImageView=itemView.findViewById(R.id.image_contact);
            cardView=itemView.findViewById(R.id.card_view1);
        }

    }
}
