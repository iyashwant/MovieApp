package com.example.iyashwant.movieapp;

/**
 * Created by iyashwant on 4/7/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Login.db";
    public static final String TABLE_NAME = "login_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "MARKS";
    public static final String KEY_ROWID="ID";
    public static final String KEY_EMAIL = "EMAIL";
    public static final String KEY_NAME = "NAME";
    public static final String KEY_LASTNAME="LASTNAME";
    public static final String KEY_AGE="AGE";
    public static final String KEY_CITY="CITY";
    public static final String KEY_PHONE="PHONE";
    public static final String KEY_QUESTION="QUES";
    public static final String KEY_ANSWER="ANS";
    public static final String KEY_PASSWORD="PASSWORD";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,LASTNAME TEXT,EMAIL TEXT,AGE TEXT,CITY TEXT,PHONE TEXT,QUES TEXT,ANS TEXT,PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String email,String name,String last,String age,String phone,String city,String question,String answer,String password) {
        SQLiteDatabase db = this.getWritableDatabase();

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
        long result = db.insert(TABLE_NAME,null ,initialValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME + " where email =?", new String[] {email});
        //Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}