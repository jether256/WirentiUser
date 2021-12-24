package com.jether.wirentiuserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.jether.wirentiuserapp.Model.ImageSliderModel;
import com.jether.wirentiuserapp.RetrofitApi.ApiClient;
import com.jether.wirentiuserapp.RetrofitApi.ApiInterface;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PropertyDetailsActivity extends AppCompatActivity {
    private long backpressed;

    private String ID,UserID,PropertyTitle,Address,CountryName,City,Status,RentorsalePrice,PropertyID,FeaturedImage,GalleryImage1,GalleryImage2,GalleryImage3,StateName,
            GalleryImage4,GalleryImage5,Area,Bedrooms,Bathrooms,Size,Floors,Garages,PropertDescription;

    public static ApiInterface apiInterface;
    SliderView sliderView;
    List<ImageSliderModel> imageSliderModelList;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_details);




        ID=getIntent().getStringExtra("ID");
        UserID=getIntent().getStringExtra("UserID");
        PropertyTitle=getIntent().getStringExtra("PropertyTitle");
        Address=getIntent().getStringExtra("Address");
        CountryName=getIntent().getStringExtra("CountryName");
        StateName=getIntent().getStringExtra("StateName");
        City=getIntent().getStringExtra("City");
        Status=getIntent().getStringExtra("Status");
        RentorsalePrice=getIntent().getStringExtra("RentorsalePrice");
        PropertyID=getIntent().getStringExtra("PropertyID");
        FeaturedImage=getIntent().getStringExtra("FeaturedImage");
        GalleryImage1 =getIntent().getStringExtra("GalleryImage1");
        GalleryImage2 =getIntent().getStringExtra("GalleryImage2");
        GalleryImage3=getIntent().getStringExtra("GalleryImage3");
        GalleryImage4=getIntent().getStringExtra("GalleryImage4");
        GalleryImage5=getIntent().getStringExtra("GalleryImage5");
        Area=getIntent().getStringExtra("Area");
        Bedrooms=getIntent().getStringExtra("Bedrooms");
        Bathrooms=getIntent().getStringExtra("Bathrooms");
        Size=getIntent().getStringExtra("Size");
        Floors=getIntent().getStringExtra("Floors");
        Garages=getIntent().getStringExtra("Garages");
        PropertDescription=getIntent().getStringExtra("PropertDescription");


        TextView posted,name,place11,country333,city22,area1,size1,beds1,floors1,baths1,garage1,address4,addess1,state11,city,country,status,propertyid,price;
        ImageView gal1,ga2,ga3,ga4,ga5,feature;
        SliderView sliderView;


        name=findViewById(R.id.name);
       // place11=findViewById(R.id.place11);
        //country333=findViewById(R.id.country333);
        //city22=findViewById(R.id.city22);
        area1=findViewById(R.id.area1);
        size1=findViewById(R.id.size1);
        beds1=findViewById(R.id.beds1);
        floors1=findViewById(R.id.floors1);
        baths1=findViewById(R.id.baths1);
        garage1=findViewById(R.id.garage1);
        address4=findViewById(R.id.address4);
        addess1=findViewById(R.id.address1);

        city=findViewById(R.id.city);

        status=findViewById(R.id.status);
        propertyid=findViewById(R.id.propertyid);
        price=findViewById(R.id.price);

        button=findViewById(R.id.request);
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);

        feature=findViewById(R.id.gallery1);




        status.setText(Status);
        propertyid.setText(PropertyID);
        name.setText(PropertyTitle);
        //place11.setText(Address);
        //country333.setText(CountryName);
        //city22.setText(City);
        area1.setText(Area);
        size1.setText(Size);
        beds1.setText(Bedrooms);
        floors1.setText(Floors);
        baths1.setText(Bathrooms);
        garage1.setText(Garages);
        address4.setText(PropertDescription);
        addess1.setText(Address);

        city.setText(City);

        price.setText(RentorsalePrice);

        try{
            Picasso.get().load(FeaturedImage).placeholder(R.drawable.ic_b_house_24).into(feature);

        }catch(Exception e){

        }



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PropertyDetailsActivity.this, "Please Login first......", Toast.LENGTH_SHORT).show();
            }
        });

    }


}