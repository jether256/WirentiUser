package com.jether.wirentiuserapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.jether.wirentiuserapp.R;


public class PrivacyFragment extends Fragment {
    public PrivacyFragment() {
    }


    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_policy, container, false);


        return view;
    }
}
