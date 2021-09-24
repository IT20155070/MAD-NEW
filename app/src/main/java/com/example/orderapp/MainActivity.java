package com.example.orderapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Model> modelList;
    RecyclerView recyclerView;
    OrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creating an arraylist

        modelList = new ArrayList<>();
        modelList.add(new Model("Rice and Curry", getString(R.string.greentea), R.drawable.greentea ));
        modelList.add(new Model("Chicken Fried Rice", getString(R.string.latte), R.drawable.late));
        modelList.add(new Model("See Food Rice", getString(R.string.orangesmoothie), R.drawable.orange));
        modelList.add(new Model("Orange Vanilla", getString(R.string.orangevanilla), R.drawable.orangevanilla));
        modelList.add(new Model("Chicken Pizza", getString(R.string.cappcuni), R.drawable.cappcunio));
        modelList.add(new Model("Cheese Pizza", getString(R.string.thaitea), R.drawable.thaitea));
        modelList.add(new Model("Mutton Pizza", getString(R.string.tea), R.drawable.tea));
        modelList.add(new Model("Kottu", getString(R.string.bubbletea), R.drawable.milk));
        modelList.add(new Model("Mix Kottu", getString(R.string.match), R.drawable.match));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new OrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);




    }
}