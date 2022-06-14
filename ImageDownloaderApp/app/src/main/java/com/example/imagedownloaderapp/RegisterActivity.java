package com.example.imagedownloaderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    Button btnregister;
    EditText edtuser1,edtpass1,edtemail,edtmobnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnregister=findViewById(R.id.register);
        edtuser1= findViewById(R.id.user1);
        edtpass1= findViewById(R.id.password1);
        edtemail= findViewById(R.id.email1);
        edtmobnum= findViewById(R.id.mobilenum);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if(edtuser1.getText().length()==0 && edtpass1.getText().length()==0 && edtemail.getText().length()==0 && edtmobnum.getText().length()==0) {
                        edtuser1.setError("Please Enter Username");
                        edtuser1.requestFocus();
                    }
                    else if(edtuser1.getText().length()==0){
                        edtuser1.setError("Please Enter Username");
                        edtuser1.requestFocus();
                    }
                    else if(edtpass1.getText().length()==0){
                        edtpass1.setError("Please Enter Password");
                        edtpass1.requestFocus();
                    }
                    else if(edtemail.getText().length()==0){
                        edtemail.setError("Please Enter EmailID");
                        edtemail.requestFocus();
                    }
                    else if(edtmobnum.getText().length()==0){
                        edtmobnum.setError("Please Enter MobileNumber");
                        edtmobnum.requestFocus();
                    }
                    else if(edtuser1.getText().length() != 0 && edtpass1.getText().length() != 0 && edtemail.getText().length() !=0 && edtmobnum.getText().length() !=0){
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
                catch(Exception e) {

                }
            }
        });



    }
}