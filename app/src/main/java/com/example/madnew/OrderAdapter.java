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

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {


    List<Model> modelList;
    Context context;

    public OrderAdapter(Context context, List<Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.listitem,parent,false);
         return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //find the position and start setting the output on our views

        String nameofcake = modelList.get(position).getCupcakeName();
        String detailsofcake = modelList.get(position).getCupcakeDetails();
        int images = modelList.get(position).getCupcakePhoto();

        holder.cupcakeName.setText(nameofcake);
        holder.cupcakeDetails.setText(detailsofcake);
        holder.cupcakePhoto.setImageResource(images);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void filterList(ArrayList<Model> filteredList){
        modelList = filteredList;
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView cupcakeName,cupcakeDetails;
        ImageView cupcakePhoto;

        public ViewHolder(View itemView) {
            super(itemView);
            cupcakeName = itemView.findViewById(R.id.cupcakeName);
            cupcakeDetails = itemView.findViewById(R.id.description);
            cupcakePhoto = itemView.findViewById(R.id.cupcakeImage);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();

            if(position == 0){
                Intent intentinfo = new Intent(context, infoActivity.class);
                context.startActivity(intentinfo);
            }

            if(position == 1){
                Intent intentinfo2 = new Intent(context, chocolateActivity.class);
                context.startActivity(intentinfo2);
            }

            if(position == 2){
                Intent intentinfo3 = new Intent(context, vanila.class);
                context.startActivity(intentinfo3);
            }

            if(position == 3){
                Intent intentinfo4 = new Intent(context, kitkat.class);
                context.startActivity(intentinfo4);
            }

            if(position == 4){
                Intent intentinfo5 = new Intent(context, stawberry.class);
                context.startActivity(intentinfo5);
            }

            if(position == 5){
                Intent intentinfo6 = new Intent(context, galaxy.class);
                context.startActivity(intentinfo6);
            }

            if(position == 6){
                Intent intentinfo7 = new Intent(context, cherry.class);
                context.startActivity(intentinfo7);
            }

            if(position == 7){
                Intent intentinfo8 = new Intent(context, heaven.class);
                context.startActivity(intentinfo8);
            }

        }
    }

}
