package com.example.iyashwant.movieapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    EditText ccEditText;
    //int count;
    TextView price_text;
    TextView name,detail;
    Button next;
    int check;

    EditText final_card, final_nameoncard, final_mm, final_yyyy, final_cvv;
    ImageView visa, mastercard;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        //Bundle bundle = getIntent().getExtras();
        //String number1 = bundle.getString("numberofseats");
      //  String screen =bundle.getString("header");
       // String tim =bundle.getString("sub");
        //String nam =bundle.getString("Mname");
        //String total = bundle.getString("total");

       // int num= Integer.parseInt(number1);



        final Bundle bundle = getIntent().getExtras();
        final String number2 = bundle.getString("p_no");
        final String screen2 =bundle.getString("p_screen");
        final String tim2 =bundle.getString("p_time");
        final String nam2 =bundle.getString("p_name");
        final String total2 =bundle.getString("p_total");
        final int pos = bundle.getInt("p_pos");
        final String date1 = bundle.getString("p_date");

        //Toast.makeText(this, total2, Toast.LENGTH_SHORT).show();

        next=(Button)findViewById(R.id.button_seatNext);
        //next.setText("Select "+number1+" seats");
       // price=0;
       // seatcount=num;
        name = (TextView)findViewById(R.id.textP_name);
        detail =(TextView)findViewById(R.id.textP_details);
        //Toast.makeText(this, String.valueOf(num), Toast.LENGTH_SHORT).show();
       // seat_final=0;

       detail.setText(screen2+" | "+ date1 + " | "+ tim2);
        name.setText(nam2);
        price_text = (TextView) findViewById(R.id.textP_price);
        price_text.setText(total2);

       // count = 0;

        final Intent goToNextActivity = new Intent(getApplicationContext(), BookingConfirm.class);
        //Intent goToNextActivity3 = new Intent(getApplicationContext(),Payment.class);
        final Bundle bundle1 = new Bundle();
        //   bundle.putString("name",name);
        bundle1.putString("c_name",nam2);
        bundle1.putString("c_time",tim2);
        bundle1.putString("c_screen",screen2);
        bundle1.putString("c_no",number2);
        bundle1.putString("c_total",total2);
        bundle1.putInt("c_pos",pos);
        bundle1.putString("c_date",date1);




        final_card = (EditText) findViewById(R.id.final_card);
        final_nameoncard = (EditText) findViewById(R.id.final_name);
        final_mm = (EditText) findViewById(R.id.final_mm);
        final_yyyy = (EditText) findViewById(R.id.final_yyyy);
        final_cvv = (EditText) findViewById(R.id.final_cvv);

        visa = (ImageView) findViewById(R.id.visa);
        mastercard = (ImageView) findViewById(R.id.master);
        error = (TextView) findViewById(R.id.error);

     //   ccEditText = (EditText) findViewById(R.id.editCard);
     //   ccEditText.addTextChangedListener(new TextWatcher() {

        final_card.addTextChangedListener(new TextWatcher() {
            int count = 0;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!final_card.getText().toString().equals("")){

                    mastercard.setBackground(ContextCompat.getDrawable(Payment.this, R.color.transparent));
                    visa.setBackground(ContextCompat.getDrawable(Payment.this, R.color.transparent));
                    error.setText("");

                    switch(final_card.getText().toString().substring(0, 1)){
                        case "4": visa.setBackground(ContextCompat.getDrawable(Payment.this, R.drawable.border));
                            mastercard.setBackground(ContextCompat.getDrawable(Payment.this, R.color.transparent));
                            error.setText("");
                            break;
                        case "5": mastercard.setBackground(ContextCompat.getDrawable(Payment.this, R.drawable.border));
                            visa.setBackground(ContextCompat.getDrawable(Payment.this, R.color.transparent));
                            error.setText("");
                            break;
                        default: mastercard.setBackground(ContextCompat.getDrawable(Payment.this, R.color.transparent));
                            visa.setBackground(ContextCompat.getDrawable(Payment.this, R.color.transparent));
                            error.setText("Visa or MasterCard Only"); break;
                    }
                }

                if(final_card.getText().toString().length() != 19  || final_card.getText().toString() == ""){
                    final_card.setBackground(ContextCompat.getDrawable(Payment.this, R.drawable.box_red));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                if (count <= final_card.getText().toString().length()
                        &&(final_card.getText().toString().length()==4
                        ||final_card.getText().toString().length()==9
                        ||final_card.getText().toString().length()==14)){
                    final_card.setText(final_card.getText().toString()+" ");
                    int pos = final_card.getText().length();
                    final_card.setSelection(pos);
                }else if (count >= final_card.getText().toString().length()
                        &&(final_card.getText().toString().length()==4
                        ||final_card.getText().toString().length()==9
                        ||final_card.getText().toString().length()==14)){
                    final_card.setText(final_card.getText().toString().substring(0,final_card.getText().toString().length()-1));
                    int pos = final_card.getText().length();
                    final_card.setSelection(pos);
                }
                count = final_card.getText().toString().length();

                if(final_card.getText().toString().length() != 19 || final_card.getText().toString() == "") {
                    final_card.setBackground(ContextCompat.getDrawable(Payment.this, R.drawable.box_red));
                }
                else {
                    final_card.setBackground(ContextCompat.getDrawable(Payment.this, R.drawable.box_red));
                }

            }
        });




        Button pay =(Button)findViewById(R.id.button_pay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (final_cvv.getText().toString().isEmpty())
                {
                    final_cvv.setHintTextColor(Color.RED);
                    final_cvv.setHint("cvv!");
                    check =1;
                    //Toast.makeText(this, "non empty", Toast.LENGTH_SHORT).show();
                }
                else check =0;


                if (final_nameoncard.getText().toString().isEmpty())
                {
                    final_nameoncard.setHintTextColor(Color.RED);
                    final_nameoncard.setHint("Name Required!");
                    check =1;
                    //Toast.makeText(this, "non empty", Toast.LENGTH_SHORT).show();
                }
                else check =0;

                if (final_mm.getText().toString().isEmpty())
                {
                    final_mm.setHintTextColor(Color.RED);
                    final_mm.setHint("!");
                    check =1;
                    //Toast.makeText(this, "non empty", Toast.LENGTH_SHORT).show();
                }
                else check =0;

                if (final_yyyy.getText().toString().isEmpty())
                {
                    final_yyyy.setHintTextColor(Color.RED);
                    final_yyyy.setHint("year!");
                    check =1;
                    //Toast.makeText(this, "non empty", Toast.LENGTH_SHORT).show();
                }
                else check =0;


                if (check==0)

                {
                    goToNextActivity.putExtras(bundle1);
                    startActivity(goToNextActivity);
                }
            }
        });
    }
}
