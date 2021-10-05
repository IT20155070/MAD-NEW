package com.example.madnew;

import static com.example.madnew.MainActivity.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Rental extends AppCompatActivity {

    EditText numberofthings;
    String productname=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equipment_rental);
    }

    public void coffee_machine(View v){
        setContentView(R.layout.nescafe);
        numberofthings = findViewById(R.id.numberofcoffe);
        productname="NESCAFE MACHINE";

    }
    public void tent(View v){
        setContentView(R.layout.tents);
        numberofthings = findViewById(R.id.numberoftent);
        productname="TENTS";

    }
    public void buffet(View v){
        setContentView(R.layout.buffet_tables);
        numberofthings = findViewById(R.id.numberofbuffet);
        productname="BUFFET TABLES";

    }
    public void chair(View v){
        setContentView(R.layout.chairs);
        numberofthings = findViewById(R.id.numberofchairs);
        productname="CHAIRS";

    }

    public void addtocart(View view){
        Products products=new Products();
        products.name=productname;
        products.number_of_items=numberofthings.getText().toString();
        cart.add(products);
        Toast.makeText(this, "added " +products.number_of_items+" x " + productname, Toast.LENGTH_SHORT).show();

        setContentView(R.layout.equipment_rental);
    }
    public void checkout(View view){
        startActivity(new Intent(this,RCheckout.class));
    }

}
