package com.example.iyashwant.movieapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by iyashwant on 11/6/17.
 */

public class DBAdapter {

    private static final String TAG = "DBAdapter";

    public static final String KEY_ROWID="_id";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_NAME = "name";
    public static final String KEY_LASTNAME="lastname";
    public static final String KEY_AGE="age";
    public static final String KEY_CITY="city";
    public static final String KEY_PHONE="phone";
    public static final String KEY_QUESTION="question";
    public static final String KEY_ANSWER="answer";
    public static final String KEY_PASSWORD="password";

   // public static final String KEY_DATE = "date";

    public static final String[] ALL_KEYS = new String[] {KEY_ROWID,KEY_EMAIL,KEY_NAME,KEY_LASTNAME,KEY_AGE,KEY_PHONE,KEY_CITY,KEY_QUESTION,KEY_ANSWER,KEY_PASSWORD};



    public static final int COL_ROWID =0;
    public static final int COL_HEAD =1;
    public static final int COL_TASK  =2;
   // public static final int COL_DATE=2;



    public static final String DATABASE_NAME="data";
    public static final String DATABASE_TABLE="datadb";
    public static final int DATABASE_VERSION=3;

    private static final String DATABASE_CREATE_SQL =
            "CREATE TABLE " +DATABASE_TABLE+" (" + KEY_ROWID + " INTEGER PRIMARY KEY, " + KEY_EMAIL + " TEXT, " + KEY_NAME + " TEXT, " + KEY_LASTNAME + " TEXT, " + KEY_AGE + " TEXT, " + KEY_PHONE + " TEXT, " + KEY_CITY + " TEXT, " + KEY_QUESTION + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_PASSWORD + " TEXT" + ")";


    private final Context context;
    private DatabaseHelper myDBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        myDBHelper = new DatabaseHelper(context);
    }

    public  DBAdapter open()
    {
        db=myDBHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        myDBHelper.close();
    }

    public long insertRow(String email,String name,String last,String age,String phone,String city,String question,String answer,String password)
    {

        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_EMAIL,email);
        initialValues.put(KEY_NAME,name);
        initialValues.put(KEY_LASTNAME,last);
        initialValues.put(KEY_AGE,age);
        initialValues.put(KEY_PHONE,phone);
        initialValues.put(KEY_CITY,city);
        initialValues.put(KEY_QUESTION,question);
        initialValues.put(KEY_ANSWER,answer);
        initialValues.put(KEY_PASSWORD,password);
       //initialValues.put(KEY_DATE,date);

        return db.insert(DATABASE_TABLE,null,initialValues);
    }




    public boolean deleteRow(long rowId)
    {
        String where = KEY_ROWID + "=" + rowId;
        return db.delete(DATABASE_TABLE,where,null) !=0;
    }

    public void  deleteAll()
    {
        Cursor c = getAllRows();
        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);
        if (c.moveToFirst())
        {
            do{
                deleteRow(c.getLong((int) rowId));
            }
            while (c.moveToNext());
        }
        c.close();
    }

    public Cursor getAllRows()
    {
        String where = null;
        Cursor c = db.query(true, DATABASE_TABLE, ALL_KEYS, where, null, null, null, null, null);
        if (c !=null)
        {
            c.moveToFirst();
        }
        return c;
    }


    public Cursor getRow(long rowId)
    {
        String where = KEY_ROWID + "=" + rowId;
        Cursor c = db.query(true, DATABASE_TABLE, ALL_KEYS, where, null, null, null, null, null);
        if (c !=null)
        {
            c.moveToFirst();
        }
        return c;

    }

    public Cursor gethead(long rowId)
    {
        String where = KEY_ROWID + "=" + rowId;
       // Cursor res = db.rawQuery("select * from "+ DATABASE_TABLE,null);
        Cursor res =  db.query(true, DATABASE_TABLE, ALL_KEYS, where, null, null, null, null, null);

        return res;

    }

    public Cursor getLogin(String  email)
    {


        String where = KEY_ROWID + "=" + email;
         //Cursor res = db.rawQuery("select answer from "+ DATABASE_TABLE,null);
        //Cursor res =  db.query(true, DATABASE_TABLE, ALL_KEYS, where, null, null, null, null, null);
        //Cursor res = db.rawQuery("SELECT * FROM datadb WHERE TRIM(email) = '"+email.trim()+"'", null);
        Cursor res = db.rawQuery("select * from " + DATABASE_TABLE + " where email =?", new String[] {email});

        //Cursor res = db.rawQuery("select * from " +DATABASE_TABLE + " where " + KEY_EMAIL + "=" +email,null);
        return res;

    }

    public boolean updateRow(long rowId, String head, String task)
    {
        String where = KEY_ROWID + "=" + rowId;
        ContentValues newValues = new ContentValues();
       // newValues.put(KEY_HEAD,head);
        //newValues.put(KEY_TASK, task);

       // newValues.put(KEY_DATE, date);

        return db.update(DATABASE_TABLE, newValues, where, null) !=0;
    }





    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase _db) {
            _db.execSQL(DATABASE_CREATE_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {

            Log.d(TAG, "Upgrading application's database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data!");

            _db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);

            onCreate(_db);

        }
    }



}
