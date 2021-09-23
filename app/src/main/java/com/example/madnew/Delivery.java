package com.example.madnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Delivery extends AppCompatActivity {

    List<Model1>modelList;
    RecyclerView recyclerView;
    OrderAdapter1 orderAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        modelList = new ArrayList<>();
        modelList.add(new Model1("Rice and Curry",getString(R.string.Rice1),R.drawable.rice1));
        modelList.add(new Model1("Fried Rice",getString(R.string.Rice2),R.drawable.rice2));
        modelList.add(new Model1("Sea Food Rice",getString(R.string.Rice3),R.drawable.rice3));
        modelList.add(new Model1("Popcorn Veggie Pizza",getString(R.string.pizza1),R.drawable.pizza1));
        modelList.add(new Model1("Chicken Pizza",getString(R.string.pizza2),R.drawable.pizza2));
        modelList.add(new Model1("Cheese Pizza",getString(R.string.pizza3),R.drawable.pizza3));
        modelList.add(new Model1("Mutton Pizza",getString(R.string.pizza4),R.drawable.pizza4));
        modelList.add(new Model1("Vegetable Kottu",getString(R.string.Kottu1),R.drawable.kottu1));
        modelList.add(new Model1("Chicken Kottu",getString(R.string.Kottu2),R.drawable.kottu2));

        recyclerView = findViewById(R.id.recycler_view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));

        orderAdapter1 = new OrderAdapter1(this,modelList);
        recyclerView.setAdapter(orderAdapter1);





    }
}