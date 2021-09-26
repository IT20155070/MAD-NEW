package com.example.madnew;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class orderDB extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAMENEW = "confirm.db";

    public static final String TABLE_1 = "Orderconf";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "Name";
    public static final String COL_ADDRESS = "Address";
    public static final String COL_PHONE = "Phone";
    public static final String COL_Date = "Date";

    public orderDB(Context context) {
        super(context, DATABASE_NAMENEW, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase dbn) {

        dbn.execSQL("CREATE TABLE "+ TABLE_1 + "(id INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Address TEXT, Phone TEXT, Date Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists " + TABLE_1);

    }


    public boolean insertDate(String name, String address, String phone, String date){


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentval = new ContentValues();
        contentval.put(COL_NAME, name);
        contentval.put(COL_ADDRESS, address);
        contentval.put(COL_PHONE, phone);
        contentval.put(COL_Date,date);
        long res = db.insert(TABLE_1, null, contentval);
        if(res==-1){
            return false;
        }
        else{
            return true;
        }

    }

}
