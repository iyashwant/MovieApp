package com.example.iyashwant.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.BlurTransformation;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       // Picasso.with(this).load("http://i.imgur.com/bqHFlhl.jpg").fetch();
        RelativeLayout relativeLayout =(RelativeLayout)findViewById(R.id.spalsh_layout);
        relativeLayout.setBackgroundResource(R.mipmap.poster1);

        ImageView imageView =(ImageView)findViewById(R.id.logobg);
        imageView.setImageResource(R.drawable.bookinglogo1);

        Thread myThread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}
