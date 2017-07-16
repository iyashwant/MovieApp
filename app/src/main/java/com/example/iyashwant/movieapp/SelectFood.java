package com.example.iyashwant.movieapp;

/**
 * Created by iyashwant on 14/7/17.
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SelectFood extends AppCompatActivity {

    /*
    public static int[] food_images = {R.drawable.popcorn, R.drawable.caramel, R.drawable.coke, R.drawable.hotdog, R.drawable.nachos, R.drawable.puff, R.drawable.water};
    public static String[] food_names = {"popcorn", "caramel popcorn", "coke", "hotdog", "nachos", "puff", "water"};
    public static int[] food_prices = {100,110,90,90,140,70,30};
    public static int[] quantities = {0,0,0,0,0,0,0}; */

    ArrayList<FoodItem> foodItems;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_food);

        next=(Button)findViewById(R.id.button_food);

        final Bundle bundle = getIntent().getExtras();
        final String number2 = bundle.getString("f_no");
        final String screen2 =bundle.getString("f_screen");
        final String tim2 =bundle.getString("f_time");
        final String nam2 =bundle.getString("f_name");
        final String total2 =bundle.getString("f_total");
        final int pos =bundle.getInt("f_pos");
        final String date1 = bundle.getString("f_date");

        final Intent goToNextActivity = new Intent(getApplicationContext(), Payment.class);
        //Intent goToNextActivity3 = new Intent(getApplicationContext(),Payment.class);
        final Bundle bundle1 = new Bundle();
        //   bundle.putString("name",name);
        bundle1.putString("p_name",nam2);
        bundle1.putString("p_time",tim2);
        bundle1.putString("p_screen",screen2);
        bundle1.putString("p_no",number2);
        bundle1.putString("p_total",total2);
        bundle1.putInt("p_pos",pos);
        bundle1.putString("p_date",date1);


        //Toast.makeText(this, nam2, Toast.LENGTH_SHORT).show();

/*
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar_food);
*/
        foodItems = new ArrayList<FoodItem>();

        final String showName = getIntent().getStringExtra("show_name");
        final String showTime = getIntent().getStringExtra("show_time");
        final String showTicket = getIntent().getStringExtra("ticket");
        final String showMonth = getIntent().getStringExtra("month");
        final String showDay = getIntent().getStringExtra("day");
        final String movieName = getIntent().getStringExtra("film_name");
        final String movieCertif = getIntent().getStringExtra("film_cert");
        String price = getIntent().getStringExtra("price");


        foodItems.add(new FoodItem("https://d3jkudlc7u70kh.cloudfront.net/popcorn-snack-fact.jpg" ,"popcorn", 100, 0));
        foodItems.add(new FoodItem("http://www.seriouseats.com/recipes/assets_c/2012/03/20120305-195841-Bar-Snacks-ChicagoMix-thumb-625xauto-223650.jpg", "caramel popcorn", 110, 0));
        foodItems.add(new FoodItem("https://sc01.alicdn.com/kf/UT8xyK7XRlaXXagOFbXT/FANTA-330ML-SOFT-DRINKS.jpg", "soft drink", 90, 0));
        foodItems.add(new FoodItem("https://us.123rf.com/450wm/luizrocha/luizrocha1602/luizrocha160200666/51638539-buger.jpg?ver=6", "burger", 100, 0));
        foodItems.add(new FoodItem("http://hagerstownpizzabrothers.com/wp-content/uploads/2014/12/French-Fries.jpg", "french fries", 90, 0));
        foodItems.add(new FoodItem("http://www.hormel.com/getattachment/e3e43b5e-2582-4fec-8c1e-78aa675bbf64/Chili-Nachos.aspx", "nachos", 140, 0));
        foodItems.add(new FoodItem("https://firstlookthencook.files.wordpress.com/2010/05/chicken-puffs.jpg", "puff", 70, 0));



        FoodAdapter adapter = new FoodAdapter(SelectFood.this, R.layout.food_item, foodItems);
        final ListView listViewFood = (ListView)findViewById(R.id.listViewFood);
        listViewFood.setAdapter(adapter);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextActivity.putExtras(bundle1);
                startActivity(goToNextActivity);
            }
        });

    }

    @Override
    public void onBackPressed()
    {
        this.finish();
        overridePendingTransition(R.anim.left_out, R.anim.right_enter);
    }

    public void showToastMessage(String text, int duration){
        final Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, duration);
    }

}