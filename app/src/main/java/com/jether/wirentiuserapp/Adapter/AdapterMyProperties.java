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


import com.jether.wirentiuserapp.Model.MyPropertyModel;
import com.jether.wirentiuserapp.R;
import com.jether.wirentiuserapp.UpdatePropertyActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Callback;

public class AdapterMyProperties extends  RecyclerView.Adapter<AdapterMyProperties.PropertyViewHolder>{
    private ArrayList<MyPropertyModel> properties2;
    Context context;

    public AdapterMyProperties(ArrayList<MyPropertyModel> properties2, Context context) {
        this.properties2 = properties2;
        this.context = context;
    }

    @NonNull
    @Override
    public PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my,parent,false);
        return new PropertyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyViewHolder holder, int position) {
        MyPropertyModel myPropertyModel=properties2.get(position);

        String pro =myPropertyModel.getID();
        String user1=myPropertyModel.getUserID();
        String title1 =myPropertyModel.getPropertyTitle();
        String desc=myPropertyModel.getPropertDescription();
        String type=myPropertyModel.getType();
        String status1 =myPropertyModel.getStatus();
        String loco=myPropertyModel.getLocation();
        String beds1=myPropertyModel.getBedroom();
        String baths1 =myPropertyModel.getBathrooms();
        String floors =myPropertyModel.getFloors();
        String garages =myPropertyModel.getGarages();
        String area1=myPropertyModel.getArea();
        String size=myPropertyModel.getSize();
        String rentorprice=myPropertyModel.getRentorsalePrice();
        String before=myPropertyModel.getBeforePricelabel();
        String after=myPropertyModel.getAfterPricelabel();
        String proid=myPropertyModel.getPropertyID();
        String center =myPropertyModel.getCenterCooling();
        String balcony =myPropertyModel.getBalcony();
        String cooling =myPropertyModel.getCenterCooling();
        String pet =myPropertyModel.getPetFriendly();
        String baba =myPropertyModel.getBarbeque();
        String fire =myPropertyModel.getFireAlarm();
        String modern =myPropertyModel.getModernKitchen();
        String sto =myPropertyModel.getStorage();
        String dryer=myPropertyModel.getDryer();
        String heating=myPropertyModel.getHeating();
        String pool=myPropertyModel.getPool();
        String laundry=myPropertyModel.getLaundry();
        String Sauna=myPropertyModel.getSauna();
        String gymn=myPropertyModel.getGymn();
        String ele=myPropertyModel.getElevator();
        String dish=myPropertyModel.getDishWasher();
        String eme=myPropertyModel.getEmergencyExit();
        String featured =myPropertyModel.getFeaturedImage();
        String gallery1=myPropertyModel.getGalleryImage1();
        String gallery2=myPropertyModel.getGalleryImage2();
        String gallery3=myPropertyModel.getGalleryImage3();
        String gallery4=myPropertyModel.getGalleryImage4();
        String gallery5=myPropertyModel.getGalleryImage5();
        String address1=myPropertyModel.getAddress();
        String state=myPropertyModel.getState();
        String zip=myPropertyModel.getZipCode();
        String neigh=myPropertyModel.getNeighborhood();
        String list=myPropertyModel.getListingDate();


        //set ui views
        holder.status.setText(status1);
        holder.name.setText(title1);
        holder.city.setText(address1);
        holder.price.setText(rentorprice);
        holder.beds.setText(beds1);
        holder.bath.setText(baths1);
        holder.area.setText(area1);

        //set user dp
        try{
            Picasso.get().load(featured).placeholder(R.drawable.ic_b_house_24).into(holder.image);

        }catch(Exception e){

        }


        holder.con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(context, UpdatePropertyActivity.class);
                intent.putExtra("ID",myPropertyModel.getID());
                intent.putExtra("UserID",myPropertyModel.getUserID());
                intent.putExtra("PropertyTitle",myPropertyModel.getPropertyTitle());
                intent.putExtra("Address",myPropertyModel.getAddress());
                intent.putExtra("CountryName",myPropertyModel.getCountry());
                intent.putExtra("City",myPropertyModel.getCity());
                intent.putExtra("Status",myPropertyModel.getStatus());
                intent.putExtra("RentorsalePrice",myPropertyModel.getRentorsalePrice());
                intent.putExtra("PropertyID",myPropertyModel.getPropertyID());
                intent.putExtra("FeaturedImage",myPropertyModel.getFeaturedImage());
                intent.putExtra("GalleryImage1",myPropertyModel.getGalleryImage1());
                intent.putExtra("GalleryImage2",myPropertyModel.getGalleryImage2());
                intent.putExtra("GalleryImage3",myPropertyModel.getGalleryImage3());
                intent.putExtra("GalleryImage4",myPropertyModel.getGalleryImage4());
                intent.putExtra("GalleryImage5",myPropertyModel.getGalleryImage5());
                intent.putExtra("Area",myPropertyModel.getArea());
                intent.putExtra("Bedrooms",myPropertyModel.getBedroom());
                intent.putExtra("Bathrooms",myPropertyModel.getBathrooms());
                intent.putExtra("Size",myPropertyModel.getSize());
                intent.putExtra("Floors",myPropertyModel.getFloors());
                intent.putExtra("Garages",myPropertyModel.getGarages());
                intent.putExtra("PropertDescription",myPropertyModel.getPropertDescription());
                intent.putExtra("CenterCooling",myPropertyModel.getCenterCooling());
                intent.putExtra("Balcony",myPropertyModel.getBalcony());
                intent.putExtra("PetFriendly",myPropertyModel.getPetFriendly());
                intent.putExtra("Barbeque",myPropertyModel.getBarbeque());
                intent.putExtra("FireAlarm",myPropertyModel.getFireAlarm());
                intent.putExtra("ModernKitchen",myPropertyModel.getModernKitchen());
                intent.putExtra("Storage",myPropertyModel.getStorage());
                intent.putExtra("Dryer",myPropertyModel.getDryer());
                intent.putExtra("Heating",myPropertyModel.getHeating());
                intent.putExtra("Pool",myPropertyModel.getPool());
                intent.putExtra("Laundry",myPropertyModel.getLaundry());
                intent.putExtra("Gym",myPropertyModel.getGymn());
                intent.putExtra("Elevator",myPropertyModel.getElevator());
                intent.putExtra("DishWasher",myPropertyModel.getDishWasher());
                intent.putExtra("EmergencyExit",myPropertyModel.getEmergencyExit());
                intent.putExtra("Sauna",myPropertyModel.getSauna());
                intent.putExtra("StateName",myPropertyModel.getState());
                intent.putExtra("ZipCode",myPropertyModel.getZipCode());
                intent.putExtra("Neighborhood",myPropertyModel.getNeighborhood());
                intent.putExtra("ListingDate",myPropertyModel.getListingDate());
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return properties2.size();
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
