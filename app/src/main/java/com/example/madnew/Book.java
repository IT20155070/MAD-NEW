package com.example.madnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

}

