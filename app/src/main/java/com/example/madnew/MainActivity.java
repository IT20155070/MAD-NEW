package com.example.madnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    Button login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();


        login.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Toast.makeText(MainActivity.this, "login has been Clicked", Toast.LENGTH_SHORT).show();


               Intent intent = new Intent(MainActivity.this , signin.class);
               startActivity(intent);

           }
        });


        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){


                Toast.makeText(MainActivity.this, "Resister has been clicked", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this , signup.class);
                startActivity(intent);

            }
        });


    }
}