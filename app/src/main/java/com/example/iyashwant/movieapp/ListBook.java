package com.example.iyashwant.movieapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListBook extends AppCompatActivity {

    DBAdapter2 myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);

        openDB();
        populateLitView();
    }

    private void openDB()
    {
        myDb= new DBAdapter2(this);
        myDb.open();

    }



    private void populateLitView()
    {
        Cursor cursor = myDb.getAllRows();
        String[] fromFieldNames = new String[] {DBAdapter2.KEY_MOVIE,DBAdapter2.KEY_HEAD,DBAdapter2.KEY_TOTAL,DBAdapter2.KEY_BKID};
        int[] toViewIds = new int[] {R.id.textViewItemName,R.id.textViewItemBkidd,R.id.head,R.id.total};
        SimpleCursorAdapter myCursorAdapter;
        myCursorAdapter = new SimpleCursorAdapter(getBaseContext(),R.layout.item_m_layout,cursor, fromFieldNames, toViewIds,0);
        ListView mylist = (ListView) findViewById(R.id.ListViewTasks);
        mylist.setAdapter(myCursorAdapter);



    }
}
