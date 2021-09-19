package com.example.madnew;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Model.user;

public class signin extends AppCompatActivity {

    EditText editPhone,editPassword;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        getSupportActionBar().setTitle("Sign In");

        editPhone = (EditText)findViewById(R.id.Phone2);
        editPassword = (EditText)findViewById(R.id.Password2);
        login = (Button)findViewById(R.id.register);

         final FirebaseDatabase database = FirebaseDatabase.getInstance();
         final DatabaseReference table_user = database.getReference("user");

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                final ProgressDialog mDialog = new ProgressDialog(signin.this);
                mDialog.setMessage("Please waiting....");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot snapshot) {


                        if(snapshot.child(editPhone.getText().toString()).exists()){
                            mDialog.dismiss();

                            user User = snapshot.child(editPhone.getText().toString()).getValue(user.class);
                            if(User.getPassword().equals(editPassword.getText().toString())){
                                Toast.makeText(signin.this, "Sign in Successfully!!", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(signin.this, "Sign in Failed!!", Toast.LENGTH_SHORT).show();
                            }
                         }
                        else{
                            mDialog.dismiss();
                            Toast.makeText(signin.this, "User not exist", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled( DatabaseError error) {
                        mDialog.dismiss();
                        Toast.makeText(signin.this, "Error...", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });


    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}