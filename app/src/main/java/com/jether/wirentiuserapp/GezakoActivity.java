package com.jether.wirentiuserapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.jether.wirentiuserapp.Adapter.AdapterBanner;
import com.jether.wirentiuserapp.Adapter.AdapterOffers;
import com.jether.wirentiuserapp.Adapter.AdapterProperty;
import com.jether.wirentiuserapp.Adapter.SliderAdapterExample;
import com.jether.wirentiuserapp.Model.BannerModel;
import com.jether.wirentiuserapp.Model.GreatOffersModel;
import com.jether.wirentiuserapp.Model.ImageSliderModel;
import com.jether.wirentiuserapp.Model.PropertyModel;
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

public class GezakoActivity extends AppCompatActivity {

    public static ApiInterface apiInterface;

    RecyclerView rv;

    SearchView searchView;

    TextView logo,reg;
    Button logo2,reg2;
    Button Cancel1,Can;

    EditText full,eme,mo,pa,own;
    EditText eme2,pa2;
    RadioGroup radioGroup;

    RadioButton radioButton;

    String user_id;
    String user_typp;
    String user_moo;
    String user_namee;
    String user_emaill;
    String user_passs;
    String user_about1;
    SharedPrefManager sharedPrefManager;

    ArrayList<PropertyModel> property= new ArrayList<>();
    AdapterProperty adapterProperty;


    SliderView sliderView;
    List<ImageSliderModel> imageSliderModelList;



    //////banner////
    private RecyclerView greatHorizontal;
    private AdapterOffers adapterGreta;
    private ArrayList<GreatOffersModel> gretaList;

    /////great offers////
    private RecyclerView ben;
    private AdapterBanner banange;
    private ArrayList<BannerModel> banners;

    //////New Arrivals////
    private RecyclerView latest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gezako);


        logo=findViewById(R.id.textView17);
        reg=findViewById(R.id.textView16);
        latest=findViewById(R.id.damu);

        searchView=findViewById(R.id.search);


        sharedPrefManager= new SharedPrefManager(this);







        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDia();
            }
        });


        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
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


        sliderView.setSliderAdapter(new SliderAdapterExample(this,imageSliderModelList));

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        sharedPrefManager= new SharedPrefManager(this);


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
                final List<PropertyModel>filterProperty=filter(property,newText);
                adapterProperty.setfilter(filterProperty);

                return false;
            }
        });



        init();

        initGreat();

        ini();

        Arrivals();
    }

    private void Arrivals() {

        latest=findViewById(R.id.damu);
        LinearLayoutManager linearpropertyManager= new LinearLayoutManager(this);
        linearpropertyManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(linearpropertyManager);

        property= new ArrayList<>();
        Call<Users> propertyCall =apiInterface.getProperties();
        propertyCall.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {

                property=response.body().getProperty();

                adapterProperty= new AdapterProperty(property,GezakoActivity.this);
                rv.setAdapter(adapterProperty);
                adapterProperty.notifyDataSetChanged();

            }



            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });

    }

    private void initGreat() {

        ////great/////

        greatHorizontal=(RecyclerView)findViewById(R.id.special);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        ben.setLayoutManager(linearLayoutManager);

        gretaList= new ArrayList<>();
        gretaList.add(new GreatOffersModel(R.drawable.e));
        gretaList.add(new GreatOffersModel(R.drawable.a));
        gretaList.add(new GreatOffersModel(R.drawable.b));
        gretaList.add(new GreatOffersModel(R.drawable.c));
        adapterGreta= new AdapterOffers( gretaList,this);
        greatHorizontal.setAdapter(adapterGreta);
        banange.notifyDataSetChanged();
    }

    private void ini() {
        /////banner/////
        ben=(RecyclerView)findViewById(R.id.banner);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        ben.setLayoutManager(linearLayoutManager);

      banners= new ArrayList<>();
      banners.add(new BannerModel(R.drawable.e));
      banners.add(new BannerModel(R.drawable.a));
      banners.add(new BannerModel(R.drawable.b));
      banners.add(new BannerModel(R.drawable.c));
        banange= new AdapterBanner( banners,this);
        ben.setAdapter(banange);
        banange.notifyDataSetChanged();


    }


    private void showDia() {
        AlertDialog.Builder alert;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            alert= new AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog_Alert);
        }else {
            alert = new AlertDialog.Builder(this);
        }
        LayoutInflater inflater= getLayoutInflater();
        View view= inflater.inflate(R.layout.register,null);

        eme=view.findViewById(R.id.textView14);
        full=view.findViewById(R.id.textView13);
        mo=view.findViewById(R.id.textView19);
        pa=view.findViewById(R.id.textView20);
        own=view.findViewById(R.id.spinner);
        //int awu =Integer.parseInt(own.getText().toString());

//       int selectedId = radioGroup.getCheckedRadioButtonId();
//       radioButton = (RadioButton) view.findViewById(selectedId);
//        int user_value=pa.getText().toString().trim();



        Can=view.findViewById(R.id.button2);
        reg2=view.findViewById(R.id.button5);






        alert.setView(view);
        alert.setCancelable(false);

        reg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String user_full=full.getText().toString().trim();
                String user_mail=eme.getText().toString().trim();
                String user_mobile=mo.getText().toString().trim();
                String user_password=pa.getText().toString().trim();
                int user_type =Integer.parseInt(own.getText().toString().trim());
                //String user_type=own.toString(awu);

                if(TextUtils.isEmpty(user_full)){
                    full.setError("Full name is required");
                }
                else if(TextUtils.isEmpty(user_mail)){
                    eme.setError("Email is required");
                }
                else if(TextUtils.isEmpty(user_mobile)){
                    mo.setError("Mobile Number is required");
                }
                else if(TextUtils.isEmpty(user_password)) {
                    pa.setError("Password is required");
                }

//           else if(TextUtils.isEmpty(user_type)){
//             own.setError("Please write 2 in this box...");
//           }
                else{
                    ProgressDialog dialog=new ProgressDialog(GezakoActivity.this);
                    dialog.setTitle("Registering...");
                    dialog.setMessage("Please wait while we check you credentials...");
                    dialog.show();
                    dialog.setCanceledOnTouchOutside(false);

                    Call<Users> call= apiInterface.performRegistration(user_full,user_mail,user_mobile,user_password,user_type);
                    call.enqueue(new Callback<Users>() {
                        @Override
                        public void onResponse(Call<Users> call, Response<Users> response) {

                            if(response.body().getResponse().equals("Ok")){

                                user_id=response.body().getUserId();
                                user_typp=response.body().getUserTy();
                                user_namee=response.body().getUserName();
                                user_passs=response.body().getUserPass();
                                user_moo=response.body().getUserMobi();
                                user_emaill=response.body().getUserEmail();
                                user_about1=response.body().getUserAbout();
                                sharedPrefManager.createSession(user_id,user_namee,user_emaill,user_typp,user_moo,user_passs,user_about1);

                                if((user_typp.equals("3"))) {


                                    Intent intent= new Intent(GezakoActivity.this, DashboardActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    Animatoo.animateSwipeLeft(GezakoActivity.this);
                                    Toast.makeText(GezakoActivity.this,String.valueOf(response.body().getUserName()), Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(GezakoActivity.this, "Wrong UserType..........", Toast.LENGTH_SHORT).show();
                                }

                            }
                            else if(response.body().getResponse().equals("failed")){
                                Toast.makeText(GezakoActivity.this, "Something went wrong,Please try again....", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }

                            else if(response.body().getResponse().equals("already")){
                                Toast.makeText(GezakoActivity.this, "This Email already exists,Please try another....", Toast.LENGTH_SHORT).show();
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

        AlertDialog dialog=alert.create();
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.show();

        Can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


    }





    private void showDialog() {

        AlertDialog.Builder alert;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            alert= new AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog_Alert);
        }else {
            alert = new AlertDialog.Builder(this);
        }
        LayoutInflater inflater= getLayoutInflater();
        View view= inflater.inflate(R.layout.login,null);

        eme2=view.findViewById(R.id.textView13);
        pa2=view.findViewById(R.id.textView14);
        logo2=view.findViewById(R.id.button1);
        Cancel1=view.findViewById(R.id.button);

        alert.setView(view);
        alert.setCancelable(false);

        logo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email=eme2.getText().toString();
                String user_password=pa2.getText().toString();

                if(TextUtils.isEmpty(user_email)){
                    eme2.setError("Email is required");
                }
                else if(TextUtils.isEmpty(user_password)){
                    pa2.setError("Password is required");
                }
                else{
                    ProgressDialog dialog=new ProgressDialog(GezakoActivity.this);
                    dialog.setTitle("Logging in ...");
                    dialog.setMessage("Please wait while we check you credentials...");
                    dialog.show();
                    dialog.setCanceledOnTouchOutside(false);

                    Call<Users> call= apiInterface.performLogin(user_email,user_password);
                    call.enqueue(new Callback<Users>() {
                        @Override
                        public void onResponse(Call<Users> call, Response<Users> response) {

                            Users users=response.body();

                            if(response.body().getResponse().equals("owner")){


                                user_id=response.body().getUserId();
                                user_typp=response.body().getUserTy();
                                user_namee=response.body().getUserName();
                                user_passs=response.body().getUserPass();
                                user_moo=response.body().getUserMobi();
                                user_emaill=response.body().getUserEmail();
                                user_about1=response.body().getUserAbout();
                                sharedPrefManager.createSession(user_id,user_namee,user_emaill,user_typp,user_moo,user_passs,user_about1);

                                if((user_typp.equals("3"))) {
//
//                                             SharedPrefManager.getInstance(getActivity())
//                                                     .saveUser(users.getUserId());
                                    Intent intent= new Intent(GezakoActivity.this,DashboardActivity.class);

                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    Animatoo.animateSwipeLeft(GezakoActivity.this);
                                    Toast.makeText(GezakoActivity.this,String.valueOf(response.body().getUserName()), Toast.LENGTH_SHORT).show();



                                }else{
                                    Toast.makeText(GezakoActivity.this, "Wrong UserType..........", Toast.LENGTH_SHORT).show();
                                }

//                                         Bundle bundle = new Bundle();
//                                         bundle.putString("FullName",user_nameee); // Put anything what you want
//                                         OwnerHomeFragment fragment1 = new OwnerHomeFragment();
//                                         fragment1.setArguments(bundle);
//                                         getFragmentManager()
//                                                 .beginTransaction()
//                                                 .replace(R.id.fragmentContainer, fragment1)
//                                                 .commit();

                                dialog.dismiss();

                            }

                            else if(response.body().getResponse().equals("user")){

                                user_id=response.body().getUserId();

                                Toast.makeText(GezakoActivity.this, "Please Enter Correct User Details...", Toast.LENGTH_SHORT).show();

                                dialog.dismiss();

                            }

//
                            else if(response.body().getResponse().equals("no_account")){

                                Toast.makeText(GezakoActivity.this, "No Account found..", Toast.LENGTH_SHORT).show();
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

        AlertDialog dialog=alert.create();
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.show();

        Cancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    private void init() {

        rv=findViewById(R.id.pro);
        LinearLayoutManager linearpropertyManager= new LinearLayoutManager(this);
        linearpropertyManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(linearpropertyManager);

        property= new ArrayList<>();
        Call<Users> propertyCall =apiInterface.getProperties();
        propertyCall.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {

                property=response.body().getProperty();

                adapterProperty= new AdapterProperty(property,GezakoActivity.this);
                rv.setAdapter(adapterProperty);
                adapterProperty.notifyDataSetChanged();

            }



            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });

    }

    private List<PropertyModel>filter(List<PropertyModel>hi,String query){
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


    @Override
    public void onStart() {
        super.onStart();

        if (sharedPrefManager.isLogin()) {
            Intent intent = new Intent(GezakoActivity.this, DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }else{

        }
    }
}