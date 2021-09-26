package com.example.madnew.Database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class OrderProvider extends ContentProvider {

    public static final int ORDER  = 100;

    public static UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static{
        sUriMatcher.addURI(OrderContract.CONTENT_AUTHORITY, OrderContract.PATH, ORDER);
    }

    public OrderHelper nHelper;

    @Override
    public boolean onCreate() {
        nHelper = new OrderHelper(getContext());
        return true;
    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,String sortOrder) {

        SQLiteDatabase database = nHelper.getReadableDatabase();
        Cursor curs;

        int match = sUriMatcher.match(uri);
        switch (match){
            case ORDER:
                curs = database.query(OrderContract.OrderEntry.TABLE_NAME, projection, selection,selectionArgs, null, null, sortOrder);
                break;

            default:
                throw  new IllegalArgumentException("CANT QUERY");

        }

        curs.setNotificationUri(getContext().getContentResolver(), uri);
        return curs;

    }


    @Override
    public String getType(Uri uri) {
        return null;
    }


    @Override
    public Uri insert(Uri uri, ContentValues values) {

        int match = sUriMatcher.match(uri);
        switch (match){
            case ORDER:
                return insertCart(uri, values);

            default:
                throw new IllegalArgumentException("CANT INSERT DATA");

        }

    }

    private Uri insertCart(Uri uri, ContentValues values) {
        String name = values.getAsString(OrderContract.OrderEntry.COLUMN_NAME);
        if(name == null){
            throw  new IllegalArgumentException("Name is Required");

        }
        String quantity = values.getAsString(OrderContract.OrderEntry.COLUMN_QUANTITY);
        if(quantity == null){
            throw  new IllegalArgumentException("Quantity is Required");

        }
        String price = values.getAsString(OrderContract.OrderEntry.COLUMN_PRICE);
        if(price == null){
            throw  new IllegalArgumentException("Price is Required");

        }
        SQLiteDatabase database = nHelper.getWritableDatabase();
        long id = database.insert(OrderContract.OrderEntry.TABLE_NAME, null, values);

        if(id == -1){
            return null;
        }
        getContext().getContentResolver().notifyChange(uri , null);
        return ContentUris.withAppendedId(uri, id);

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {


        int rowsDeleted;
        SQLiteDatabase database = nHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        switch(match){
            case ORDER:
                rowsDeleted = database.delete(OrderContract.OrderEntry.TABLE_NAME, selection, selectionArgs);
                break;

            default:
                throw  new IllegalArgumentException("Cannot delete");

        }

        if(rowsDeleted!=0){
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return rowsDeleted;

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
