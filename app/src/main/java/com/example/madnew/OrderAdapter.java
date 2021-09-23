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

        }
    }

}
