package com.example.imagedownloaderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class fullscreenActivity extends AppCompatActivity {

    private PhotoView photoView;
    private String imgLink;

    ImageButton shareButton1,likeButton2,downloadButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        photoView=findViewById(R.id.photoView);
        shareButton1=findViewById(R.id.imgbtn1);
        likeButton2=findViewById(R.id.imgbtn2);
        downloadButton3=findViewById(R.id.imgbtn3);

        imgLink=getIntent().getStringExtra("img");
        Glide.with(this).load(imgLink).into(photoView);

        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        shareButton1.startAnimation(animation);
        likeButton2.startAnimation(animation);
        downloadButton3.startAnimation(animation);

        shareButton1.setOnClickListener(new View.OnClickListener() {
        @Override
         public void onClick(View view) {

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        sharingIntent.setType("text/*");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, imgLink);
        startActivity(Intent.createChooser(sharingIntent, "Share image using"));

        }
        });

        likeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        downloadButton3.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {

                try {
        File mydir = new File(Environment.getExternalStorageState() + "/ImageDownloader");
        if (!mydir.exists()) {
         mydir.mkdirs();
        }
         DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
         Uri downloadUri = Uri.parse(imgLink);
         DownloadManager.Request request = new DownloadManager.Request(downloadUri);

         SimpleDateFormat dateFormat = new SimpleDateFormat("mmddyyyyhhmmss");
         String date = dateFormat.format(new Date());
         request.setDestinationInExternalPublicDir("/ImageDownloader", date + ".png");
         manager.enqueue(request);
          Toast toast1 = Toast.makeText(getApplicationContext(), "Downloading Start", Toast.LENGTH_SHORT);
         toast1.setGravity(Gravity.CENTER, 0, 0);
         toast1.show();
        }
    catch (Exception e){

         }

     }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fullscreenmenu, menu);
        return  super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== R.id.homescreen)
        {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    WallpaperManager wallpaperManager = WallpaperManager.getInstance(fullscreenActivity.this);
                    Bitmap bitmap = ((BitmapDrawable) photoView.getDrawable()).getBitmap();
                    try {
                        wallpaperManager.setBitmap(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast toast1=Toast.makeText(fullscreenActivity.this, " HomeScreen Wallpaper Set", Toast.LENGTH_SHORT);
                    toast1.setGravity(Gravity.CENTER,0,0);
                    toast1.show();
                }
            }, 2000);

        }

        if(item.getItemId()== R.id.lockscreen)
        {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    WallpaperManager wallpaperManager = WallpaperManager.getInstance(fullscreenActivity.this);
                    Bitmap bitmap = ((BitmapDrawable) photoView.getDrawable()).getBitmap();
                    try {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK);

                            Toast toast1=Toast.makeText(fullscreenActivity.this, "LockScreen Wallpaper Set", Toast.LENGTH_SHORT);
                            toast1.setGravity(Gravity.CENTER,0,0);
                            toast1.show();
                        }
                        else
                            {
                                Toast toast1= Toast.makeText(fullscreenActivity.this, "Wallpaper Not Set", Toast.LENGTH_SHORT);
                                toast1.setGravity(Gravity.CENTER,0,0);
                                toast1.show();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }, 2000);


        }

        if(item.getItemId()== R.id.fullscreen)
        {
            RelativeLayout relativeLayout=findViewById(R.id.relativelayout1);
            relativeLayout.getLayoutParams().width = RelativeLayout.LayoutParams.MATCH_PARENT;
            relativeLayout.getLayoutParams().height = RelativeLayout.LayoutParams.MATCH_PARENT;
            relativeLayout.requestLayout();

        }

        return super.onOptionsItemSelected(item);
    }






}

