package com.example.madnew;

import static com.example.madnew.MainActivity.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RCheckout extends AppCompatActivity {

    ArrayList<String> lit_items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rental_checkout);

        lit_items=new ArrayList<>();
        for (int i = 0; i < cart.size(); i++) {
            lit_items.add(cart.get(i).name + " : " + cart.get(i).number_of_items);
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, lit_items);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);
    }

    public void Submit(View view){
        DBHelper myDB = new DBHelper(this);

        EditText email = (EditText) findViewById(R.id.editTextTextPersonName4);
        EditText no_of_guest = (EditText) findViewById(R.id.editTextTextPersonName3);
        EditText event = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText days = (EditText) findViewById(R.id.editTextTextPersonName);


        StringBuilder builder = new StringBuilder();
        builder.append(lit_items.get(0));
        for (int i = 1; i < lit_items.size(); i++) {
            builder.append("-").append(lit_items.get(i));
        }

        if(myDB.checkout(email.getText().toString(), no_of_guest.getText().toString(), event.getText().toString(), days.getText().toString(),builder.toString())){
            Toast.makeText(this, "added successfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }
}
