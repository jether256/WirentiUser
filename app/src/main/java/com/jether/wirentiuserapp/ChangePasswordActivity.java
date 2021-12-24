package com.jether.wirentiuserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.jether.wirentiuserapp.RetrofitApi.ApiClient;
import com.jether.wirentiuserapp.RetrofitApi.ApiInterface;
import com.jether.wirentiuserapp.RetrofitApi.Users;
import com.jether.wirentiuserapp.Sessions.SharedPrefManager;
;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordActivity extends AppCompatActivity {
    private long backpressed;
    SharedPrefManager sharedPrefManager;
    public static ApiInterface apiInterface;
    EditText currnet,newP,confirm1;
    Button save;
    TextView user;
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
        setContentView(R.layout.activity_change_password);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sharedPrefManager = new SharedPrefManager(this);


        currnet=findViewById(R.id.name22);
        newP=findViewById(R.id.email);
        confirm1=findViewById(R.id.phone);
        save=findViewById(R.id.request);
        user=findViewById(R.id.user);

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        HashMap<String, String> kojo=sharedPrefManager.getUserDetail();
        String name1=kojo.get(SharedPrefManager.PASSWORD);
        String muntu=kojo.get(SharedPrefManager.ID);

        currnet.setText(name1);
        user.setText(muntu);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String current=currnet.getText().toString().trim();
                String newPaso=newP.getText().toString().trim();
                String confirm=confirm1.getText().toString().trim();
                String iddd=user.getText().toString().trim();

                if(TextUtils.isEmpty(newPaso)){
                    newP.setError("New Password is required");
                }

                else if(TextUtils.isEmpty(newPaso)){
                    newP.setError("Confirm Password is required");
                }
                else{

                    ProgressDialog dialog=new ProgressDialog(ChangePasswordActivity.this);
                    dialog.setTitle("Updating Password");
                    dialog.setMessage("Please wait while we update you Password...");
                    dialog.show();
                    dialog.setCanceledOnTouchOutside(false);

                    Call<Users> call= apiInterface.updatePassword(iddd,confirm);
                    call.enqueue(new Callback<Users>() {
                        @Override
                        public void onResponse(Call<Users> call, Response<Users> response) {

                            if(response.body().getResponse().equals("Ok")){
//                                user_id=response.body().getUserId();
//                                user_typp=response.body().getUserTy();
//                                user_namee=response.body().getUserName();
//                                user_passs=response.body().getUserPass();
//                                user_moo=response.body().getUserMobi();
//                                user_emaill=response.body().getUserEmail();
//                                user_about1=response.body().getUserAbout();
//                                sharedPrefManager.createSession(user_id,user_namee,user_emaill,user_typp,user_moo,user_passs,user_about1);

                                Toast.makeText(ChangePasswordActivity.this, "Password Updated......", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }


                            else if(response.body().getResponse().equals("failed")){
                                Toast.makeText(ChangePasswordActivity.this, "Something went wrong,Please try again....", Toast.LENGTH_SHORT).show();
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


    @Override
    protected void onStart() {

        super.onStart();

        if(!sharedPrefManager.isLogin()){
          Intent intent= new Intent(ChangePasswordActivity.this,BottomActivity.class);
           startActivity(intent);
           finish();
            Animatoo.animateSwipeLeft(this);
      }else{

        }
    }
}