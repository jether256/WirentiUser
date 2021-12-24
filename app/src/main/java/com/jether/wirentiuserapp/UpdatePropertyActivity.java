package com.jether.wirentiuserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UpdatePropertyActivity extends AppCompatActivity {
     String ID,UserID,PropertyTitle,Address,CountryName,City,Status,RentorsalePrice,PropertyID,FeaturedImage,GalleryImage1,GalleryImage2,GalleryImage3,StateName,
            GalleryImage4,GalleryImage5,Area,Bedrooms,Bathrooms,Size,Floors,Garages,PropertDescription,CenterCooling,Balcony,PetFriendly,Barbeque,FireAlarm,ModernKitchen,
    Storage,Dryer,Heating,Pool,Laundry,Gym,Elevator,DishWasher,EmergencyExit,Sauna,ZipCode,Neighborhood,ListingDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_property);

        ID = getIntent().getStringExtra("ID");
        UserID = getIntent().getStringExtra("UserID");
        PropertyTitle = getIntent().getStringExtra("PropertyTitle");
        Address = getIntent().getStringExtra("Address");
        CountryName = getIntent().getStringExtra("CountryName");
        StateName = getIntent().getStringExtra("StateName");
        City = getIntent().getStringExtra("City");
        Status = getIntent().getStringExtra("Status");
        RentorsalePrice = getIntent().getStringExtra("RentorsalePrice");
        PropertyID = getIntent().getStringExtra("PropertyID");
        FeaturedImage = getIntent().getStringExtra("FeaturedImage");
        GalleryImage1 = getIntent().getStringExtra("GalleryImage1");
        GalleryImage2 = getIntent().getStringExtra("GalleryImage2");
        GalleryImage3 = getIntent().getStringExtra("GalleryImage3");
        GalleryImage4 = getIntent().getStringExtra("GalleryImage4");
        GalleryImage5 = getIntent().getStringExtra("GalleryImage5");
        Area = getIntent().getStringExtra("Area");
        Bedrooms = getIntent().getStringExtra("Bedrooms");
        Bathrooms = getIntent().getStringExtra("Bathrooms");
        Size = getIntent().getStringExtra("Size");
        Floors = getIntent().getStringExtra("Floors");
        Garages = getIntent().getStringExtra("Garages");
        PropertDescription = getIntent().getStringExtra("PropertDescription");
        CenterCooling=getIntent().getStringExtra("CenterCooling");
        Balcony=getIntent().getStringExtra("Balcony");
        PetFriendly=getIntent().getStringExtra("PetFriendly");
        Barbeque=getIntent().getStringExtra("Barbeque");
        FireAlarm=getIntent().getStringExtra("FireAlarm");
        ModernKitchen=getIntent().getStringExtra("ModernKitchen");
        Storage=getIntent().getStringExtra("Storage");
        Dryer=getIntent().getStringExtra("Dryer");
        Heating=getIntent().getStringExtra("Heating");
        Pool=getIntent().getStringExtra("Pool");
        Laundry=getIntent().getStringExtra("Laundry");
        Gym=getIntent().getStringExtra("Gym");
        Elevator=getIntent().getStringExtra("Elevator");
        DishWasher=getIntent().getStringExtra("DishWater");
        EmergencyExit=getIntent().getStringExtra("EmergencyExit");
        Sauna=getIntent().getStringExtra("Sauna");
        ZipCode=getIntent().getStringExtra("ZipCode");
        Neighborhood=getIntent().getStringExtra("Neighborhood");
        ListingDate=getIntent().getStringExtra("ListingDate");

    }
}