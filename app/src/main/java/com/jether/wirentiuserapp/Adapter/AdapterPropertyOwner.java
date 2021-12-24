package com.jether.wirentiuserapp.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.jether.wirentiuserapp.Model.PropertyModel;
import com.jether.wirentiuserapp.PropertyDetailsOwnerActivity;
import com.jether.wirentiuserapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterPropertyOwner extends RecyclerView.Adapter<AdapterPropertyOwner.PropertyViewHolder>{



    private ArrayList<PropertyModel> properties;
    Context context;


    public AdapterPropertyOwner(ArrayList<PropertyModel> properties, Context context) {
        this.properties = properties;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterPropertyOwner.PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.property_owner,parent,false);
        return new AdapterPropertyOwner.PropertyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPropertyOwner.PropertyViewHolder holder, int position) {

        PropertyModel propertyModel = properties.get(position);
        //set data
        String pro=propertyModel.getID();
        String user1=propertyModel.getUserID();
        String title1=propertyModel.getPropertyTitle();
        String Desc1=propertyModel.getPropertDescription();
        String type1=propertyModel.getType();
        String status1=propertyModel.getStatus();
        String lo1=propertyModel.getLocation();
        String image1=propertyModel.getFeaturedImage();
        String address1=propertyModel.getAddress();
        String price1=propertyModel.getRentorsalePrice();
        String bed1 =propertyModel.getBedroom();
        String bath1=propertyModel.getBathrooms();
        String f1=propertyModel.getFloors();
        String ga1=propertyModel.getGarages();
        String s1=propertyModel.getSize();
        String area1=propertyModel.getArea();
        String b4=propertyModel.getBeforePricelabel();
        String Af4=propertyModel.getAfterPricelabel();
        String proIDD1=propertyModel.getPropertyID();
        String cwnte1r=propertyModel.getCenterCooling();
        String bal=propertyModel.getBalcony();
        String pet1=propertyModel.getPetFriendly();
        String babe1=propertyModel.getBarbeque();
        String fire1=propertyModel.getFireAlarm();
        String modern1=propertyModel.getModernKitchen();
        String storage1=propertyModel.getStorage();
        String dryer=propertyModel.getDryer();
        String heating1=propertyModel.getHeating();
        String pool1=propertyModel.getPool();
        String laundry1=propertyModel.getLaundry();
        String sauna1=propertyModel.getSauna();
        String gymn1=propertyModel.getGymn();
        String ele1=propertyModel.getElevator();
        String dish1=propertyModel.getDishWasher();
        String emer1=propertyModel.getEmergencyExit();
        String gal1=propertyModel.getGalleryImage1();
        String ga2=propertyModel.getGalleryImage2();
        String ga3=propertyModel.getGalleryImage3();
        String ga4=propertyModel.getGalleryImage4();
        String ga5=propertyModel.getGalleryImage5();
        String cantry1=propertyModel.getCountry();
        String city1=propertyModel.getCity();
        String state1=propertyModel.getState();
        String zip1=propertyModel.getZipCode();
        String nei1=propertyModel.getNeighborhood();
        String list1=propertyModel.getListingDate();


        //set ui views
        holder.status.setText(status1);
        holder.name.setText(title1);
        holder.city.setText(address1);
        holder.price.setText(price1);
        holder.beds.setText(bed1);
        holder.bath.setText(bath1);
        holder.area.setText(area1);

        //set user dp
        try{
            Picasso.get().load(image1).placeholder(R.drawable.ic_b_house_24).into(holder.image);

        }catch(Exception e){

        }


        holder.con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(context, PropertyDetailsOwnerActivity.class);
                intent.putExtra("ID",propertyModel.getID());
                intent.putExtra("UserID",propertyModel.getUserID());
                intent.putExtra("PropertyTitle",propertyModel.getPropertyTitle());
                intent.putExtra("Address",propertyModel.getAddress());
                intent.putExtra("CountryName",propertyModel.getCountry());
                intent.putExtra("City",propertyModel.getCity());
                intent.putExtra("Status",propertyModel.getStatus());
                intent.putExtra("RentorsalePrice",propertyModel.getRentorsalePrice());
                intent.putExtra("PropertyID",propertyModel.getPropertyID());
                intent.putExtra("FeaturedImage",propertyModel.getFeaturedImage());
                intent.putExtra("GalleryImage1",propertyModel.getGalleryImage1());
                intent.putExtra("GalleryImage2",propertyModel.getGalleryImage2());
                intent.putExtra("GalleryImage3",propertyModel.getGalleryImage3());
                intent.putExtra("GalleryImage4",propertyModel.getGalleryImage4());
                intent.putExtra("GalleryImage5",propertyModel.getGalleryImage5());
                intent.putExtra("Area",propertyModel.getArea());
                intent.putExtra("Bedrooms",propertyModel.getBedroom());
                intent.putExtra("Bathrooms",propertyModel.getBathrooms());
                intent.putExtra("Size",propertyModel.getSize());
                intent.putExtra("Floors",propertyModel.getFloors());
                intent.putExtra("Garages",propertyModel.getGarages());
                intent.putExtra("PropertDescription",propertyModel.getPropertDescription());
                intent.putExtra("CenterCooling",propertyModel.getCenterCooling());
                intent.putExtra("Balcony",propertyModel.getBalcony());
                intent.putExtra("PetFriendly",propertyModel.getPetFriendly());
                intent.putExtra("Barbeque",propertyModel.getBarbeque());
                intent.putExtra("FireAlarm",propertyModel.getFireAlarm());
                intent.putExtra("ModernKitchen",propertyModel.getModernKitchen());
                intent.putExtra("Storage",propertyModel.getStorage());
                intent.putExtra("Dryer",propertyModel.getDryer());
                intent.putExtra("Heating",propertyModel.getHeating());
                intent.putExtra("Pool",propertyModel.getPool());
                intent.putExtra("Laundry",propertyModel.getLaundry());
                intent.putExtra("Gym",propertyModel.getGymn());
                intent.putExtra("Elevator",propertyModel.getElevator());
                intent.putExtra("DishWasher",propertyModel.getDishWasher());
                intent.putExtra("EmergencyExit",propertyModel.getEmergencyExit());
                intent.putExtra("Sauna",propertyModel.getSauna());
                intent.putExtra("StateName",propertyModel.getState());
                context.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return properties.size();
    }

    public void setfilter(List<PropertyModel> filterProperty) {
        properties=new ArrayList<>();
        properties.addAll(filterProperty);
        notifyDataSetChanged();
    }


    public static class PropertyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView status,name,city,price,beds,bath,area;
        CardView con;


        public PropertyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView4);
            status= itemView.findViewById(R.id.textView5);
            name= itemView.findViewById(R.id.textView6);
            city= itemView.findViewById(R.id.textView7);
            price= itemView.findViewById(R.id.textView8);
            beds= itemView.findViewById(R.id.textView10);
            bath= itemView.findViewById(R.id.textView11);
            area= itemView.findViewById(R.id.textView12);
            con=itemView.findViewById(R.id.con);

        }

    }
}
