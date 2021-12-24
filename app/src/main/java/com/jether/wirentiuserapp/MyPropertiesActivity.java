package com.jether.wirentiuserapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import com.jether.wirentiuserapp.Adapter.AdapterMyProperties;
import com.jether.wirentiuserapp.Adapter.SliderAdapterExample;
import com.jether.wirentiuserapp.Model.ImageSliderModel;
import com.jether.wirentiuserapp.Model.MyPropertyModel;
import com.jether.wirentiuserapp.RetrofitApi.ApiClient;
import com.jether.wirentiuserapp.RetrofitApi.ApiInterface;
import com.jether.wirentiuserapp.RetrofitApi.Users;
import com.jether.wirentiuserapp.Sessions.SharedPrefManager;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPropertiesActivity extends AppCompatActivity {


    public static ApiInterface apiInterface;

    RecyclerView rv;
    TextView logo;

    SharedPrefManager sharedPrefManager;

    ArrayList<MyPropertyModel> property2= new ArrayList<>();

    AdapterMyProperties adapterPropertyMy;

    SliderView sliderView;
    List<ImageSliderModel> imageSliderModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_properties);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sharedPrefManager= new SharedPrefManager(this);

        logo=findViewById(R.id.textView17);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPrefManager.editor.clear();
                sharedPrefManager.editor.commit();
                Intent intent= new Intent(MyPropertiesActivity.this, BottomActivity.class);
                startActivity(intent);
                finish();
                Animatoo.animateSlideLeft(MyPropertiesActivity.this);

            }

        });

        imageSliderModelList=new ArrayList<>();
        sliderView=findViewById(R.id.imageSlider);

        imageSliderModelList.add(new ImageSliderModel(R.drawable.a));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.b));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.c));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.d));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.e));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.f));


        sliderView.setSliderAdapter(new SliderAdapterExample(MyPropertiesActivity.this,imageSliderModelList));

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        sharedPrefManager = new SharedPrefManager(this);



        init();
    }

    private void init() {

        rv=findViewById(R.id.pro);
        LinearLayoutManager linearpropertyManager= new LinearLayoutManager(this);
        linearpropertyManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(linearpropertyManager);

        property2= new ArrayList<>();
        Call<Users> propertyCall =apiInterface.getMyProperties();
        propertyCall.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {




                property2=response.body().getPropertyMine();

                adapterPropertyMy= new AdapterMyProperties(property2,MyPropertiesActivity.this);
                rv.setAdapter(adapterPropertyMy);
                adapterPropertyMy.notifyDataSetChanged();



            }



            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });

    }






    @Override
    public void onStart() {
        super.onStart();

        if (!sharedPrefManager.isLogin()) {

            sharedPrefManager.editor.clear();
            sharedPrefManager.editor.commit();

            Intent intent = new Intent(MyPropertiesActivity.this,BottomActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }else{

        }
    }

}