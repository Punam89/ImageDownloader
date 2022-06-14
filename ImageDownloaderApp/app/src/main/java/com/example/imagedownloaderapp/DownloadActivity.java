package com.example.imagedownloaderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DownloadActivity extends AppCompatActivity {

    private String imgLink;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        img=findViewById(R.id.imageview2);

        imgLink=getIntent().getStringExtra("image");
        Glide.with(this).load(imgLink).into(img);

    }
}