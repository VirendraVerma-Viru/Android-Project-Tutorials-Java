package com.example.skypeclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FindPeopleActivity extends AppCompatActivity {

    private RecyclerView findFriendsList;
    private EditText searchET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_people);

        searchET=findViewById(R.id.editText_search);
        findFriendsList=findViewById(R.id.find_friends_list);
        findFriendsList.setLayoutManager((new LinearLayoutManager(getApplicationContext())));
    }

    public static class FindFriendsViewHolder extends RecyclerView.ViewHolder
    {
        TextView userNameTxt;
        Button acceptBtn,cancelBtn;
        ImageView profileImageView;
        RelativeLayout cardView;

        public FindFriendsViewHolder(@NonNull View itemView )
        {
            super(itemView);

            userNameTxt=itemView.findViewById(R.id.name_notofication);
            acceptBtn=itemView.findViewById(R.id.request_accept_btn);
            cancelBtn=itemView.findViewById(R.id.request_decline_btn);
            profileImageView=itemView.findViewById(R.id.image_notification);
            cardView=itemView.findViewById(R.id.card_view);
        }

    }
}
