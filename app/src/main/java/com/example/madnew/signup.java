package com.example.madnew;

import androidx.annotation.NonNull;
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

public class signup extends AppCompatActivity {

    EditText editPhone,editaddress,editEmail,editname,editPassword;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().setTitle("Sign Up");

        editaddress = (EditText)findViewById(R.id.Address);
        editEmail = (EditText)findViewById(R.id.Email2);
        editname = (EditText)findViewById(R.id.name);
        editPassword = (EditText)findViewById(R.id.Password2);
        editPhone = (EditText)findViewById(R.id.Phone);
        signup = (Button)findViewById(R.id.register2);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("user");

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(signup.this);
                mDialog.setMessage("Please waiting....");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {

                        if(snapshot.child(editPhone.getText().toString()).exists()){
                            mDialog.dismiss();
                            Toast.makeText(signup.this, "Phone Number already Register", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            mDialog.dismiss();
                            user User = new user(editaddress.getText().toString(),editEmail.getText().toString(),editname.getText().toString(),editPassword.getText().toString());
                            table_user.child(editPhone.getText().toString()).setValue(User);
                            Toast.makeText(signup.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                            finish();

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {

                    }
                });
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}