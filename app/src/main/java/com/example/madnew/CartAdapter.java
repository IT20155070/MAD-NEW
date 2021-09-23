package com.example.madnew;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.madnew.database.OrderContract;

public class CartAdapter extends CursorAdapter {


    public CartAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cartlist,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView cupcakeName, haschips, hasdes, price, quantity;
        EditText Personname, Peaddress, pePhone, Orderdate;

        cupcakeName = view.findViewById(R.id.cakeNameinOrderSummary);
        price = view.findViewById(R.id.priceinOrderSummary);
        haschips = view.findViewById(R.id.hasChips);
        hasdes = view.findViewById(R.id.hasDes);
        quantity = view.findViewById(R.id.quantityinOrderSummary);
        Personname = view.findViewById(R.id.sumName);
        Peaddress = view.findViewById(R.id.sumaddress);
        pePhone = view.findViewById(R.id.sumPhone);
        Orderdate = view.findViewById(R.id.Sumdate);


        int cake_name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_CAKENAME);
        int cakeprice = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
        int cakequantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
        int hasChips = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_CHIPS);
        int hasDes = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_DES);
        int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
        int address = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_ADDRESS);
        int phone = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PHONE);
        int date = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_DATE);

        String nameofcake = cursor.getString(cake_name);
        String priceofcake = cursor.getString(cakeprice);
        String quantityofcake = cursor.getString(cakequantity);
        String yeshaschips = cursor.getString(hasChips);
        String yeshasdes = cursor.getString(hasDes);
        String Pname = cursor.getString(name);
        String Paddress = cursor.getString(address);
        String PPhone = cursor.getString(phone);
        String Odate = cursor.getString(date);

        cupcakeName.setText(nameofcake);
        price.setText(priceofcake);
        haschips.setText(yeshaschips);
        hasdes.setText(yeshasdes);
        quantity.setText(quantityofcake);
        Personname.setText(Pname);
        Peaddress.setText(Paddress);
        pePhone.setText(PPhone);
        Orderdate.setText(Odate);


    }
}
