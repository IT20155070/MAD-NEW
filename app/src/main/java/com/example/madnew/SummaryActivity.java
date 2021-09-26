package com.example.madnew;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.CursorLoader;

import android.app.LoaderManager;
import android.content.DialogInterface;
import android.content.Loader;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.madnew.Database.OrderContract;
import com.example.madnew.Database.OrderHelper;


public class SummaryActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {


    public CartAdapter cAdapter;
    public static final int LOADER = 0;
    orderDB dbn;

    //EditText name, address, phone, date;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        dbn = new orderDB(this);

        getSupportActionBar().setTitle("ORDER SUMMARY");

        getLoaderManager().initLoader(LOADER,null,this);
        ListView listview = findViewById(R.id.list);
        cAdapter = new CartAdapter(this,null);
        listview.setAdapter(cAdapter);


        confirm = findViewById(R.id.confirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });


    }

    private void showDialog() {

        //AlertDialog.Builder alert1= new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.insertorder,null);

        final EditText name = view.findViewById(R.id.name);
        final EditText address = view.findViewById(R.id.address);
        final EditText phone = view.findViewById(R.id.phone);
        final EditText date = view.findViewById(R.id.date);




        AlertDialog.Builder build = new AlertDialog.Builder(SummaryActivity.this);

        build.setView(view)
                .setTitle("Inserting Order  details")
                .setMessage("Enser new Details")
                .setPositiveButton("Enter Order Details", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        boolean res = dbn.insertDate(name.getText().toString(),address.getText().toString(),phone.getText().toString(),date.getText().toString());
                        if(res==true){
                            Toast.makeText(SummaryActivity.this, "Order confirmation successful!!", Toast.LENGTH_SHORT).show();

                        }
                        else{
                            Toast.makeText(SummaryActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        build.create().show();





    }


    public void showAlterDialog(View view){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Delete Orders in Order Summary");
            alert.setMessage("Do you want to Delete?");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    int deletethedata = getContentResolver().delete(OrderContract.OrderEntry.CONTENT_URI,null,null);

                    Toast.makeText(SummaryActivity.this, "Successfully deleted", Toast.LENGTH_SHORT).show();
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(SummaryActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            });

            alert.create().show();



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
        return new CursorLoader(this, OrderContract.OrderEntry.CONTENT_URI, projection, null, null,null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        cAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

       cAdapter.swapCursor(null);
    }
}