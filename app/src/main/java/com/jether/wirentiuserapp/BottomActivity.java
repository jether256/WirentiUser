package com.jether.wirentiuserapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jether.wirentiuserapp.Fragments.AboutUsFragment;
import com.jether.wirentiuserapp.Fragments.ContactUsFragmnet;
import com.jether.wirentiuserapp.Fragments.HomeFragment;
import com.jether.wirentiuserapp.Fragments.PrivacyFragment;
import com.jether.wirentiuserapp.Sessions.SharedPrefManager;


public class BottomActivity extends AppCompatActivity {


    BottomNavigationView navigationView;

    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        sharedPrefManager = new SharedPrefManager(this);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(selectedListener);




        //home fragment default on start

        HomeFragment fragment1 = new HomeFragment();
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

                            HomeFragment fragment1 = new HomeFragment();
                            FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                            ft1.replace(R.id.fragmentContainer, fragment1, "");
                            ft1.commit();
                            return true;

                        case R.id.contact:

                            ContactUsFragmnet fragment2 = new ContactUsFragmnet();
                            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                            ft2.replace(R.id.fragmentContainer, fragment2, "");
                            ft2.commit();
                            return true;

                        case R.id.about:

                            AboutUsFragment fragment3 = new AboutUsFragment();
                            FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                            ft3.replace(R.id.fragmentContainer, fragment3, "");
                            ft3.commit();
                            return true;


                        case R.id.privacy:

                            PrivacyFragment fragment4 = new PrivacyFragment();
                            FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                            ft4.replace(R.id.fragmentContainer, fragment4, "");
                            ft4.commit();
                            return true;


                    }
                    return false;
                }
            };


    @Override
    protected void onStart() {
        super.onStart();
        if (sharedPrefManager.isLogin()) {
            Intent intent = new Intent(BottomActivity.this,DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }else{

        }
    }
}