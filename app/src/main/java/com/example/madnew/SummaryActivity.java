package com.example.madnew;

import androidx.appcompat.app.AppCompatActivity;
import android.content.CursorLoader;

import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.example.madnew.database.OrderContract;

public class SummaryActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public CartAdapter nAdapter;
    public static final int LOADER = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);


        getLoaderManager().initLoader(LOADER,null,this);
        ListView listView = findViewById(R.id.list);
        nAdapter = new CartAdapter(this,null);
        listView.setAdapter(nAdapter);



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

        return new CursorLoader(this, OrderContract.OrderEntry.CONTENT_URI, projection,null,null,null);


    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        nAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        nAdapter.swapCursor(null);
    }
}