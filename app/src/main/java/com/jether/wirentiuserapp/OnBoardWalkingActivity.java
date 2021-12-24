package com.jether.wirentiuserapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class OnBoardWalkingActivity extends AppCompatActivity {

    private static final int NUM_PAGES=3;
    private ViewPager viewPager;
    private OnBoardWalkingActivity.ScreenSlidePageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window=getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_board_walking);

        viewPager=findViewById(R.id.pager);
        pageAdapter= new ScreenSlidePageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);
    }

    private class ScreenSlidePageAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    OnBoardFragment1 tab1= new OnBoardFragment1();
                    return tab1;

                case 1:
                    OnBoardFragment2 tab2= new OnBoardFragment2();
                    return tab2;

                case 2:
                    OnBoardFragment3 tab3= new OnBoardFragment3();
                    return tab3;

            }

            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}