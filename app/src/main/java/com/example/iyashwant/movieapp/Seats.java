package com.example.iyashwant.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Seats extends AppCompatActivity {

    int g1[],g2[],g3[];


    int seatcount;
    int count,count1,count2;
    int price;
    int seat_final;
    TextView price_text;
    TextView name,detail;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);
        g1=new int[48];
        g2=new int[48];
        g3=new int[14];
        final Bundle bundle = getIntent().getExtras();
        final String number1 = bundle.getString("numberofseats");
        final String screen =bundle.getString("header");
        final String tim =bundle.getString("sub");
        final String nam =bundle.getString("Mname");
        final int pos =bundle.getInt("s_pos");
        final String date1 = bundle.getString("date");

       //Bundle bundle = getIntent().getExtras();
       //String number1 = bundle.getString("numberofseats");
       int num= Integer.parseInt(number1);

        next=(Button)findViewById(R.id.button_seatNext);
        next.setText("Select "+number1+" seats");
        price=0;
        seatcount=num;
        name = (TextView)findViewById(R.id.textV_name);
        detail =(TextView)findViewById(R.id.textV_details);
        //Toast.makeText(this, String.valueOf(num), Toast.LENGTH_SHORT).show();
        seat_final=0;

        detail.setText(screen+" | "+ date1 + " | "+ tim);
        name.setText(nam);
        price_text = (TextView) findViewById(R.id.textV_price);
        SeatAdapter adapter = new SeatAdapter(Seats.this,48);
        GridView grid=(GridView)findViewById(R.id.grid_seats);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                   if (seat_final ==0 ){
                    if (g1[position] == 1) {
                        ImageView image = (ImageView) view.findViewById(R.id.image_seats);
                        image.setImageResource(R.drawable.final_seat);
                        if (count == 1) {
                            seatcount++;
                            price -= 120;
                            next.setText("Select "+seatcount+" seats");
                            seat_final=0;
                            price_text.setText(String.valueOf(price));

                        }
                        g1[position] = 0;
                    } else if (g1[position] == 0) {
                        if (seatcount != 0) {
                            ImageView image = (ImageView) view.findViewById(R.id.image_seats);
                            image.setImageResource(R.drawable.seat_selected);
                            g1[position] = 1;
                            count = 1;
                            seatcount--;
                            next.setText("Select "+seatcount+" seats");
                            price += 120;
                            seat_final = 0;
                            price_text.setText(String.valueOf(price));
                            if (seatcount == 0) {
                                seat_final = 1;
                                Toast.makeText(Seats.this, "Selected "+number1+" seats", Toast.LENGTH_SHORT).show();
                            }
                            if(seat_final==1)
                            {
                                next.setText("Continue");

                            }
                        }


                    }
                }

               else if (g1[position] == 1) {
                    ImageView image = (ImageView) view.findViewById(R.id.image_seats);
                    image.setImageResource(R.drawable.final_seat);
                    if (count == 1) {
                        seatcount++;
                        price -= 120;
                        seat_final=0;
                        next.setText("Select "+seatcount+" seats");
                        price_text.setText(String.valueOf(price));

                    }
                    g1[position] = 0;
                } else if (g1[position] == 0) {
                    if (seatcount != 0) {
                        ImageView image = (ImageView) view.findViewById(R.id.image_seats);
                        image.setImageResource(R.drawable.seat_selected);
                        g1[position] = 1;
                        count = 1;
                        seatcount--;
                        price += 120;
                        seat_final = 0;
                        next.setText("Select "+seatcount+" seats");
                        price_text.setText(String.valueOf(price));
                        if (seatcount == 0) {
                            seat_final = 1;
                            Toast.makeText(Seats.this, "Selected "+number1+" seats", Toast.LENGTH_SHORT).show();
                        }
                        if(seat_final==1)
                        {
                            next.setText("Continue");
                        }
                    }


                }

                //Picasso.with(getApplicationContext()).load("https://img.spicinemas.in/resources/images/home/image-2.jpg").into(image);
               // name=movieNames[position];
                /* Intent goToNextActivity = new Intent(getApplicationContext(), MovieDetails.class);
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                goToNextActivity.putExtras(bundle);
                startActivity(goToNextActivity);
                */


            }
        });


        SeatAdapter adapter1 = new SeatAdapter(Seats.this,14);
        GridView grid1=(GridView)findViewById(R.id.grid1);
        grid1.setAdapter(adapter1);
        grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (seat_final ==0 ){
                    if (g3[position] == 1) {
                        ImageView image = (ImageView) view.findViewById(R.id.image_seats);
                        image.setImageResource(R.drawable.final_seat);
                        if (count == 1) {
                            seatcount++;
                            price -= 120;
                            next.setText("Select "+seatcount+" seats");
                            seat_final=0;
                            price_text.setText(String.valueOf(price));

                        }
                        g3[position] = 0;
                    } else if (g3[position] == 0) {
                        if (seatcount != 0) {
                            ImageView image = (ImageView) view.findViewById(R.id.image_seats);
                            image.setImageResource(R.drawable.seat_selected);
                            g3[position] = 1;
                            count = 1;
                            seatcount--;
                            next.setText("Select "+seatcount+" seats");
                            price += 120;
                            seat_final = 0;
                            price_text.setText(String.valueOf(price));
                            if (seatcount == 0) {
                                seat_final = 1;
                                Toast.makeText(Seats.this, "Selected "+number1+" seats", Toast.LENGTH_SHORT).show();
                            }
                            if(seat_final==1)
                            {
                                next.setText("Continue");

                            }
                        }


                    }
                }

                else if (g3[position] == 1) {
                    ImageView image = (ImageView) view.findViewById(R.id.image_seats);
                    image.setImageResource(R.drawable.final_seat);
                    if (count == 1) {
                        seatcount++;
                        price -= 120;
                        seat_final=0;
                        next.setText("Select "+seatcount+" seats");
                        price_text.setText(String.valueOf(price));

                    }
                    g1[position] = 0;
                } else if (g3[position] == 0) {
                    if (seatcount != 0) {
                        ImageView image = (ImageView) view.findViewById(R.id.image_seats);
                        image.setImageResource(R.drawable.seat_selected);
                        g3[position] = 1;
                        count = 1;
                        seatcount--;
                        price += 120;
                        seat_final = 0;
                        next.setText("Select "+seatcount+" seats");
                        price_text.setText(String.valueOf(price));
                        if (seatcount == 0) {
                            seat_final = 1;
                            Toast.makeText(Seats.this, "Selected "+number1+" seats", Toast.LENGTH_SHORT).show();
                        }
                        if(seat_final==1)
                        {
                            next.setText("Continue");
                        }
                    }


                }

            }
        });


        SeatAdapter adapter2 = new SeatAdapter(Seats.this,48);
        GridView grid2=(GridView)findViewById(R.id.grid_seats2);
        grid2.setAdapter(adapter2);
        grid2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (seat_final ==0 ){
                    if (g2[position] == 1) {
                        ImageView image = (ImageView) view.findViewById(R.id.image_seats);
                        image.setImageResource(R.drawable.final_seat);
                        if (count == 1) {
                            seatcount++;
                            price -= 120;
                            next.setText("Select "+seatcount+" seats");
                            seat_final=0;
                            price_text.setText(String.valueOf(price));

                        }
                        g2[position] = 0;
                    } else if (g2[position] == 0) {
                        if (seatcount != 0) {
                            ImageView image = (ImageView) view.findViewById(R.id.image_seats);
                            image.setImageResource(R.drawable.seat_selected);
                            g2[position] = 1;
                            count = 1;
                            seatcount--;
                            next.setText("Select "+seatcount+" seats");
                            price += 120;
                            seat_final = 0;
                            price_text.setText(String.valueOf(price));
                            if (seatcount == 0) {
                                seat_final = 1;
                                Toast.makeText(Seats.this, "Selected "+number1+" seats", Toast.LENGTH_SHORT).show();
                            }
                            if(seat_final==1)
                            {
                                next.setText("Continue");

                            }
                        }


                    }
                }

                else if (g2[position] == 1) {
                    ImageView image = (ImageView) view.findViewById(R.id.image_seats);
                    image.setImageResource(R.drawable.final_seat);
                    if (count == 1) {
                        seatcount++;
                        price -= 120;
                        seat_final=0;
                        next.setText("Select "+seatcount+" seats");
                        price_text.setText(String.valueOf(price));

                    }
                    g2[position] = 0;
                } else if (g2[position] == 0) {
                    if (seatcount != 0) {
                        ImageView image = (ImageView) view.findViewById(R.id.image_seats);
                        image.setImageResource(R.drawable.seat_selected);
                        g2[position] = 1;
                        count = 1;
                        seatcount--;
                        price += 120;
                        seat_final = 0;
                        next.setText("Select "+seatcount+" seats");
                        price_text.setText(String.valueOf(price));
                        if (seatcount == 0) {
                            seat_final = 1;
                            Toast.makeText(Seats.this, "Selected "+number1+" seats", Toast.LENGTH_SHORT).show();
                        }
                        if(seat_final==1)
                        {
                            next.setText("Continue");
                        }
                    }


                }


            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(next.getText().toString().equals("Continue"))
                {

                    Toast.makeText(Seats.this, "done", Toast.LENGTH_SHORT).show();
                   // Intent goToNextActivity = new Intent(getApplicationContext(), Select.class);
                   // Bundle bundle1 = new Bundle();
                    //bundle1.putString("name",name);
                   // bundle1.putInt("posi",posi);
                   // goToNextActivity.putExtras(bundle1);
                   // startActivity(goToNextActivity);
                    Intent goToNextActivity = new Intent(getApplicationContext(), SelectFood.class);
                    //Intent goToNextActivity3 = new Intent(getApplicationContext(),Payment.class);
                    Bundle bundle1 = new Bundle();
                 //   bundle.putString("name",name);
                    bundle1.putString("f_name",nam);
                    bundle1.putString("f_time",tim);
                    bundle1.putString("f_screen",screen);
                    bundle1.putString("f_no",number1);
                    bundle1.putString("f_total",price_text.getText().toString());
                    bundle1.putInt("f_pos",pos);
                    bundle1.putString("f_date",date1);
                   goToNextActivity.putExtras(bundle1);
                    startActivity(goToNextActivity);
                }
                else
                    Toast.makeText(Seats.this, "Please select "+ seatcount +" seats", Toast.LENGTH_SHORT).show();

            }
        });
    }


}
