package com.example.madnew;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class OrderAdapter1 extends RecyclerView.Adapter<OrderAdapter1.ViewHolder>{

    List<Model1>model1List;
    Context context;


    public OrderAdapter1(Context context,List<Model1>model1List) {
        this.context = context;
        this.model1List = model1List;

    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.listitem1, parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        String nameofFood = model1List.get(position).getFoodname();
        String description = model1List.get(position).getFooddetails();
        int image = model1List.get(position).getFoodPhoto();

        holder.Foodname.setText(nameofFood);
        holder.Fooddetails.setText(description);
        holder.FoodPhoto.setImageResource(image);

    }

    @Override
    public int getItemCount() {
        return model1List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView Foodname,Fooddetails;
        ImageView FoodPhoto;

        public ViewHolder( View itemView) {
            super(itemView);

            Foodname = itemView.findViewById(R.id.foodname);
            Fooddetails = itemView.findViewById(R.id.description);
            FoodPhoto = itemView.findViewById(R.id.Foodpic);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            if(position == 0){
                Intent intent = new Intent(context, infoActivity1.class);
                context.startActivity(intent);
            }


        }
    }
}
