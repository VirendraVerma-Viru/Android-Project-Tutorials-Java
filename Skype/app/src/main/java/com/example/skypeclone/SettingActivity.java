package com.example.skypeclone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.util.HashMap;

public class SettingActivity extends AppCompatActivity {

    private Button saveBtn;
    private EditText userNameET,userBioET;
    private ImageView profileImageView;

    private static int GalleryPic=1;
    private Uri imageUri;

    private String downloadURL;
    private StorageReference userProfileImgRef;
    private DatabaseReference userRef;

    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        userProfileImgRef= FirebaseStorage.getInstance().getReference().child("Profile Images");
        userRef= FirebaseDatabase.getInstance().getReference().child("Users");
        progressDialog=new ProgressDialog(this);
        saveBtn=findViewById(R.id.save_settings_btn);
        userNameET=findViewById(R.id.username_settings);
        userBioET=findViewById(R.id.bio_settings);
        profileImageView=findViewById(R.id.settings_profile_image);

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallaryIntent=new Intent();
                gallaryIntent.setAction(Intent.ACTION_GET_CONTENT);
                gallaryIntent.setType("image/*");
                startActivityForResult(gallaryIntent,GalleryPic);
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserData();
            }
        });
        retrieveUserInfo();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==GalleryPic&&resultCode==RESULT_OK&&data!=null)
        {
            imageUri=data.getData();
            profileImageView.setImageURI(imageUri);
        }
    }

    private void saveUserData()
    {
        final String getUserName=userNameET.getText().toString();
        final  String getUserStatus=userBioET.getText().toString();

        if(imageUri==null)
        {
            userRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).hasChild("image"))
                    {
                        saveInfoOnlyWithoutImage1();

                    }else{
                        Toast.makeText(SettingActivity.this, "Please Select Image First", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }else if(getUserName.equals(""))
        {
            Toast.makeText(this, "User Name is mendatory", Toast.LENGTH_SHORT).show();
        }
        else if(getUserStatus.equals(""))
        {
            Toast.makeText(this, "Status is mendatory", Toast.LENGTH_SHORT).show();
        }else{
            progressDialog.setTitle("Account Settings");
            progressDialog.setMessage("Please wait...");
            progressDialog.show();
            final StorageReference filePath=userProfileImgRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid());

            final UploadTask uploadTask=filePath.putFile(imageUri);
            Toast.makeText(this, "Uploading File", Toast.LENGTH_SHORT).show();
            uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(SettingActivity.this, "Image Failed", Toast.LENGTH_SHORT).show();
                        throw task.getException();
                    }
                    Toast.makeText(SettingActivity.this, "Image Downloaded", Toast.LENGTH_SHORT).show();
                    downloadURL=filePath.getDownloadUrl().toString();

                    return filePath.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(SettingActivity.this, "making hash", Toast.LENGTH_SHORT).show();
                        downloadURL=task.getResult().toString();
                        HashMap<String,Object> profileMap=new HashMap<>();
                        profileMap.put("uid",FirebaseAuth.getInstance().getCurrentUser().getUid());
                        profileMap.put("name",getUserName);
                        profileMap.put("status",getUserStatus);
                        profileMap.put("image",downloadURL);

                        userRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(profileMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()) {
                                    Intent intent = new Intent(SettingActivity.this, ContactsActivity.class);
                                    startActivity(intent);
                                    finish();

                                progressDialog.dismiss();
                                Toast.makeText(SettingActivity.this, "Profile Has been Updated", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            });
        }


    }

    private void saveInfoOnlyWithoutImage1() {
        final String getUserName=userNameET.getText().toString();
        final  String getUserStatus=userBioET.getText().toString();


        if(getUserName.equals(""))
        {
            Toast.makeText(this, "User Name is mendatory", Toast.LENGTH_SHORT).show();
        }
        else if(getUserStatus.equals(""))
        {
            Toast.makeText(this, "Status is mendatory", Toast.LENGTH_SHORT).show();
        }else {
            progressDialog.setTitle("Account Settings");
            progressDialog.setMessage("Please wait...");
            progressDialog.show();
            HashMap<String,Object> profileMap=new HashMap<>();
            profileMap.put("uid",FirebaseAuth.getInstance().getCurrentUser().getUid());
            profileMap.put("name",getUserName);
            profileMap.put("status",getUserStatus);

            userRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(profileMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()) {
                        Intent intent = new Intent(SettingActivity.this, ContactsActivity.class);
                        startActivity(intent);
                        finish();

                        progressDialog.dismiss();
                        Toast.makeText(SettingActivity.this, "Profile Has been Updated", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void retrieveUserInfo()
    {
        userRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    String imageDb=dataSnapshot.child("image").getValue().toString();
                    String nameDb=dataSnapshot.child("name").getValue().toString();
                    String bioDb=dataSnapshot.child("status").getValue().toString();

                    userNameET.setText(nameDb);
                    userBioET.setText(bioDb);
                    Picasso.get().load(imageDb).placeholder(R.drawable.profile_image).into(profileImageView);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
