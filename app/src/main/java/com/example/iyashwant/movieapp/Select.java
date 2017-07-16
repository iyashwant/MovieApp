package com.example.iyashwant.movieapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import jp.wasabeef.picasso.transformations.BlurTransformation;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import jp.wasabeef.blurry.Blurry;

public class Select extends AppCompatActivity {

    TextView movieName;
    public String days[]={"","Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    public int count;
    String [] links ={"https://www.desiretrees.in/wp-content/uploads/2017/04/Bahubali-2-Releaese-Date-New-Baahubali-2-Poster-Latest-2017-HD-Images.jpg","https://i0.wp.com/media2.slashfilm.com/slashfilm/wp/wp-content/images/baby-driver-poster.jpg",
            "https://s-media-cache-ak0.pinimg.com/originals/31/31/02/31310248b900b89687984d8d95bb3584.jpg","https://movies.universalpictures.com/media/dm3-adv1sheet-rgb-5-58c818a68f809-1.png","http://assets1.ignimgs.com/2017/03/24/spider-man-homecoming-1490381333042_610w.jpg",
            "https://s-media-cache-ak0.pinimg.com/originals/3c/2d/ce/3c2dce90356d91c7b81e28a2e7436de2.jpg","https://cdn.traileraddict.com/content/warner-bros-pictures/wonder-woman-2017-5.jpg","https://s-media-cache-ak0.pinimg.com/originals/3c/2d/ce/3c2dce90356d91c7b81e28a2e7436de2.jpg",
            "http://data1.ibtimes.co.in/cache-img-857-0-photo/en/full/60292/1487911387_ninnu-kori-upcoming-telugu-movie-starring-nani-aadhi-nivetha-thomas-lead-role.jpg","http://thestoryscoop.com/wp-content/uploads/2017/05/C_YwhXxXgAAKsu7.jpg",
            "http://www.filmibeat.com/img/220x80x275/popcorn/movie_posters/thondimuthalum-driksakshiyum-20170629144731-15216.jpg","https://www.flickeringmyth.com/wp-content/uploads/2017/05/The-Big-Sick-poster.jpg"};


    String result;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);



        final Bundle bundle = new Bundle();
       // final Intent double_next = new Intent(Select.this,)
        final Intent goToNextActivity = new Intent(Select.this,Seats.class);
        //final Intent goToNextActivity2 = new Intent(Select.this,Seats.class);





        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);


        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);



        // setting list adapter
        expListView.setAdapter(listAdapter);



       Bundle bundle1 = getIntent().getExtras();
        String name = bundle1.getString("stuff");
       //movieName=(TextView)findViewById(R.id.textViewMoviename);
       // movieName.setText(name);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("EEE");
       String strDay = mdformat.format(calendar.getTime());
        SimpleDateFormat mdformat2 = new SimpleDateFormat("dd");
        String strDate= mdformat2.format(calendar.getTime());

        //String strDay="Thu";

        switch (strDay)
        {
            case "Sun" : count=1;
                break;
            case "Mon": count=2;
                break;
            case "Tue": count=3;
                break;
            case "Wed": count=4;
                break;
            case "Thu": count=5;
                break;
            case "Fri": count=6;
                break;
            case "Sat": count=7;

                //Toast.makeText(this, "sun", Toast.LENGTH_SHORT).show();
        }


        int dateCount= Integer.parseInt(strDate);
        int newCont=count;
       // movieName.setText(strDate);
       //; final String [] tickets={"1","2","3","4","5","6","7","8","9","10"};
        final List<String> spinnerArray =  new ArrayList<String>();
        for(int i=1; i<10;i++) {

            spinnerArray.add(String.valueOf(i));
        }
        //spinnerArray.add("item2");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sNumber = (Spinner) findViewById(R.id.spinner);
        sNumber.setAdapter(adapter);

         sNumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int pos, long id) {

// Your variable should update here
             result = parent.getItemAtPosition(pos).toString();
              //  goToNextActivity.putExtra("num_tickets",result);
               bundle.putString("numberofseats",result);
               goToNextActivity.putExtras(bundle);
              //  goToNextActivity2.putExtras(bundle);


            }



            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        List<String> spinnerArray1 =  new ArrayList<String>();

        for (int j =1 ;j<8;j++)
        {
            if (count==8) {
                count=1;
                spinnerArray1.add(days[count]+", " + dateCount);
                dateCount++;
                count++;
            }
            else {
                spinnerArray1.add(days[count]+", " + dateCount);
               // spinnerArray1.add("item2");
                dateCount++;
                count++;

            }

        }



        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                this,R.layout.spinner_item, spinnerArray1);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sDates = (Spinner) findViewById(R.id.spinner2);
        sDates.setAdapter(adapter1);

        sDates.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                result = parent.getItemAtPosition(position).toString();
                bundle.putString("date",result);
                goToNextActivity.putExtras(bundle);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        final String nameM = bundle1.getString("name");
        final int pos =bundle1.getInt("posi");

        final RelativeLayout layout =(RelativeLayout)findViewById(R.id.select_screen);
        //ViewGroup header = (ViewGroup) getLayoutInflater().inflate(R.layout.list_header, null);
        ViewGroup view = (ViewGroup) findViewById(R.id.select_screen);
        //   layout.setBackgroundResource(R.drawable.ready);
        //  layout = new layout.setBackgroundResource();
        // Picasso.with(this).load("https://img.spicinemas.in/resources/images/home/image-3.jpg").into(layout);

       //q1 Toast.makeText(this,String.valueOf(pos), Toast.LENGTH_SHORT).show();
        //Picasso.with(this).load("https://www.desiretrees.in/wp-content/uploads/2017/04/Bahubali-2-Releaese-Date-New-Baahubali-2-Poster-Latest-2017-HD-Images.jpg").into(im1);
        Picasso.with(this).load(links[pos]).transform(new BlurTransformation(this)).resize(350,600).into(new Target() {
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






        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                bundle.putString("header",listDataHeader.get(groupPosition));
                bundle.putString("sub",listDataChild.get(
                        listDataHeader.get(groupPosition)).get(
                        childPosition));
                bundle.putString("Mname",nameM);
                bundle.putInt("s_pos",pos);

                goToNextActivity.putExtras(bundle);
               // goToNextActivity2.putExtras(bundle);
                startActivity(goToNextActivity);
             /*   Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();

                        */
                return false;
            }
        });


    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Sathyam");
        listDataHeader.add("Escape");
        listDataHeader.add("Pvr");
        listDataHeader.add("Ags");
        listDataHeader.add("Inox");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("10:00 AM");
        top250.add("01:30 AM");
        top250.add("05:20 AM");
        top250.add("09:00 AM");


        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), top250);
        listDataChild.put(listDataHeader.get(2), top250);
        listDataChild.put(listDataHeader.get(3), top250);
        listDataChild.put(listDataHeader.get(4), top250);
       // listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}
