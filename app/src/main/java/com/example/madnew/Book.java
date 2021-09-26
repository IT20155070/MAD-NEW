package com.example.madnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Book extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    OrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        getSupportActionBar().setTitle("CUP CAKES");
        //Search
        EditText editText = findViewById(R.id.edittext);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                filter(s.toString());

            }
        });


        modelList = new ArrayList<>();
        modelList.add(new Model("RED VELVET CUPCAKE", getString(R.string.redvelvet), R.drawable.redvelvate));
        modelList.add(new Model("CHOCOLATE CUPCAKE", getString(R.string.chocolate), R.drawable.chocolate));
        modelList.add(new Model("VANILLA CUPCAKE", getString(R.string.vanilla), R.drawable.vanilla));
        modelList.add(new Model("KITKAT CUPCAKE", getString(R.string.kitkat), R.drawable.kitkat));
        modelList.add(new Model("STRAWBERRY CUPCAKE", getString(R.string.stawberry), R.drawable.stawberry));
        modelList.add(new Model("GALAXY CUPCAKE", getString(R.string.galaxy), R.drawable.galaxy));
        modelList.add(new Model("CHERRY CUPCAKE", getString(R.string.cherry), R.drawable.cherry));
        modelList.add(new Model("CHOCOLATE HEAVEN CUPCAKE", getString(R.string.heaven), R.drawable.heaven));


        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));

        mAdapter = new OrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);


    }


    private void filter(String text){
        ArrayList<Model> filteredList = new ArrayList<>();

        for(Model item: modelList){

            if(item.getCupcakeName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);

            }
        }

        mAdapter.filterList(filteredList);
    }

}

