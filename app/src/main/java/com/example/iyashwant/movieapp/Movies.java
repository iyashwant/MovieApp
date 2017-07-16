package com.example.iyashwant.movieapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.BlurTransformation;

public class Movies extends AppCompatActivity {

    private ViewFlipper flip;
    private float initialX;
    private ImageView image1,image2,image3;
    public String name;

    List<String> list;
    String[] imageId = {
            "https://img.spicinemas.in/resources/images/movies/baahubali-2-tamil/150x207.jpg","https://img.spicinemas.in/resources/images/movies/baby-driver/150x207.jpg",
            "https://img.spicinemas.in/resources/images/movies/cars-3/150x207.jpg","https://img.spicinemas.in/resources/images/movies/despicable-me-3/150x207.jpg",
            "https://img.spicinemas.in/resources/images/movies/spider-man-homecoming/150x207.jpg","https://img.spicinemas.in/resources/images/movies/the-boss-baby/150x207.jpg",
            "https://img.spicinemas.in/resources/images/movies/guest-iin-london/150x207.jpg","https://img.spicinemas.in/resources/images/movies/wonder-woman/150x207.jpg",
            "https://img.spicinemas.in/resources/images/movies/ninnu-kori/150x207.jpg","https://img.spicinemas.in/resources/images/movies/thondimuthalum-dhriksakshiyum/150x207.jpg",
            "https://img.spicinemas.in/resources/images/movies/tubelight-hindi/150x207.jpg","https://img.spicinemas.in/resources/images/movies/the-big-sick/150x207.jpg"

          /*  R.drawable.fab_add,
            R.drawable.ic_action_exit,
            R.drawable.ic_action_plus,
            R.drawable.ic_menu_camera,
            R.drawable.ic_menu_send,
            R.drawable.ic_menu_share */
    };

    String[] movieNames = {
            "BAAHUBALI 2",
            "BABY DRIVER",
            "CARS 3",
            "DESPICABLE ME 3",
            "SPIDER MAN",
            "THE BOSS BABY",
            "GUEST IIN LONDON",
            "WONDER WOMEN",
            "NINNU KORI",
            "THONDIMUTHALUM DHRIKSAKSHIYUM",
            "TUBELIGHT","THE BIG SICK"

    } ;

    private RecyclerView rvFeed;
    private FlowingDrawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        ActionBar bar =getSupportActionBar();
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        bar.setDisplayShowCustomEnabled(true);
        bar.setCustomView(R.layout.actionbar_movies);
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00b2ff")));

        ImageView logo = (ImageView) bar.getCustomView().findViewById(R.id.logo_action);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mDrawer.toggleMenu();
            }
        });

        ScrollView scrollView = (ScrollView) findViewById(R.id.movie_scroll) ;
        scrollView.smoothScrollTo(0, 0);


        Picasso.with(this).load("https://www.desiretrees.in/wp-content/uploads/2017/04/Bahubali-2-Releaese-Date-New-Baahubali-2-Poster-Latest-2017-HD-Images.jpg").resize(350,600).fetch();
        Picasso.with(this).load("https://i0.wp.com/media2.slashfilm.com/slashfilm/wp/wp-content/images/baby-driver-poster.jpg").resize(350,600).fetch();
        Picasso.with(this).load("https://s-media-cache-ak0.pinimg.com/originals/31/31/02/31310248b900b89687984d8d95bb3584.jpg").resize(350,600).fetch();
        Picasso.with(this).load("https://movies.universalpictures.com/media/dm3-adv1sheet-rgb-5-58c818a68f809-1.png").resize(350,600).fetch();
        Picasso.with(this).load("https://www.desiretrees.in/wp-content/uploads/2017/04/Bahubali-2-Releaese-Date-New-Baahubali-2-Poster-Latest-2017-HD-Images.jpg").transform(new BlurTransformation(this)).fetch();
        Picasso.with(this).load("http://assets1.ignimgs.com/2017/03/24/spider-man-homecoming-1490381333042_610w.jpg").resize(350,600).fetch();
        Picasso.with(this).load("https://cdn.traileraddict.com/content/warner-bros-pictures/wonder-woman-2017-5.jpg").resize(350,600).fetch();
        Picasso.with(this).load("https://s-media-cache-ak0.pinimg.com/originals/3c/2d/ce/3c2dce90356d91c7b81e28a2e7436de2.jpg").resize(350,600).fetch();
        Picasso.with(this).load("http://data1.ibtimes.co.in/cache-img-857-0-photo/en/full/60292/1487911387_ninnu-kori-upcoming-telugu-movie-starring-nani-aadhi-nivetha-thomas-lead-role.jpg").resize(350,600).fetch();
        Picasso.with(this).load("http://thestoryscoop.com/wp-content/uploads/2017/05/C_YwhXxXgAAKsu7.jpg").resize(350,600).fetch();
        Picasso.with(this).load("https://cdn.pinkvilla.com/files/Salman-Khan-to-pay-back-distributors.jpg").resize(350,600).fetch();
        Picasso.with(this).load("http://www.filmibeat.com/img/220x80x275/popcorn/movie_posters/thondimuthalum-driksakshiyum-20170629144731-15216.jpg").resize(350,600).fetch();
        Picasso.with(this).load("https://www.flickeringmyth.com/wp-content/uploads/2017/05/The-Big-Sick-poster.jpg").resize(350,600).fetch();




        image1=(ImageView)findViewById(R.id.image1);
        image2=(ImageView)findViewById(R.id.image2);
        image3=(ImageView)findViewById(R.id.image3);

        flip = (ViewFlipper) findViewById(R.id.viewFlipper1);

        Picasso.with(this).load("https://img.spicinemas.in/resources/images/home/image-3.jpg").into(image1);
        Picasso.with(this).load("https://img.spicinemas.in/resources/images/home/image-4.jpg").into(image2);
        Picasso.with(this).load("https://img.spicinemas.in/resources/images/home/image-2.jpg").into(image3);

        flip.setInAnimation(this, R.anim.right_enter);
        flip.setOutAnimation(this, R.anim.left_out);
        flip.setFlipInterval(4000);
        flip.startFlipping();


       // rvFeed = (RecyclerView) findViewById(R.id.rvFeed);
    //    mDrawer = (FlowingDrawer) findViewById(R.id.drawerlayout);

      //  rvFeed = (RecyclerView) findViewById(R.id.rvFeed);
      //  mDrawer = (FlowingDrawer) findViewById(R.id.drawerlayout);
     //   mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);

        //ActionBar bar = getSupportActionBar();
        //bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //bar.setDisplayShowCustomEnabled(true);
        //bar.setCustomView(R.layout.actionbar_movies);



        //  setupToolbar();
        //setupFeed();
       // setupMenu();


//        ImageView imageView = (ImageView) findViewById(R.id.image1);
        ImageAdapter adapter = new ImageAdapter(Movies.this,movieNames,
                imageId);
        GridView grid=(GridView)findViewById(R.id.grid_view);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


               ImageView image = (ImageView)view.findViewById(R.id.grid_item_image);
                //Picasso.with(getApplicationContext()).load("https://img.spicinemas.in/resources/images/home/image-2.jpg").into(image);
                name=movieNames[position];

               Intent goToNextActivity = new Intent(getApplicationContext(), MovieDetails.class);
               Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putInt("pos",position);
                goToNextActivity.putExtras(bundle);
                startActivity(goToNextActivity);



            }
        });


        // Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(imageView);
    }

    // Implementing touch event for view flipper
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                // Getting intitial by event action down
                initialX = event.getX();
                break;

            case MotionEvent.ACTION_UP:

                // On action up the flipper will start and showing next item
                float finalX = event.getX();
                if (initialX > finalX) {

                    // Show items are 4
                    if (flip.getDisplayedChild() == 4)
                        break;

                    // Flip show next will show next item
                    flip.showNext();
                } else {

                    // If flip has no items more then it will display previous item
                    if (flip.getDisplayedChild() == 0)
                        break;
                    flip.showPrevious();
                }
                break;
        }
        return false;
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.flip_by_interval:

                // This will set the flipper automatic and timing is 2sec between
                // flipping
                flip.setFlipInterval(2000);
                flip.startFlipping();
                break;

            case R.id.flip_on_click:

                // If flipper is already flipping it will stop flipping and show
                // next if not flipping
                if (flip.isFlipping()) {
                    flip.stopFlipping();
                }
                flip.showNext();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    */

    protected void setupToolbar() {



      //  ImageView imageView = (ImageView) bar.getCustomView().findViewById(R.id.logo_action);
       // imageView.setImageResource(R.drawable.ic_log_hori);


    }
/*
    private void setupMenu() {
        FragmentManager fm = getSupportFragmentManager();
        MenuListFragment mMenuFragment = (MenuListFragment) fm.findFragmentById(R.id.id_container_menu);
        if (mMenuFragment == null) {
            mMenuFragment = new MenuListFragment();
            fm.beginTransaction().add(R.id.id_container_menu, mMenuFragment).commit();
        }

        mDrawer.setOnDrawerStateChangeListener(new ElasticDrawer.OnDrawerStateChangeListener() {
            @Override
           public void onDrawerStateChange(int oldState, int newState) {
                if (newState == ElasticDrawer.STATE_CLOSED) {
                    Log.i("MainActivity", "Drawer STATE_CLOSED");
                    Toast.makeText(Movies.this, "closed", Toast.LENGTH_SHORT).show();
                }
                if (newState == ElasticDrawer.STATE_OPEN) {

                    Toast.makeText(Movies.this, "open", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onDrawerSlide(float openRatio, int offsetPixels) {
                Log.i("MainActivity", "openRatio=" + openRatio + " ,offsetPixels=" + offsetPixels);
            }
       });
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isMenuVisible()) {
            mDrawer.closeMenu();
        } else {
            super.onBackPressed();
        }
    }

*/

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }


}
