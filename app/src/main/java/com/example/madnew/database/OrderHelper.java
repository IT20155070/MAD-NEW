package com.example.madnew.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class OrderHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABSE_NAME = "Login.db";

    public OrderHelper(Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_TABLE = "CREATE TABLE " + OrderContract.OrderEntry.TABLE_NAME + "("
                + OrderContract.OrderEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +  OrderContract.OrderEntry.COLUMN_CAKENAME + " TEXT NOT NULL, "
                +  OrderContract.OrderEntry.COLUMN_QUANTITY + " TEXT NOT NULL, "
                +  OrderContract.OrderEntry.COLUMN_PRICE + " TEXT NOT NULL, "
                +  OrderContract.OrderEntry.COLUMN_CHIPS + " TEXT NOT NULL, "
                +  OrderContract.OrderEntry.COLUMN_DES + " TEXT NOT NULL, "
                +  OrderContract.OrderEntry.COLUMN_NAME + " TEXT NOT NULL, "
                +  OrderContract.OrderEntry.COLUMN_ADDRESS + " TEXT NOT NULL, "
                +  OrderContract.OrderEntry.COLUMN_PHONE + " TEXT NOT NULL, "
                +  OrderContract.OrderEntry.COLUMN_DATE + " TEXT NOT NULL);";


                db.execSQL(SQL_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
