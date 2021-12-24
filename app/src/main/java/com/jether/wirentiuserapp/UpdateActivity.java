package com.jether.wirentiuserapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import org.jsoup.Jsoup;

import java.io.IOException;

public class UpdateActivity extends AppCompatActivity {

    String sCurrentt,sLatestt;
     TextView current,latest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        current=findViewById(R.id.current_version);
        latest=findViewById(R.id.latest_version);


         new GetLatestVersion().execute();

    }


    private  class GetLatestVersion extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                sLatestt = Jsoup
                        .connect("https://play.google.com/store/apps/details?id="
                                + getPackageName())
                        .timeout(30000)
                        .get()
                        .select("div.hAyfc:nth-child(4)>" +
                                "span:nth-child(2) > div:nth-child(1)" +
                                ">span:nth-child(1)")
                        .first()
                        .ownText();
            } catch (IOException e){
                e.printStackTrace();
            }

            return sLatestt;
        }

        @Override

        protected void onPostExecute(String s){

            //get current version
            sCurrentt= BuildConfig.VERSION_NAME;
            //set text
            current.setText(sCurrentt);
            //set latest
            latest.setText(sLatestt);


            if(sLatestt != null){
                //version convert to float
                float cVersion=Float.parseFloat(sCurrentt);
                float lVersion=Float.parseFloat(sLatestt);

                //check if latest version is greater than current version
                if(lVersion >cVersion){
                    createAlertDialog();
                }
            }



        }
    }

    private void createAlertDialog() {
        //initialize
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.app_name));
        builder.setMessage("Update Available");
        builder.setCancelable(false);


        //on positive
        builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?="+getPackageName())));
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
    }

}