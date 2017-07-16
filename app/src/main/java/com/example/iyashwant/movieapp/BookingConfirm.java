package com.example.iyashwant.movieapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class BookingConfirm extends AppCompatActivity {

    TextView conf_movie,conf_certif,conf_theatre,conf_tickets,conf_details,conf_bookid;
    ImageView conf_image;

    DBAdapter2 myDb2;

    String [] links ={"https://www.desiretrees.in/wp-content/uploads/2017/04/Bahubali-2-Releaese-Date-New-Baahubali-2-Poster-Latest-2017-HD-Images.jpg","https://i0.wp.com/media2.slashfilm.com/slashfilm/wp/wp-content/images/baby-driver-poster.jpg",
            "https://s-media-cache-ak0.pinimg.com/originals/31/31/02/31310248b900b89687984d8d95bb3584.jpg","https://movies.universalpictures.com/media/dm3-adv1sheet-rgb-5-58c818a68f809-1.png","http://assets1.ignimgs.com/2017/03/24/spider-man-homecoming-1490381333042_610w.jpg",
            "https://cdn.traileraddict.com/content/warner-bros-pictures/wonder-woman-2017-5.jpg","https://s-media-cache-ak0.pinimg.com/originals/3c/2d/ce/3c2dce90356d91c7b81e28a2e7436de2.jpg",
            "http://data1.ibtimes.co.in/cache-img-857-0-photo/en/full/60292/1487911387_ninnu-kori-upcoming-telugu-movie-starring-nani-aadhi-nivetha-thomas-lead-role.jpg","http://thestoryscoop.com/wp-content/uploads/2017/05/C_YwhXxXgAAKsu7.jpg",
            "http://www.filmibeat.com/img/220x80x275/popcorn/movie_posters/thondimuthalum-driksakshiyum-20170629144731-15216.jpg","https://www.flickeringmyth.com/wp-content/uploads/2017/05/The-Big-Sick-poster.jpg"
    };
    Button explore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirm);
        openDB();
        final LinearLayout layout =(LinearLayout) findViewById(R.id.details_background_confirm);

        final Bundle bundle = getIntent().getExtras();
        final String number2 = bundle.getString("c_no");
        final String screen2 =bundle.getString("c_screen");
        final String tim2 =bundle.getString("c_time");
        final String nam2 =bundle.getString("c_name");
        final String total2 =bundle.getString("c_total");
        final int pos =bundle.getInt("c_pos");
        final String date1 =bundle.getString("c_date");

        Toast.makeText(this, nam2, Toast.LENGTH_SHORT).show();
        /*

        final String showTime = getIntent().getStringExtra("show_time");
        final String showTicket = getIntent().getStringExtra("ticket");
        final String showMonth = getIntent().getStringExtra("month");
        final String showDay = getIntent().getStringExtra("day");
        final String movieName = getIntent().getStringExtra("film_name");
        final String movieCertif = getIntent().getStringExtra("film_cert");
        final String showTheatre = getIntent().getStringExtra("theatre");
        final String ticketcost = getIntent().getStringExtra("ticketcost");

        */


        conf_movie = (TextView) findViewById(R.id.conf_movie);
        conf_movie.setText(nam2);
       // conf_certif = (TextView) findViewById(R.id.conf_certif);
        //conf_certif.setText(movieCertif);
        conf_theatre = (TextView) findViewById(R.id.conf_theatre);
        conf_theatre.setText(screen2 + " | " + date1 + " | "+ tim2);
       /// conf_details = (TextView) findViewById(R.id.conf_details);
       // conf_details.setText("Date: " + showDay + " " + showMonth + " 2017");
        conf_tickets = (TextView) findViewById(R.id.conf_tickets);
        conf_tickets.setText(number2 + " Tickets  ₹" + total2 );

        conf_bookid = (TextView) findViewById(R.id.conf_bookid);
        MyStringRandomGen random = new MyStringRandomGen();
        conf_bookid.setText(" booking id: " + random.generateRandomString().toLowerCase() + " ");

        myDb2.insertRow_details(conf_theatre.getText().toString(),nam2,conf_tickets.getText().toString(),conf_bookid.getText().toString());

        conf_image = (ImageView) findViewById(R.id.conf_image);

        /*
        switch(movieName){
            case "Bahubali 2" :
                conf_image.setImageResource(R.drawable.bahu);
                break;

            case "Boss Baby" :
                conf_image.setImageResource(R.drawable.boss);
                break;

            case "Baby Driver" :
                conf_image.setImageResource(R.drawable.baby);
               break;

            case "The Big Sick" :
                conf_image.setImageResource(R.drawable.theb);
                break;

            case "Cars 3" :
                conf_image.setImageResource(R.drawable.cars);
                break;

            case "DJ" :
                conf_image.setImageResource(R.drawable.duvv);
                break;

            case "Despicable Me 3" :
                conf_image.setImageResource(R.drawable.desp);
                break;

            case "Guest iin London" :
                conf_image.setImageResource(R.drawable.gues);
                break;

            case "Hindi Medium" :
                conf_image.setImageResource(R.drawable.hind);
                break;

            case "Ivan Thanthiran" :
                conf_image.setImageResource(R.drawable.ivan);
                break;

            case "MOM" :
                conf_image.setImageResource(R.drawable.momm);
                break;

            case "Spiderman Homecoming" :
                conf_image.setImageResource(R.drawable.spid);
                break;

            case "Tubelight" :
                conf_image.setImageResource(R.drawable.tube);
                break;

            case "Vanamagan" :
                conf_image.setImageResource(R.drawable.vana);
                break;

            case "Wonder Woman" :
                conf_image.setImageResource(R.drawable.wond);
                break;
        }

        */

       /* explore = (Button) findViewById(R.id.explore);

        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movetoEntry = new Intent(BookingConfirm.this,MovieDetails.class);
                startActivity(movetoEntry);
                overridePendingTransition(R.anim.right_enter, R.anim.left_out);
            }
        });

        */


        Picasso.with(this).load(links[pos]).resize(350,600).into(new Target() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                layout.setBackground(new BitmapDrawable(bitmap));
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }

        });



        Button book =(Button)findViewById(R.id.buttonBook);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startActi= new Intent(getApplicationContext(),Movies.class);
                startActivity(startActi);
            }
        });

    }


    private void openDB()
    {
        myDb2= new DBAdapter2(this);
        myDb2.open();

    }

}



