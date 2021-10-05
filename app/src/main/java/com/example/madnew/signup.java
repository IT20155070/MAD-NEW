package com.example.madnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText email,name,address,phone,password,repassword;
    Button signup;
    TextView mTextViewlogin;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        address = (EditText)findViewById(R.id.Address);
        email = (EditText)findViewById(R.id.Email2);
        name = (EditText)findViewById(R.id.name);
        password = (EditText)findViewById(R.id.Password2);
        repassword = (EditText)findViewById(R.id.Password3);
        phone = (EditText)findViewById(R.id.Phone);
        signup = (Button)findViewById(R.id.register2);
        mTextViewlogin = (TextView)findViewById(R.id.textViewregis);
        myDB = new DBHelper(this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String Name = name.getText().toString();
                String Address = address.getText().toString();
                String Phone = phone.getText().toString();
                String Password = password.getText().toString();
                String Repassword = repassword.getText().toString();

                if(Email.equals("")|| Name.equals("")|| Address.equals("")||Phone.equals("")|| Password.equals("") || Repassword.equals("")){
                    Toast.makeText(signup.this, "Fill all the Fields...", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(Password.equals(Repassword)){
                        Boolean usercheckresult = myDB.checkemail(Email);
                        if(usercheckresult == false){
                            Boolean rehResult = myDB.insertData(Email,Name,Address,Phone,Password);
                            if (rehResult == true) {

                                Toast.makeText(signup.this, "Register Successful!!!", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(signup.this , signin.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(signup.this, "Registration Faild!!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(signup.this, "User Already exists.Please Sign In", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(signup.this, "Password not matching.Please reenter password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        mTextViewlogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(signup.this, "login has been clicked", Toast.LENGTH_SHORT).show();

                Intent logintent = new Intent(signup.this,signin.class);
                startActivity(logintent);
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}