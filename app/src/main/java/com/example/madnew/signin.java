package com.example.madnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signin extends AppCompatActivity {

    EditText email,password;
    Button login;
    TextView textViewreg;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        getSupportActionBar().setTitle("Sign In");

        email = (EditText)findViewById(R.id.Email3);
        password = (EditText)findViewById(R.id.Password2);
        login = (Button)findViewById(R.id.Loginbtn);
        textViewreg = (TextView)findViewById(R.id.textViewregis);
        myDB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String Email = email.getText().toString();
              String Password = password.getText().toString();

              if(Email.equals("")|| Password.equals("")){
                  Toast.makeText(signin.this, "Please enter the Credentials", Toast.LENGTH_SHORT).show();
              }
              else{
                  Boolean result = myDB.checkemailpassword(Email,Password);
                  if(result==true){
                      Toast.makeText(signin.this, "Login Successful!!!", Toast.LENGTH_SHORT).show();
                      Intent intent1 = new Intent(signin.this , Home.class);
                      startActivity(intent1);

                  }
                  else{
                      Toast.makeText(signin.this, "Invalid Credentials!!!", Toast.LENGTH_SHORT).show();
                  }
              }
            }
        });





        textViewreg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(signin.this, "Register has been clicked", Toast.LENGTH_SHORT).show();

                Intent logintent = new Intent(signin.this,signup.class);
                startActivity(logintent);
            }
        });


    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}