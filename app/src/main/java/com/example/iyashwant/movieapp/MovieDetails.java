package com.example.iyashwant.movieapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import jp.wasabeef.picasso.transformations.BlurTransformation;

public class MovieDetails extends AppCompatActivity {

    TextView mName,mLang,mRuntime,mSynop,mCast,mDirector;
    Button next_btn;
    int posi;

    String [] links ={"https://www.desiretrees.in/wp-content/uploads/2017/04/Bahubali-2-Releaese-Date-New-Baahubali-2-Poster-Latest-2017-HD-Images.jpg","https://i0.wp.com/media2.slashfilm.com/slashfilm/wp/wp-content/images/baby-driver-poster.jpg",
            "https://s-media-cache-ak0.pinimg.com/originals/31/31/02/31310248b900b89687984d8d95bb3584.jpg","https://movies.universalpictures.com/media/dm3-adv1sheet-rgb-5-58c818a68f809-1.png","http://assets1.ignimgs.com/2017/03/24/spider-man-homecoming-1490381333042_610w.jpg",
            "https://cdn.traileraddict.com/content/warner-bros-pictures/wonder-woman-2017-5.jpg","https://s-media-cache-ak0.pinimg.com/originals/3c/2d/ce/3c2dce90356d91c7b81e28a2e7436de2.jpg",
            "http://data1.ibtimes.co.in/cache-img-857-0-photo/en/full/60292/1487911387_ninnu-kori-upcoming-telugu-movie-starring-nani-aadhi-nivetha-thomas-lead-role.jpg","http://thestoryscoop.com/wp-content/uploads/2017/05/C_YwhXxXgAAKsu7.jpg",
            "http://www.filmibeat.com/img/220x80x275/popcorn/movie_posters/thondimuthalum-driksakshiyum-20170629144731-15216.jpg","https://www.flickeringmyth.com/wp-content/uploads/2017/05/The-Big-Sick-poster.jpg"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        mRuntime =(TextView)findViewById(R.id.movie_length);
        mLang=(TextView)findViewById(R.id.movie_lang);
        mCast=(TextView)findViewById(R.id.movie_cast);
        mDirector=(TextView)findViewById(R.id.movie_director);
        mName=(TextView)findViewById(R.id.movie_name);
        mSynop=(TextView)findViewById(R.id.movi_synop);

        next_btn=(Button)findViewById(R.id.select_button);

        final RelativeLayout layout =(RelativeLayout)findViewById(R.id.details_background);
     //   layout.setBackgroundResource(R.drawable.ready);
      //  layout = new layout.setBackgroundResource();
       // Picasso.with(this).load("https://img.spicinemas.in/resources/images/home/image-3.jpg").into(layout);

        Picasso.with(this).load("https://www.desiretrees.in/wp-content/uploads/2017/04/Bahubali-2-Releaese-Date-New-Baahubali-2-Poster-Latest-2017-HD-Images.jpg").resize(350,600).transform(new BlurTransformation(this)).fetch();
        Picasso.with(this).load("https://i0.wp.com/media2.slashfilm.com/slashfilm/wp/wp-content/images/baby-driver-poster.jpg").resize(350,600).transform(new BlurTransformation(this)).fetch();
        Picasso.with(this).load("https://s-media-cache-ak0.pinimg.com/originals/31/31/02/31310248b900b89687984d8d95bb3584.jpg").resize(350,600).transform(new BlurTransformation(this)).fetch();
        Picasso.with(this).load("https://movies.universalpictures.com/media/dm3-adv1sheet-rgb-5-58c818a68f809-1.png").resize(350,600).transform(new BlurTransformation(this)).fetch();
        Picasso.with(this).load("http://assets1.ignimgs.com/2017/03/24/spider-man-homecoming-1490381333042_610w.jpg").resize(350,600).transform(new BlurTransformation(this)).fetch();
        Picasso.with(this).load("https://cdn.traileraddict.com/content/warner-bros-pictures/wonder-woman-2017-5.jpg").resize(350,600).transform(new BlurTransformation(this)).fetch();
        Picasso.with(this).load("https://s-media-cache-ak0.pinimg.com/originals/3c/2d/ce/3c2dce90356d91c7b81e28a2e7436de2.jpg").resize(350,600).transform(new BlurTransformation(this)).fetch();
        Picasso.with(this).load("http://data1.ibtimes.co.in/cache-img-857-0-photo/en/full/60292/1487911387_ninnu-kori-upcoming-telugu-movie-starring-nani-aadhi-nivetha-thomas-lead-role.jpg").resize(350,600).transform(new BlurTransformation(this)).fetch();
        Picasso.with(this).load("http://thestoryscoop.com/wp-content/uploads/2017/05/C_YwhXxXgAAKsu7.jpg").resize(350,600).transform(new BlurTransformation(this)).fetch();
        Picasso.with(this).load("https://cdn.pinkvilla.com/files/Salman-Khan-to-pay-back-distributors.jpg").resize(350,600).transform(new BlurTransformation(this)).fetch();
        Picasso.with(this).load("http://www.filmibeat.com/img/220x80x275/popcorn/movie_posters/thondimuthalum-driksakshiyum-20170629144731-15216.jpg").resize(350,600).transform(new BlurTransformation(this)).fetch();
        Picasso.with(this).load("https://www.flickeringmyth.com/wp-content/uploads/2017/05/The-Big-Sick-poster.jpg").resize(350,600).transform(new BlurTransformation(this)).fetch();

        final Bundle bundle = getIntent().getExtras();
        final String name = bundle.getString("name");
        posi =bundle.getInt("pos");

        //Toast.makeText(this, String.valueOf(posi), Toast.LENGTH_SHORT).show();

        switch (name)
        {
            case "BAAHUBALI 2":
                mName.setText("Baahubali 2");
                mDirector.setText("SS Rajamouli");

                mCast.setText("Anushka Shetty\nPrabhas\nRana Daggubati\nTamanna Bhatia");
                mLang.setText("Telugu");
                mRuntime.setText("168 Minutes");




                mSynop.setText("Shiva, the son of Bahubali, begins to search for answers after he learns about his heritage and the events that unfolded in the Mahishmati Kingdom.");
                Picasso.with(this).load("https://www.desiretrees.in/wp-content/uploads/2017/04/Bahubali-2-Releaese-Date-New-Baahubali-2-Poster-Latest-2017-HD-Images.jpg").resize(350,600).into(new Target() {
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

                break;
            case "BABY DRIVER":
                mName.setText("Baby Driver");
                mDirector.setText("Edgar Wright");
                mCast.setText("Ansel Elgort\nJamie Foxx\nJon Hamm\nKevin Spacey\nLily James");
                mLang.setText("English");
                mRuntime.setText("115 Minutes");
                Picasso.with(this).load("https://i0.wp.com/media2.slashfilm.com/slashfilm/wp/wp-content/images/baby-driver-poster.jpg").resize(350,600).into(new Target() {
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
                mSynop.setText("Talented getaway driver Baby (Ansel Elgort) relies on the beat of his personal soundtrack to be the best in the game. After meeting the woman (Lily James) of his dreams, he sees a chance to ditch his shady lifestyle and make a clean break. Coerced into working for a crime boss (Kevin Spacey), Baby must face the music as a doomed heist threatens his life, love and freedom.");

                break;
            case "CARS 3":
                mName.setText("Cars 3");
                mDirector.setText("Brian Fee");
                mCast.setText("");
                mLang.setText("English");
                mRuntime.setText("");
                Picasso.with(this).load("https://s-media-cache-ak0.pinimg.com/originals/31/31/02/31310248b900b89687984d8d95bb3584.jpg").resize(350,600).into(new Target() {
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
                mSynop.setText("Blindsided by a new generation of blazing-fast cars, the legendary Lighting McQueen finds himself pushed out of the sport that he loves. Hoping to get back in the game, he turns to Cruz Ramirez, an eager young technician who has her own plans for winning. With inspiration from the Fabulous Hudson Hornet and a few unexpected turns, No. 95 prepares to compete on Piston Cup Racing's biggest stage.");
                break;
            case "DESPICABLE ME 3":
                mName.setText("Despicable Me 3");
                mDirector.setText("");
                mCast.setText("");
                mLang.setText("English");
                mRuntime.setText("");
                Picasso.with(this).load("https://movies.universalpictures.com/media/dm3-adv1sheet-rgb-5-58c818a68f809-1.png").resize(350,600).into(new Target() {
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
                mSynop.setText("");
                break;

            case "SPIDER MAN":
                mName.setText("Spider Man Homecoming");
                mDirector.setText("Jon Watts");
                mCast.setText("");
                mLang.setText("English");
                mRuntime.setText("135 Minutes");
                Picasso.with(this).load("http://assets1.ignimgs.com/2017/03/24/spider-man-homecoming-1490381333042_610w.jpg").resize(350,600).into(new Target() {
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
                mSynop.setText("Thrilled by his experience with the Avengers, young Peter Parker returns home to live with his Aunt May. Under the watchful eye of mentor Tony Stark, Parker starts to embrace his newfound identity as Spider-Man. He also tries to return to his normal daily routine -- distracted by thoughts of proving himself to be more than just a friendly neighborhood superhero. Peter must soon put his powers to the test when the evil Vulture emerges to threaten everything that he holds dear.");
                  break;
            case "THE BOSS BABY":
                mName.setText("The Boss Baby");
                mDirector.setText("Tom McGrath");
                mCast.setText("");
                mLang.setText("English");
                Picasso.with(this).load("https://s-media-cache-ak0.pinimg.com/originals/3c/2d/ce/3c2dce90356d91c7b81e28a2e7436de2.jpg").resize(350,600).into(new Target() {
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
                mRuntime.setText("1h 37m");
                mSynop.setText("A new baby's arrival impacts a family, told from the point of view of a delightfully unreliable narrator -- a wildly imaginative 7-year-old named Tim. The most unusual Boss Baby (Alec Baldwin) arrives at Tim's home in a taxi, wearing a suit and carrying a briefcase. The instant sibling rivalry must soon be put aside when Tim discovers that Boss Baby is actually a spy on a secret mission, and only he can help thwart a dastardly plot that involves an epic battle between puppies and babies.");
                 break;
            case "GUEST IIN LONDON":
                mName.setText("Guest inn London");
                mDirector.setText("Ashwni Dhir");
                mCast.setText("");
                mLang.setText("Hindi");
                Picasso.with(this).load("http://thestoryscoop.com/wp-content/uploads/2017/05/C_YwhXxXgAAKsu7.jpg").resize(350,600).into(new Target() {
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
                mRuntime.setText("");
                mSynop.setText("Two Londoners struggle to live with their aunt and uncle, who overstay their welcome.");
                 break;
            case "WONDER WOMEN":
                mName.setText("Wonder Women");
                mDirector.setText("");
                Picasso.with(this).load("https://cdn.traileraddict.com/content/warner-bros-pictures/wonder-woman-2017-5.jpg").resize(350,600).into(new Target() {
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
                mCast.setText("");
                mLang.setText("English");
                mRuntime.setText("");
                mSynop.setText("Before she was Wonder Woman (Gal Gadot), she was Diana, princess of the Amazons, trained to be an unconquerable warrior. Raised on a sheltered island paradise, Diana meets an American pilot (Chris Pine) who tells her about the massive conflict that's raging in the outside world. Convinced that she can stop the threat, Diana leaves her home for the first time. Fighting alongside men in a war to end all wars, she finally discovers her full powers and true destiny.");
                 break;
            case "NINNU KORI":
                mName.setText("Ninnu Kori");
                mDirector.setText("");
                mCast.setText("");
                mLang.setText("Telugu");
                Picasso.with(this).load("http://data1.ibtimes.co.in/cache-img-857-0-photo/en/full/60292/1487911387_ninnu-kori-upcoming-telugu-movie-starring-nani-aadhi-nivetha-thomas-lead-role.jpg").resize(350,600).into(new Target() {
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
                mRuntime.setText("2h 17m");
                mSynop.setText("Ninnu Kori is a Telugu language romance film directed by debutant Shiva Nirvana and produced by DVV Danayya under DVV Entertainments. Nani and Nivetha Thomas play the lead roles in the movie while Aadhi Pinisetty plays a pivotal role");
                 break;
            case "THONDIMUTHALUM DHRIKSAKSHIYUM":
                mName.setText("Thonimuthalum Dhriksashiyum");
                mDirector.setText("");
                mCast.setText("");
                mLang.setText("");
                Picasso.with(this).load("http://www.filmibeat.com/img/220x80x275/popcorn/movie_posters/thondimuthalum-driksakshiyum-20170629144731-15216.jpg").resize(350,600).into(new Target() {
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
                mRuntime.setText("2h 15m");
                mSynop.setText("Prasad and Sreeja enter wedlock and move to a new place to continue the rest of their lives. Unfortunate events begin to take place after Prasad, a small-time thief, robs Sreeja's gold chain during a bus journey. The rest of the story deals with how the couple regains their precious ornament from him.");
                 break;
            case "TUBELIGHT":
                mName.setText("Tubelight");
                mDirector.setText("");
                mCast.setText("");
                mLang.setText("Hindi");
                Picasso.with(this).load("https://cdn.pinkvilla.com/files/Salman-Khan-to-pay-back-distributors.jpg").resize(350,600).into(new Target() {
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
                mRuntime.setText("2h 51m");
                mSynop.setText("Tubelight is an entertaining family drama set in a small town in the hills of northern India, and tells the story of one man's love for his family and his unshakeable belief in himself. After Bajrangi Bhaijaan, Kabir Khan and Salman Khan come together to tell another heartwarming story about the power of doing good.");
            break;

            case "THE BIG SICK":
                mName.setText("The Big Sick");
                mDirector.setText("");
                Picasso.with(this).load("https://www.flickeringmyth.com/wp-content/uploads/2017/05/The-Big-Sick-poster.jpg").resize(350,600).into(new Target() {
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
                mCast.setText("Holly Hunter, Kumail Nanjiani, Ray Romano, Zoe Kazan");
                mLang.setText("English");
                mRuntime.setText("122 Minutes");
                mSynop.setText("Pakistan-born comedian and cab driver Kumail Nanjiani is instantly attracted towards American student Emily Gordon whom he meets at a bar and develops a romantic relationship with. While his parents want him to be a responsible Muslim and marry a Pakistani, Kumail tries to deal with the conflicts in his own relationships, Emily's sudden illness and work to convince her parents to accept their relationship.");
                break;
        }



        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goToNextActivity = new Intent(getApplicationContext(), Select.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("name",name);
                bundle1.putInt("posi",posi);
                goToNextActivity.putExtras(bundle1);
                startActivity(goToNextActivity);
            }
        });
    }


}
