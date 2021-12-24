package com.jether.wirentiuserapp;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class FeaturedImageActivity extends AppCompatActivity {

    String FeaturedImage;

    ImageView featured;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_featured_image);
        FeaturedImage=getIntent().getStringExtra("FeaturedImage");
        featured=findViewById(R.id.featured22);



        try{
            Picasso.get().load(FeaturedImage).placeholder(R.drawable.ic_b_house_24).into(featured);

        }catch(Exception e){

        }

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}