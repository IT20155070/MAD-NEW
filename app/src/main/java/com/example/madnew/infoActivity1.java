package com.example.madnew;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class infoActivity1 extends AppCompatActivity {

    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, cupcakeName, cupcakePrice;
    CheckBox addchips, adddes;
    Button addtoOrder;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        imageView = findViewById(R.id.imageViewInfo);
        plusquantity = findViewById(R.id.addquantity);
        minusquantity = findViewById(R.id.subquantity);
        quantitynumber = findViewById(R.id.quantity);
        cupcakeName = findViewById(R.id.cupcakeNameinInfo);
        cupcakePrice = findViewById(R.id.cupcakePrice);
        addchips = findViewById(R.id.addchips);
        adddes = findViewById(R.id.adddes);

        cupcakeName.setText("RED VELVET");

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int basePrice = 200;
                if(quantity==4){

                    quantity++;
                    displayQuantity();
                    int cupcakPrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(cupcakPrice);
                    cupcakePrice.setText(setnewPrice);




                    int ifcheckbox = CalculatePrice(addchips, adddes);
                    cupcakePrice.setText("LKR " + ifcheckbox);

                }

                else{
                    Toast.makeText(infoActivity1.this, "can increase quantiru > 4", Toast.LENGTH_SHORT).show();
                }
            }

        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 200;

                if(quantity == 4){
                    Toast.makeText(infoActivity1.this, "cant decrease quantity < 4", Toast.LENGTH_SHORT).show();
                }
                else{
                    quantity--;
                    displayQuantity();
                    int cupcakPrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(cupcakPrice);
                    cupcakePrice.setText(setnewPrice);

                    int ifcheckbox = CalculatePrice(addchips, adddes);
                    cupcakePrice.setText("LKR " + ifcheckbox);

                }
            }
        });

    }

    private int CalculatePrice(CheckBox addchips, CheckBox adddes) {

        int basePrice = 200;

        if(addchips.isChecked()){

            basePrice = basePrice + 20;
        }

        if(adddes.isChecked()){

            basePrice = basePrice + 10;
        }

        return basePrice * quantity;
    }

    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }
}