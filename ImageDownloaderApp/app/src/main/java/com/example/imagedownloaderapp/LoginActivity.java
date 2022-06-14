package com.example.imagedownloaderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    EditText edtemail, edtpassword;
    Button Login;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtemail = findViewById(R.id.email2);
        edtpassword = findViewById(R.id.password2);
        textView=findViewById(R.id.register_tv);
        Login= findViewById(R.id.btnlogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    if(edtemail.getText().length()==0 && edtpassword.getText().length()==0) {
                        edtemail.setError("Please Enter Username");
                        edtemail.requestFocus();
                    }
                    else if(edtemail.getText().length()==0){
                        edtemail.setError("Please Enter Username");
                        edtemail.requestFocus();
                    }
                    else if(edtpassword.getText().length()==0){
                        edtpassword.setError("Please Enter Password");
                        edtpassword.requestFocus();
                    }
                    else if(edtemail.getText().length() != 0 && edtpassword.getText().length() !=0){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
                catch(Exception e) {

                }

            }
        });


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });


    }



}