package com.example.madnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageView rental = (ImageView) findViewById(R.id.rental);
        rental.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentrent = new Intent(Home.this,Rental.class);
                startActivity(intentrent);
            }
        });
    }
}





