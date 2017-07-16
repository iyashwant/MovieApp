package com.example.iyashwant.movieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by iyashwant on 7/7/17.
 */

public class SeatAdapter extends BaseAdapter {


    private Context mContext;
    private final int Imageid;
    //private final String[] movieName;
    public SeatAdapter(Context c,int Imageid )
    {
        mContext = c;
        this.Imageid = Imageid;
        //this.movieName=movieName;
    }

    @Override
    public int getCount()
    {
        return Imageid;
    }
    @Override
    public Object getItem(int position)
    {
        return position;
    }
    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup
            parent)
    {

        View myV;
        if (convertView == null) { // if it's not recycled, initialize some attributes
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE );
            myV = inflater.inflate(R.layout.grid_seat_layout, parent, false);
            LayoutInflater inflater1 = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE );
            myV = inflater1.inflate(R.layout.grid_seat_layout, parent, false);
        } else {
            myV = (View) convertView;
        }
        //TextView text = (TextView)myV.findViewById(R.id.grid_item_label);
       // text.setText(movieName[position]);

        ImageView image = (ImageView)myV.findViewById(R.id.image_seats);
        image.setImageResource(R.drawable.final_seat);

        //Picasso.with(this.mContext).load(Imageid[position]).into(image);
        // image.setImageResource(gridViewImageId[i]); Resource
        return myV;

            /*
            LayoutInflater inflater = (LayoutInflater)
                    mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View gridView;
            if (convertView == null)
            {
                gridView = new View(mContext);
                // get layout from mobile.xml
                gridView = inflater.inflate(R.layout.grid_layout, null);
                // set value into textview
                TextView textView = (TextView)
                        gridView.findViewById(R.id.grid_item_label);
                textView.setText(movieName[position]);
                // set image based on selected text
                ImageView imageView = (ImageView)
                        gridView.findViewById(R.id.grid_item_image);
                Picasso.with(this.mContext).load(Imageid[position]).into(imageView);
               // imageView.setImageResource(Imageid[position]);
            }
            else
            {
                gridView = (View) convertView;
            }
            return gridView;
            */
    }

}
