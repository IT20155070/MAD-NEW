package com.example.madnew;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="CONTACT_US.db";
    public static final String TABLE_NAME="CONTACT_US";

    //COLS

    public static final String COLS_1="FULL NAME";
    public static final String COLS_2="EMAIL";
    public static final String COLS_3="CONTACT NO";
    public static final String COLS_4="YOUR MESSAGE";
    public static final String COLS_5="MESSAGE";
    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME,  null,  1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        db.execSQL("CRETE TABLE" +TABLE_NAME+ "(full name TEXT, email TEXT, contact TEXT, your message TEXT, message TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
       onCreate(db);

    }
}
