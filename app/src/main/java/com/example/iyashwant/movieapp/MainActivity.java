package com.example.iyashwant.movieapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dd.CircularProgressButton;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import jp.wasabeef.picasso.transformations.BlurTransformation;

public class MainActivity extends AppCompatActivity {

    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2;
    EditText emailBox,passwordBox;

    DBAdapter2 myDb2;
    //DBAdapter myDb;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        openDB();
        RelativeLayout relativeLayout =(RelativeLayout)findViewById(R.id.main_background);
        relativeLayout.setBackgroundResource(R.mipmap.poster_blur);
        final CircularProgressButton circularButton1 = (CircularProgressButton) findViewById(R.id.circularButton1);
        circularButton1.setIndeterminateProgressMode(true);
        circularButton1.setProgress(0);
        final String email,password;



        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        emailBox= (EditText)findViewById(R.id.loginEmail);
        passwordBox = (EditText) findViewById(R.id.loginPassword);
        //Button login = (Button)findViewById(R.id.loginButton);



        password=passwordBox.getText().toString();


        circularButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    circularButton1.setProgress(50);

                Intent startActi= new Intent(getApplicationContext(),Movies.class);
                startActivity(startActi);

                Cursor res = myDb.getAllData(emailBox.getText().toString());
                if(res.getCount() == 0) {
                    // show message
                    //showMessage("Error","Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    //  buffer.append("Id :"+ res.getString(0)+"\n");
                    // buffer.append("Name :"+ res.getString(1)+"\n");
                    // buffer.append("Surname :"+ res.getString(2)+"\n");
                    buffer.append(res.getString(9));
                }


                //  emailBox.setText(buffer.toString());

                if(!emailBox.getText().toString().isEmpty())
                {
                if(passwordBox.getText().toString().equals(buffer.toString()))
                {
                    Toast.makeText(MainActivity.this, "password correct", Toast.LENGTH_SHORT).show();




                Thread myThread = new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(500);

                            Intent startActi= new Intent(getApplicationContext(),Movies.class);
                            startActivity(startActi);


                            //EditText stuff = (EditText)findViewById(R.id.editstuff_addit);
                           // EditText head = (EditText)findViewById(R.id.edithead_add);


                                    myDb2.insertRow(emailBox.getText().toString());





                            //callstop();
                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                };
                myThread.start();
                }
                else {
                    passwordBox.setHintTextColor(Color.RED);
                    passwordBox.setHint("Wrong");

                   Toast.makeText(MainActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    circularButton1.setProgress(0);
                }
                }

                else {
                    circularButton1.setProgress(0);
                    emailBox.setHintTextColor(Color.RED);
                    emailBox.setHint("Required");

                }
               // circularButton1.setProgress(100);

            }
        });



       /* login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startActi= new Intent(getApplicationContext(),Movies.class);
                startActivity(startActi);


                Cursor res = myDb.getAllData(emailBox.getText().toString());
                if(res.getCount() == 0) {
                    // show message
                    //showMessage("Error","Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                  //  buffer.append("Id :"+ res.getString(0)+"\n");
                   // buffer.append("Name :"+ res.getString(1)+"\n");
                   // buffer.append("Surname :"+ res.getString(2)+"\n");
                    buffer.append(res.getString(9));
                }


              //  emailBox.setText(buffer.toString());

                if(passwordBox.getText().toString().equals(buffer.toString()))
                {
                    Toast.makeText(MainActivity.this, "password correct", Toast.LENGTH_SHORT).show();

                }
                else Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();


                // Show all data
               // showMessage("Data",buffer.toString());

                                 }
                                 */




               // openDB();
             /*   Cursor res = myDb.getAllData(email);
                if (res.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "no data", Toast.LENGTH_SHORT).show();
                } else {
                    //  Toast.makeText(this, "data", Toast.LENGTH_SHORT).show();


                    StringBuffer buffer = new StringBuffer();
                    StringBuffer buffer1 = new StringBuffer();
                    //if(res.moveToFirst()) {
                        while (res.moveToNext()) {
                            buffer.append(res.getString(1));
                            // buffer.append("\n                    "+res.getString(1)+"\n          ---------------------------------------------          ");
                            // buffer.append("\n     "+res.getString(2)+"\n______________________________________");
                            buffer1.append(res.getString(9));
                        }
                   // }
                    emailBox.setText(buffer1.toString());

                    */

                    /*
                    if (buffer1.toString()==password)
                    {
                        Toast.makeText(MainActivity.this, "login done!", Toast.LENGTH_SHORT).show();
                    }
                    */




     //   });





        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GotoNext = new Intent(getApplicationContext(),Signup.class);
                startActivity(GotoNext);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        CircularProgressButton circularButton1 = (CircularProgressButton) findViewById(R.id.circularButton1);
        circularButton1.setIndeterminateProgressMode(true);
        circularButton1.setProgress(0);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }

    /* private void openDB()
    {
        myDb= new DBAdapter(this);
        myDb.open();
    }
    */


    private void openDB()
    {
        myDb2= new DBAdapter2(this);
        myDb2.open();

    }

 /* public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
        }
        */

    }