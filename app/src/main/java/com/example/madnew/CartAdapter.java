package com.example.madnew;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.madnew.Database.OrderContract;

public class CartAdapter extends CursorAdapter {


    public CartAdapter(Context context, Cursor curs) {
        super(context, curs, 0);
    }

    @Override
    public View newView(Context context, Cursor curs, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cartlist, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor curs) {

        TextView cakeName, yesChips, yesDes, price, quantity;



        cakeName = view.findViewById(R.id.cakeNameinOrderSummary);
        price = view.findViewById(R.id.priceinOrderSummary);
        yesChips = view.findViewById(R.id.hasChips);
        yesDes = view.findViewById(R.id.hasDes);
        quantity = view.findViewById(R.id.quantityinOrderSummary);


        int name = curs.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
        int priceofcake = curs.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
        int quantityofcake = curs.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
        int hasChips = curs.getColumnIndex(OrderContract.OrderEntry.COLUMN_CHIPS);
        int hasDes = curs.getColumnIndex(OrderContract.OrderEntry.COLUMN_DES);


        String nameofcake = curs.getString(name);
        String pricesofcake = curs.getString(priceofcake);
        String quatitysofcake = curs.getString(quantityofcake);
        String yeshasChips = curs.getString(hasChips);
        String yeshasDes = curs.getString(hasDes);


        cakeName.setText(nameofcake);
        price.setText(pricesofcake);
        yesChips.setText(yeshasChips);
        yesDes.setText(yeshasDes);
        quantity.setText(quatitysofcake);



    }




}
