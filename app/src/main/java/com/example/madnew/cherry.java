package com.example.madnew;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
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

import com.example.madnew.Database.OrderContract;

public class cherry extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, cupcakeName, cupcakePrice;
    //EditText PersonName, homeaddress, phoneno, Date;
    CheckBox addchips, adddes;
    Button addtoOrder;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        getSupportActionBar().setTitle("CUP CAKE DETAILS");

        imageView = findViewById(R.id.imageViewInfo);
        plusquantity = findViewById(R.id.addquantity);
        minusquantity = findViewById(R.id.subquantity);
        quantitynumber = findViewById(R.id.quantity);
        cupcakeName = findViewById(R.id.cupcakeNameinInfo);
        cupcakePrice = findViewById(R.id.cupcakePrice);


        addtoOrder = findViewById(R.id.addtocart);
        addchips = findViewById(R.id.addchips);
        adddes = findViewById(R.id.adddes);
        cupcakeName.setText("CHERRY");
        imageView.setImageResource(R.drawable.cherry);

        addtoOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sumintent = new Intent(cherry.this,SummaryActivity.class);
                startActivity(sumintent);

                SaveCart();
            }
        });

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int basePrice = 270;


                quantity++;
                displayQuantity();
                int cupcakPrice = basePrice * quantity;
                String setnewPrice = String.valueOf(cupcakPrice);
                cupcakePrice.setText(setnewPrice);




                int ifcheckbox = CalculatePrice(addchips, adddes);
                cupcakePrice.setText("LKR " + ifcheckbox);




            }

        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 270;

                if(quantity == 0){
                    Toast.makeText(cherry.this, "cant decrease quantity < 4", Toast.LENGTH_SHORT).show();
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

    private boolean SaveCart() {

        String name = cupcakeName.getText().toString();
        String price = cupcakePrice.getText().toString();
        String quantity = quantitynumber.getText().toString();




        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, price);
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);



        if(addchips.isChecked()){
            values.put(OrderContract.OrderEntry.COLUMN_CHIPS, "Has Chips: YES");
        }
        else{
            values.put(OrderContract.OrderEntry.COLUMN_CHIPS, "Has Chips: NO");
        }

        if(adddes.isChecked()){
            values.put(OrderContract.OrderEntry.COLUMN_DES, "Has Deciccates: YES");
        }
        else{
            values.put(OrderContract.OrderEntry.COLUMN_DES, "Has Desiccates: NO");
        }

        if(mCurrentCartUri == null){
            Uri newuri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
            if(newuri == null){
                Toast.makeText(this, "Failed to add to cart", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Sucess adding to cart", Toast.LENGTH_SHORT).show();
            }


        }
        hasAllRequiredValues = true;
        return hasAllRequiredValues;

    }


    private int CalculatePrice(CheckBox addchips, CheckBox adddes) {

        int basePrice = 270;

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


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_CHIPS,
                OrderContract.OrderEntry.COLUMN_DES,

        };
        return new CursorLoader(this, mCurrentCartUri, projection, null, null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor curs) {

        if(curs == null || curs.getCount() < 1){
            return;
        }
        if(curs.moveToFirst()){

            int name = curs.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = curs.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = curs.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
            int hasChips = curs.getColumnIndex(OrderContract.OrderEntry.COLUMN_CHIPS);
            int hasDes = curs.getColumnIndex(OrderContract.OrderEntry.COLUMN_DES);



            String nameofcake = curs.getString(name);
            String priceofcake = curs.getString(price);
            String quatityofcake = curs.getString(quantity);
            String yeshasChips = curs.getString(hasChips);
            String yeshasDes = curs.getString(hasDes);


            cupcakeName.setText(nameofcake);
            cupcakePrice.setText(priceofcake);
            quantitynumber.setText(quatityofcake);






        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        cupcakeName.setText("");
        cupcakePrice.setText("");
        quantitynumber.setText("");


    }
}