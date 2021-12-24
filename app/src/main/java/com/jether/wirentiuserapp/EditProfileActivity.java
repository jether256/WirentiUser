package com.jether.wirentiuserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.jether.wirentiuserapp.RetrofitApi.ApiClient;
import com.jether.wirentiuserapp.RetrofitApi.ApiInterface;
import com.jether.wirentiuserapp.RetrofitApi.Users;
import com.jether.wirentiuserapp.Sessions.SharedPrefManager;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

 public class EditProfileActivity extends AppCompatActivity {

     public static ApiInterface apiInterface;
     SharedPrefManager sharedPrefManager;

     EditText full,email,mobile,about;
     TextView user;
     Button save;


     String user_id;
     String user_typp;
     String user_moo;
     String user_namee;
     String user_emaill;
     String user_passs;
     String user_about1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sharedPrefManager= new SharedPrefManager(this);

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        full=findViewById(R.id.name22);
        email=findViewById(R.id.email);
        mobile=findViewById(R.id.phone);
        about=findViewById(R.id.message);
        user=findViewById(R.id.user);
        save=findViewById(R.id.request);


        HashMap<String, String> kojo=sharedPrefManager.getUserDetail();
        String name1=kojo.get(SharedPrefManager.NAME);
        String email1=kojo.get(SharedPrefManager.EMAIL);
        String mobile1=kojo.get(SharedPrefManager.MOBILE);
        String muntu=kojo.get(SharedPrefManager.ID);


        full.setText(name1);
        email.setText(email1);
        mobile.setText(mobile1);
        user.setText(muntu);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_full=full.getText().toString().trim();
                String user_mail=email.getText().toString().trim();
                String user_mobile=mobile.getText().toString().trim();
                String user_about=about.getText().toString().trim();
                String user_muntu=user.getText().toString().trim();

                if(TextUtils.isEmpty(user_about)){
                    about.setError("About me is required");
                }
                else{

                    ProgressDialog dialog=new ProgressDialog(EditProfileActivity.this);
                    dialog.setTitle("Updating...");
                    dialog.setMessage("Please wait while we update you credentials...");
                    dialog.show();
                    dialog.setCanceledOnTouchOutside(false);

                    Call<Users> call= apiInterface.updateUser(user_muntu,user_full,user_mail,user_mobile,user_about);
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

                                Toast.makeText(EditProfileActivity.this, "Updated......", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }


                             else if(response.body().getResponse().equals("failed")){
                                Toast.makeText(EditProfileActivity.this, "Something went wrong,Please try again....", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }



                        }

                        @Override
                        public void onFailure(Call<Users> call, Throwable t) {

                        }
                    });
                }
            }
        });

    }
}