package com.jether.wirentiuserapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.jether.wirentiuserapp.Adapter.AdapterReview;
import com.jether.wirentiuserapp.Model.ImageSliderModel;
import com.jether.wirentiuserapp.Model.ModelReview;
import com.jether.wirentiuserapp.RetrofitApi.ApiClient;
import com.jether.wirentiuserapp.RetrofitApi.ApiInterface;
import com.jether.wirentiuserapp.RetrofitApi.Users;
import com.jether.wirentiuserapp.Sessions.SharedPrefManager;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

 public class PropertyDetailsOwnerActivity extends AppCompatActivity {
     private long backpressed;
     private String ID,UserID,PropertyTitle,Address,CountryName,City,Status,RentorsalePrice,PropertyID,FeaturedImage,GalleryImage1,GalleryImage2,GalleryImage3,StateName,
             GalleryImage4,GalleryImage5,Area,Bedrooms,Bathrooms,Size,Floors,Garages,PropertDescription;

     public static ApiInterface apiInterface;
     SliderView sliderView;
     List<ImageSliderModel> imageSliderModelList;
     SharedPrefManager sharedPrefManager;

     TextView te;

     EditText urName,urEmail,urPhone,urMessage;
     EditText review;
     Button subrev;

     String user_id;


     Button request;

     RecyclerView rec;
     ArrayList<ModelReview> leview= new ArrayList<>();
     AdapterReview adapterReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_details_owner);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        sharedPrefManager= new SharedPrefManager(this);


        HashMap<String, String> kojo=sharedPrefManager.getUserDetail();

        String name1=kojo.get(SharedPrefManager.NAME);
        String email1=kojo.get(SharedPrefManager.EMAIL);
        String mobile1=kojo.get(SharedPrefManager.MOBILE);


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


        TextView posted, name, place11, country333, city22, area1, size1, beds1, floors1, baths1, garage1, address4, addess1, state11, city, country, status, propertyid, price;

        ImageView gal1, ga2, ga3, ga4, ga5, feature;
        SliderView sliderView;

        te=findViewById(R.id.prope);
        urName = findViewById(R.id.name22);
        urEmail = findViewById(R.id.email);
        urPhone = findViewById(R.id.phone);
        urMessage = findViewById(R.id.message);
        request = findViewById(R.id.mutale);


        urName.setText(name1);
        urEmail.setText(email1);
        urPhone.setText(mobile1);



        name = findViewById(R.id.name);
        // place11=findViewById(R.id.place11);
        //country333=findViewById(R.id.country333);
        //city22=findViewById(R.id.city22);
        area1 = findViewById(R.id.area1);
        size1 = findViewById(R.id.size1);
        beds1 = findViewById(R.id.beds1);
        floors1 = findViewById(R.id.floors1);
        baths1 = findViewById(R.id.baths1);
        garage1 = findViewById(R.id.garage1);
        address4 = findViewById(R.id.address4);
        addess1 = findViewById(R.id.address1);

        city = findViewById(R.id.city);

        status = findViewById(R.id.status);
        propertyid = findViewById(R.id.propertyid);
        price = findViewById(R.id.price);


        te.setText(ID);

        //posted.setText(UserID);
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

        feature=findViewById(R.id.gallery1);


       // posted.setText(UserID);
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





        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pro_iddd= te.getText().toString().trim();
                String user_full = urName.getText().toString().trim();
                String user_mail = urEmail.getText().toString().trim();
                String user_mobile = urPhone.getText().toString().trim();
                String user_message = urMessage.getText().toString().trim();

                if (TextUtils.isEmpty(user_full)) {
                    urName.setError("Full name is required");
                } else if (TextUtils.isEmpty(user_mail)) {
                    urEmail.setError("Email is required");
                } else if (TextUtils.isEmpty(user_mobile)) {
                    urPhone.setError("Mobile Number is required");
                } else {
                 ProgressDialog dialog = new ProgressDialog(PropertyDetailsOwnerActivity.this);
                dialog.setTitle("Submitting...");
                dialog.setMessage("Please wait while we submit your request...");
                 dialog.show();
                  dialog.setCanceledOnTouchOutside(false);


                    Call<Users> call = apiInterface.requestShowing(pro_iddd,user_full, user_mail, user_mobile, user_message);
                    call.enqueue(new Callback<Users>() {
                        @Override
                        public void onResponse(Call<Users> call, Response<Users> response) {

                            if (response.body().getResponse().equals("Ok")) {




                                Toast.makeText(PropertyDetailsOwnerActivity.this, "Submitted successfully....", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            } else if (response.body().getResponse().equals("failed")) {
                                Toast.makeText(PropertyDetailsOwnerActivity.this, "Something went wrong,Please try again....", Toast.LENGTH_SHORT).show();
                               dialog.dismiss();
                            } else if (response.body().getResponse().equals("already")) {
                                Toast.makeText(PropertyDetailsOwnerActivity.this, "This Email already exists,Please try another....", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }

                        }

                        @Override
                        public void onFailure(Call<Users> call, Throwable t) {
                            dialog.dismiss();

                        }
                    });

                }


            }
        });







    }



 }