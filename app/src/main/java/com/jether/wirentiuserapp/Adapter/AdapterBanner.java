package com.jether.wirentiuserapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.jether.wirentiuserapp.Model.BannerModel;
import com.jether.wirentiuserapp.Model.MyPropertyModel;
import com.jether.wirentiuserapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterBanner extends RecyclerView.Adapter<AdapterBanner.BannerViewHolder> {

    private ArrayList<BannerModel> banner;
    Context context;

    public AdapterBanner(ArrayList<BannerModel> banner, Context context) {
        this.banner = banner;
        this.context = context;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_layout,parent,false);
        return new BannerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        BannerModel bannerModel=banner.get(position);


        Integer bani=bannerModel.getImage();

        //set user dp
        try{
            Picasso.get().load(bani).placeholder(R.drawable.ic_b_house_24).into(holder.image22);

        }catch(Exception e){

        }

    }

    @Override
    public int getItemCount() {
        return banner.size();
    }

    public static class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView image22;



        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);

            image22 = itemView.findViewById(R.id.image);


        }

    }
}
