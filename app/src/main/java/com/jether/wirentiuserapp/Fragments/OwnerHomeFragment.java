package com.jether.wirentiuserapp.Fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.L;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;


import com.jether.wirentiuserapp.Adapter.AdapterPropertyOwner;
import com.jether.wirentiuserapp.Adapter.SliderAdapterExample;
import com.jether.wirentiuserapp.BottomActivity;
import com.jether.wirentiuserapp.Model.ImageSliderModel;
import com.jether.wirentiuserapp.Model.PropertyModel;
import com.jether.wirentiuserapp.NedaActivity;
import com.jether.wirentiuserapp.NoInternetActivity;
import com.jether.wirentiuserapp.R;
import com.jether.wirentiuserapp.RetrofitApi.ApiClient;
import com.jether.wirentiuserapp.RetrofitApi.ApiInterface;
import com.jether.wirentiuserapp.RetrofitApi.Users;
import com.jether.wirentiuserapp.Sessions.SharedPrefManager;
import com.jether.wirentiuserapp.UpdateActivity;
import com.jether.wirentiuserapp.helper.PropertyDatabase;
import com.jether.wirentiuserapp.helper.Utils;
import com.scwang.wave.MultiWaveHeader;
import com.smarteist.autoimageslider.SliderView;

import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OwnerHomeFragment extends Fragment implements Serializable {
    private  final String TAG =OwnerHomeFragment.class.getSimpleName() ;
    public static ApiInterface apiInterface;

   SharedPrefManager sharedPrefManager;

    RecyclerView rv;

    private String user_nameee,user_email;


    int page =1,limit=3;

    TextView logo,reg,wel;
    Button logo2,reg2;
    Button Cancel1,Can;

    TextView up1;
    TextView jay;
    EditText full,eme,mo,pa;
    EditText eme2,pa2;
    RadioGroup radioGroup;
    RadioButton selectedType;
    TextView textView;

    private SearchView searchView;
    MultiWaveHeader multi;
    String user_id;

    TextView current,latest;
    ArrayList<PropertyModel> property1= new ArrayList<>();

    AdapterPropertyOwner adapterPropertyOwner;
    private PropertyDatabase mDatabase;

    public OwnerHomeFragment() {


    }

    private View view;

    SliderView sliderView;
    List<ImageSliderModel> imageSliderModelList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_owner_home, container, false);

        sharedPrefManager= new SharedPrefManager(getContext());

        logo=view.findViewById(R.id.textView17);
        wel=view.findViewById(R.id.textView15);
        searchView=view.findViewById(R.id.search);
        up1=view.findViewById(R.id.textView32);

        jay=view.findViewById(R.id.textView15);

        HashMap<String, String> kojo=sharedPrefManager.getUserDetail();
        String kajoee=kojo.get(SharedPrefManager.NAME);


        jay.setText("Welcome Back"+"\n"+kajoee);

        //initialize connection manager

        mDatabase= new PropertyDatabase(getContext());



        up1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity(), UpdateActivity.class);
                startActivity(intent);

            }
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                if (!searchView.isIconified()){
                    searchView.setIconified(true);
                }


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<PropertyModel>filterProperty=filter(property1,newText);
                adapterPropertyOwner.setfilter(filterProperty);

                return false;
            }
        });





        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPrefManager.editor.clear();
                sharedPrefManager.editor.commit();
                Intent intent= new Intent(getActivity(), BottomActivity.class);
                startActivity(intent);
                getActivity().finish();
                Animatoo.animateSlideLeft(getContext());

            }

        });

        imageSliderModelList=new ArrayList<>();
        sliderView=view.findViewById(R.id.imageSlider);

        imageSliderModelList.add(new ImageSliderModel(R.drawable.a));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.b));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.c));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.d));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.e));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.f));


        sliderView.setSliderAdapter(new SliderAdapterExample(getContext(),imageSliderModelList));

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        sharedPrefManager = new SharedPrefManager(getContext());



        if(Utils.isNetworkAvailable(getContext())){
            init();
        }else{

            getFeedFromDatabase();
        }




        return view;
    }

    private void getFeedFromDatabase() {
        List<PropertyModel> propertyModelList=mDatabase.getProps();

        for(int i=0;i< propertyModelList.size(); i++){
            PropertyModel propertyModel=propertyModelList.get(i);
            Log.d(TAG,propertyModel.getPropertyTitle()+"||"+propertyModel.getAddress());
        }
    }


    private void init() {

        rv=view.findViewById(R.id.pro);
        LinearLayoutManager linearpropertyManager= new LinearLayoutManager(getContext());
        linearpropertyManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(linearpropertyManager);

        property1= new ArrayList<>();
        Call<Users> propertyCall =apiInterface.getProperties();
        propertyCall.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {

                property1=response.body().getProperty();




                for(int i=0;i<property1.size();i++) {
                    PropertyModel propertyModel=property1.get(i);

                    adapterPropertyOwner = new AdapterPropertyOwner(property1, getContext());
                    saveIntoDatabase task = new saveIntoDatabase();
                    task.execute(propertyModel);

                    rv.setAdapter(adapterPropertyOwner);
                    adapterPropertyOwner.notifyDataSetChanged();
                }






            }



            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });

    }




    private List<PropertyModel>filter(ArrayList<PropertyModel> hi, String query){
        query=query.toLowerCase();
        final List<PropertyModel>filterModeList=new ArrayList<>();
        for (PropertyModel modal:hi){
            final String text=modal.getPropertyTitle().toLowerCase();
            final String text1=modal.getStatus().toLowerCase();
            final String text2=modal.getAddress().toLowerCase();

            if (text.startsWith(query)){
                filterModeList.add(modal);
            }
            else if (text1.startsWith(query)){
                filterModeList.add(modal);
            }
           else if (text2.startsWith(query)){
                filterModeList.add(modal);
            }

        }

        return filterModeList;
    }


    public class saveIntoDatabase extends AsyncTask<PropertyModel,PropertyModel,Boolean>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(PropertyModel... propertyModels) {

            PropertyModel propertyModel=propertyModels[0];
            try{
                InputStream stream=new URL(propertyModel.getFeaturedImage()).openStream();
                Bitmap bitmap= BitmapFactory.decodeStream(stream);
                propertyModel.setPicture(bitmap);
                publishProgress(propertyModel);

            }catch(Exception e){
                Log.d(TAG,e.getMessage());

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(PropertyModel... values) {
            super.onProgressUpdate(values);
            mDatabase.addPropertyList(values[0]);

        }


    }

    @Override
    public void onStart() {
        super.onStart();

        if (!sharedPrefManager.isLogin()) {

            sharedPrefManager.editor.clear();
            sharedPrefManager.editor.commit();

            Intent intent = new Intent(getContext(), BottomActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }else{

        }
    }
}
