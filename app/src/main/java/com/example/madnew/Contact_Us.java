package com.example.madnew;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Contact_Us extends AppCompatActivity {
      Button _btnInsert;
      EditText _txtFullName , _txtEmail, _txtContactNo, _txtYourMessage, _txtMessage;
      SQLiteOpenHelper openHelper;
      SQLiteDatabase db
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        _btnInsert=(Button)findViewById(R.id.btnInsert);

    }
}