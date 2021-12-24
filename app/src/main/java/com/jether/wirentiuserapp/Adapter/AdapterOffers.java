package com.jether.wirentiuserapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jether.wirentiuserapp.Model.GreatOffersModel;
import com.jether.wirentiuserapp.Model.PropertyModel;
import com.jether.wirentiuserapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterOffers extends RecyclerView.Adapter<AdapterOffers.GreatViewHolder>{


    private ArrayList<GreatOffersModel> great;
    Context context;

    public AdapterOffers(ArrayList<GreatOffersModel> great, Context context) {
        this.great = great;
        this.context = context;
    }

    @NonNull
    @Override
    public GreatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_offers,parent,false);
        return new GreatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GreatViewHolder holder, int position) {

        GreatOffersModel greatOffersModel=great.get(position);
        //set data
        String featured=greatOffersModel.getFeaturedImage();
        String status1=greatOffersModel.getStatus();
        String place1=greatOffersModel.getAddress();
        String price1=greatOffersModel.getRentorsalePrice();
        String name1=greatOffersModel.getPropertyTitle();


        holder.status.setText(status1);
        holder.place.setText(place1);
        holder.price.setText(price1);
        holder.name.setText(name1);


        try{
            Picasso.get().load(featured).placeholder(R.drawable.ic_b_house_24).into(holder.image22);

        }catch(Exception e){

        }

    }

    @Override
    public int getItemCount() {
        return great.size();
    }

    public static class GreatViewHolder extends RecyclerView.ViewHolder {
        ImageView image22;
        TextView status,name,place,price;



        public GreatViewHolder(@NonNull View itemView) {
            super(itemView);

            image22 = itemView.findViewById(R.id.image);
            status=itemView.findViewById(R.id.status);
            name=itemView.findViewById(R.id.apartment);
            place=itemView.findViewById(R.id.place);
            price=itemView.findViewById(R.id.price);




        }

    }
}
