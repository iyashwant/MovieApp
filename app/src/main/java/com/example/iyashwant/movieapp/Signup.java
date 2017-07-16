package com.example.iyashwant.movieapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;

public class Signup extends AppCompatActivity {

    //DBAdapter myDb;
    DatabaseHelper myDb;

    EditText E_name,E_last,E_email,E_age,E_password,E_Cpassword,E_answer,E_phone;
    Spinner S_question,S_city;
    FloatingActionButton floatingActionButton3;
    int check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        myDb = new DatabaseHelper(this);

       // openDB();

        E_name=(EditText)findViewById(R.id.editName);
        E_last= (EditText)findViewById(R.id.editLastName);
        E_email= (EditText)findViewById(R.id.editEmail);
        E_age=(EditText)findViewById(R.id.editAge);
        E_password = (EditText)findViewById(R.id.editPassword);
        E_Cpassword = (EditText)findViewById(R.id.editPasswordConfirm);
        E_answer = (EditText)findViewById(R.id.editAnswer);
        E_phone=(EditText)findViewById(R.id.editPhone);


        S_question=(Spinner)findViewById(R.id.spinnerQuestion);
        floatingActionButton3 = (FloatingActionButton)findViewById(R.id.material_design_floating_action_menu_item3);


        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //if(!S_city.isSelected())

                run();


            }
        });


    }


    public void run() {

        S_question=(Spinner)findViewById(R.id.spinnerQuestion);
        String question="djjdjd";
        S_city= (Spinner)findViewById(R.id.spinnerCity);
        String city = String.valueOf(S_city.getSelectedItem());
        //String selected_city;
        switch (city)
        {
            case "Select": Toast.makeText(Signup.this, "no city selected", Toast.LENGTH_SHORT).show();
                            check=1;
                break;
            case "Chennai": check=0;
                break;
            case "Bangalore": check=0;
                break;
            case "Delhi": check=0;
                break;
            case "Trichy": check=0;
                break;
            case "Mumbai": check=0;
                break;

        }



        if (E_Cpassword.getText().toString().equals(E_password.getText().toString()))
        {
            E_Cpassword.setHintTextColor(Color.RED);
            E_Cpassword.setHint("Passwords does not match");
            check =1;
        }
        else check =0;
            // Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();

            if (E_password.getText().toString().length() > 8) {
                E_password.setHintTextColor(Color.RED);
                E_password.setHint("Should be more than 8 Characters");
                check =1;

            }
            else {
                check=0;
                //Toast.makeText(this, "Password should be more than 8 characters", Toast.LENGTH_SHORT).show();
            }
                if (E_name.getText().toString().isEmpty())
                {
                    E_name.setHintTextColor(Color.RED);
                    E_name.setHint("Name Required!");
                    check =1;
                    //Toast.makeText(this, "non empty", Toast.LENGTH_SHORT).show();
                }
                else check=0;

            if(E_phone.getText().toString().isEmpty())
            {
                E_phone.setHintTextColor(Color.RED);
                E_phone.setHint("Phone Required!");
                check=1;
            }
            else check=0;

            if(E_email.getText().toString().isEmpty())
            {
                E_email.setHintTextColor(Color.RED);
                E_email.setHint("Email Required!");
                check=1;
            }
            else check =0;

            if(E_age.getText().toString().isEmpty())
            {
                E_age.setHintTextColor(Color.RED);
                E_age.setHint("Age Required!");
                check=1;
            }
            else check =0;

            if(E_last.getText().toString().isEmpty())
            {
                E_last.setHintTextColor(Color.RED);
                E_last.setHint("Last Name Required!");
                check=1;
            }
            else check =0;

            if(E_answer.getText().toString().isEmpty())
            {
                E_answer.setHintTextColor(Color.RED);
                E_answer.setHint("Answer Required!");
                check=1;
            }
            else check =0;

        if(check==0)
        {
            //
            boolean isInserted =myDb.insertData(E_email.getText().toString(),E_name.getText().toString(),E_last.getText().toString(),E_age.getText().toString(),E_phone.getText().toString(),city,question,E_answer.getText().toString(),E_password.getText().toString());

            if(isInserted == true)
                Toast.makeText(Signup.this,"Data Inserted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(Signup.this,"Data not Inserted",Toast.LENGTH_LONG).show();

            Toast.makeText(this, "fine :)", Toast.LENGTH_SHORT).show();

        }
        else Toast.makeText(this, "not fine", Toast.LENGTH_SHORT).show();




    }

   /* private void openDB()
    {
        myDb= new DBAdapter(this);
        myDb.open();

    }
    */


}
