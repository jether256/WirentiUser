package com.jether.wirentiuserapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jether.wirentiuserapp.Fragments.OwnerAboutUsFragment;
import com.jether.wirentiuserapp.Fragments.OwnerAccountFragment;
import com.jether.wirentiuserapp.Fragments.OwnerContactUsFragment;
import com.jether.wirentiuserapp.Fragments.OwnerHomeFragment;
import com.jether.wirentiuserapp.Fragments.OwnerPrivacyFragment;
import com.jether.wirentiuserapp.RetrofitApi.ApiClient;
import com.jether.wirentiuserapp.RetrofitApi.ApiInterface;
import com.jether.wirentiuserapp.Sessions.SharedPrefManager;

public class DashboardActivity extends AppCompatActivity {

    BottomNavigationView navigationView;

    SharedPrefManager sharedPrefManager;

    String user_namee;

    public static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        sharedPrefManager = new SharedPrefManager(this);
//
//

//         user_namee=getIntent().getStringExtra("FullName");
//
//        Bundle bundle=new Bundle();
//        bundle.putString("FullName", user_namee);
//        //set Fragmentclass Arguments
//        OwnerHomeFragment fragobj=new OwnerHomeFragment();
//        fragobj.setArguments(bundle);

        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(selectedListener);

        //home fragment default on start



        OwnerHomeFragment fragment1 = new OwnerHomeFragment();
        FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
        ft1.replace(R.id.fragmentContainer, fragment1, "");
        ft1.commit();
        //home fragment default on start
    }


    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    // handle item clicks

                    switch (item.getItemId()) {
                        case R.id.home:

                            OwnerHomeFragment fragment1 = new OwnerHomeFragment();
                            FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                            ft1.replace(R.id.fragmentContainer, fragment1, "");
                            ft1.commit();
                            return true;



                        case R.id.my_acc:

                            OwnerAccountFragment fragment2 = new OwnerAccountFragment();
                            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                            ft2.replace(R.id.fragmentContainer, fragment2, "");
                            ft2.commit();
                            return true;

                        case R.id.contact:

                            OwnerContactUsFragment fragment3 = new OwnerContactUsFragment();
                            FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                            ft3.replace(R.id.fragmentContainer, fragment3, "");
                            ft3.commit();
                            return true;

                        case R.id.about:

                            OwnerAboutUsFragment fragment4 = new OwnerAboutUsFragment();
                            FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                            ft4.replace(R.id.fragmentContainer, fragment4, "");
                            ft4.commit();
                            return true;



                        case R.id.privacy:

                            OwnerPrivacyFragment fragment5 = new OwnerPrivacyFragment();
                            FragmentTransaction ft5 = getSupportFragmentManager().beginTransaction();
                            ft5.replace(R.id.fragmentContainer, fragment5, "");
                            ft5.commit();
                            return true;


                    }
                    return false;
                }
            };

//    @Override
//    protected void onStart() {
//        super.onStart();
//        if (!sharedPrefManager.isLogin()) {
//            Intent intent = new Intent(DashboardActivity.this,BottomActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(intent);
//        }else{
//
//        }
//    }
}