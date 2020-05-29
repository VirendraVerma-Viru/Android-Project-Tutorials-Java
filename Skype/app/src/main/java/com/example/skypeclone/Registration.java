package com.example.skypeclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;

public class Registration extends AppCompatActivity {

    private CountryCodePicker ccp;
    private EditText phoneText;
    private EditText codeText;
    private Button continueAndNextButton;
    private String checker="",phoneNumber="";
    private RelativeLayout relativeLayout;

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private FirebaseAuth mAuth;
    private String mVerificationId;
    private PhoneAuthProvider.ForceResendingToken mResendText;
    private ProgressDialog loadingBar;

    @Override
    protected void onStart() {
        super.onStart();
            //autologin afterregistration
        FirebaseUser firebaseUser=FirebaseAuth.getInstance().getCurrentUser();

        if(firebaseUser!=null)
        {
            Intent homeIntent=new Intent(Registration.this, ContactsActivity.class);
            startActivity(homeIntent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth=FirebaseAuth.getInstance();
        loadingBar=new ProgressDialog(this);
        phoneText=findViewById(R.id.phoneText);
        codeText=findViewById(R.id.codeText);
        continueAndNextButton=findViewById(R.id.continueNextButton);
        relativeLayout=findViewById(R.id.phoneAuth);

        ccp=(CountryCodePicker) findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(phoneText);


        continueAndNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(continueAndNextButton.getText().equals("Submit")||checker.equals("Code Sent"))
                {
                    String verificationCode=codeText.getText().toString();

                    if(verificationCode.equals("")) {

                        Toast.makeText(Registration.this, "Please Wrie Verification Code", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Registration.this, "Have Code", Toast.LENGTH_SHORT).show();
                        loadingBar.setTitle("Phone Number Verification");
                        loadingBar.setMessage("Please Wait,verifying your coede");
                        loadingBar.setCanceledOnTouchOutside(false);
                        loadingBar.show();

                        PhoneAuthCredential credintial=PhoneAuthProvider.getCredential(mVerificationId,verificationCode);
                        signInWithPhoneAuthCredential(credintial);
                    }
                }
                else {

                    phoneNumber=ccp.getFullNumberWithPlus();
                    if(!phoneNumber.equals("")) {
                        Toast.makeText(Registration.this, "Code Sent", Toast.LENGTH_SHORT).show();
                        loadingBar.setTitle("Phone Number Verification");
                        loadingBar.setMessage("Please Wait");
                        loadingBar.setCanceledOnTouchOutside(false);
                        loadingBar.show();

                        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNumber,60,TimeUnit.SECONDS,Registration.this,mCallbacks);

                    }else{
                        Toast.makeText(Registration.this, "Not Submit", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        mCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }


            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(Registration.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                loadingBar.dismiss();
                continueAndNextButton.setText("Continue");
                relativeLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                mVerificationId=s;
                mResendText=forceResendingToken;
                relativeLayout.setVisibility(View.GONE);
                checker="Code Sent";
                continueAndNextButton.setText("Submit");
                codeText.setVisibility(View.VISIBLE);
                Toast.makeText(Registration.this, "Code has been Sent", Toast.LENGTH_SHORT).show();
            }
        };


    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithCredential:success");
                            loadingBar.dismiss();
                            Toast.makeText(Registration.this, "Congrats", Toast.LENGTH_SHORT).show();
                            sendUserToMainActivity();
                            //FirebaseUser user = task.getResult().getUser();
                            // ...
                        } else {

                            loadingBar.dismiss();
                            String s=task.getException().toString();
                            Toast.makeText(Registration.this, s, Toast.LENGTH_SHORT).show();
                            // Sign in failed, display a message and update the UI
                           // Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                            }
                        }
                    }
                });
    }

    private void sendUserToMainActivity()
    {

        Intent intent=new Intent(this, ContactsActivity.class);
        startActivity(intent);
        finish();
    }
}
