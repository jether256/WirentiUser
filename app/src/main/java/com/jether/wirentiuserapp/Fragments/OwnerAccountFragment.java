package com.jether.wirentiuserapp.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.hitomi.cmlibrary.CircleMenu;

import com.jether.wirentiuserapp.BottomActivity;
import com.jether.wirentiuserapp.ChangePasswordActivity;
import com.jether.wirentiuserapp.EditProfileActivity;
import com.jether.wirentiuserapp.R;
import com.jether.wirentiuserapp.Sessions.SharedPrefManager;

public class OwnerAccountFragment extends Fragment {

    public OwnerAccountFragment() {
    }

    CircleMenu circleMenu;
    CardView emu,biri,satu,nya,tano;

    private View view;

    SharedPrefManager sharedPrefManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_owner_account, container, false);

        sharedPrefManager = new SharedPrefManager(getContext());


        emu=view.findViewById(R.id.linear1);
        biri=view.findViewById(R.id.linear2);

        tano=view.findViewById(R.id.linear5);


        emu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), EditProfileActivity.class);
                startActivity(intent);

            }
        });

        biri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), ChangePasswordActivity.class);
                startActivity(intent);
            }
        });




        tano.setOnClickListener(new View.OnClickListener() {
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

        return view;
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
