package com.example.madnew;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madnew.database.OrderContract;

public class infoActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, cupcakeName, cupcakePrice;
    EditText PersonName, homeaddress, phoneno, Date;
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
        PersonName = (EditText)findViewById(R.id.PersonName);
        homeaddress = (EditText)findViewById(R.id.homeaddress);
        phoneno = (EditText)findViewById(R.id.phoneno);
        Date = (EditText)findViewById(R.id.Date);
        addtoOrder = findViewById(R.id.addtocart);
        addchips = findViewById(R.id.addchips);
        adddes = findViewById(R.id.adddes);
        cupcakeName.setText("RED VELVET");

        addtoOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sumintent = new Intent(infoActivity.this,SummaryActivity.class);
                startActivity(sumintent);

                SaveCart();
            }
        });

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int basePrice = 200;


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

                int basePrice = 200;

                if(quantity == 0){
                    Toast.makeText(infoActivity.this, "cant decrease quantity < 4", Toast.LENGTH_SHORT).show();
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

        //getting values from views
        String cake_name = cupcakeName.getText().toString();
        String price = cupcakePrice.getText().toString();
        String quantity = quantitynumber.getText().toString();
        String name = PersonName.getText().toString();
        String address = homeaddress.getText().toString();
        String phone = phoneno.getText().toString();
        String date = Date.getText().toString();

        ContentValues values1 = new ContentValues();
        values1.put(OrderContract.OrderEntry.COLUMN_CAKENAME, cake_name);
        values1.put(OrderContract.OrderEntry.COLUMN_PRICE, price);
        values1.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);
        values1.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values1.put(OrderContract.OrderEntry.COLUMN_ADDRESS, address);
        values1.put(OrderContract.OrderEntry.COLUMN_PHONE, phone);
        values1.put(OrderContract.OrderEntry.COLUMN_DATE, date);

        if(addchips.isChecked()){
            values1.put(OrderContract.OrderEntry.COLUMN_CHIPS, "Has Chips: YES");

        }
        else{
            values1.put(OrderContract.OrderEntry.COLUMN_CHIPS, "Has Chips: NO");
        }

        if(adddes.isChecked()){
            values1.put(OrderContract.OrderEntry.COLUMN_DES, "Has Desiccated: YES");

        }
        else{
            values1.put(OrderContract.OrderEntry.COLUMN_DES, "Has Desiccated: NO");
        }

        if(mCurrentCartUri == null){
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values1);
            if(newUri == null){
                Toast.makeText(this, "Failed to add cart", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Success adding to cart", Toast.LENGTH_SHORT).show();
            }

        }

        hasAllRequiredValues = true;
        return hasAllRequiredValues;
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


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_CAKENAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_CHIPS,
                OrderContract.OrderEntry.COLUMN_DES,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_ADDRESS,
                OrderContract.OrderEntry.COLUMN_PHONE,
                OrderContract.OrderEntry.COLUMN_DATE

        };


        return new CursorLoader(this,mCurrentCartUri,projection,null,null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        if(cursor == null|| cursor.getCount()<1){
            return;

        }
        if(cursor.moveToFirst()){

            int cake_name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_CAKENAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
            int hasChips = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_CHIPS);
            int hasdes = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_DES);
            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int address = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_ADDRESS);
            int phone = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PHONE);
            int date = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_DATE);

            String nameofcake = cursor.getString(cake_name);
            String priceofcake = cursor.getString(price);
            String quantityofcake = cursor.getString(quantity);
            String yeshaschips = cursor.getString(hasChips);
            String yeshasdes = cursor.getString(hasdes);
            String Pname = cursor.getString(name);
            String Paddress = cursor.getString(address);
            String PPhone = cursor.getString(phone);
            String Odate = cursor.getString(date);

            cupcakeName.setText(nameofcake);
            cupcakePrice.setText(priceofcake);
            quantitynumber.setText(quantityofcake);
            PersonName.setText(Pname);
            homeaddress.setText(Paddress);
            phoneno.setText(PPhone);
            Date.setText(Odate);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        cupcakeName.setText("");
        cupcakePrice.setText("");
        quantitynumber.setText("");
        PersonName.setText("");
        homeaddress.setText("");
        phoneno.setText("");
        Date.setText("");

    }
}