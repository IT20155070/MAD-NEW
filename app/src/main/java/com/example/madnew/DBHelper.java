package com.example.madnew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context ) {

        super(context,"Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users(email Text primary key,name Text,address Text,phone Text,password Text )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {

        myDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String email,String name,String address,String phone,String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("name",name);
        contentValues.put("address",address);
        contentValues.put("phone",phone);
        contentValues.put("password",password);

        long result = myDB.insert("users",null,contentValues);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean checkemail(String email){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where email = ?",new String[] {email});

        if(cursor.getCount()>0){
             return true;
        }
        else{
             return false;
        }
    }


    public Boolean checkemailpassword(String email,String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where email = ? and password = ?",new String[] {email,password});

        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
}
