package com.jether.wirentiuserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.jether.wirentiuserapp.RetrofitApi.ApiClient;
import com.jether.wirentiuserapp.RetrofitApi.ApiInterface;
import com.jether.wirentiuserapp.RetrofitApi.Users;
import com.jether.wirentiuserapp.Sessions.SharedPrefManager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPropertyActivity extends AppCompatActivity {
    SharedPrefManager sharedPrefManager;
    TextView user;
    public static ApiInterface apiInterface;
    Button add;
    EditText title,desc,loca,floors,bedrooms,bathrooms,garages,area,size,rentPrice,before,after,address,statuseee;
    CheckBox center,balcony,pet,berb,fire,kit,storage,dryer,heating,pool,laundry,sauna,elevator,dish,emergency,gy;

    CircleImageView img1,img2,img3,img4,img5,img6;

    FloatingActionButton fab1,fab2,fab3,fab4,fab5,fab6;

    String mediaPath;
    String[] mediaColumns={MediaStore.Video.Media._ID};

Spinner type,country,state,city,status;
int current_Item=0;
    private Bitmap bitmap1,bitmap2,bitmap3,bitmap4,bitmap5,bitmap6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sharedPrefManager= new SharedPrefManager(this);
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        //spinner

        img1=findViewById(R.id.picture1);
        img2=findViewById(R.id.picture2);
        img3=findViewById(R.id.picture3);
        img4=findViewById(R.id.picture4);
        img5=findViewById(R.id.picture5);
        img6=findViewById(R.id.picture6);

        type=(Spinner)findViewById(R.id.type);
        status=findViewById(R.id.status);
        country=findViewById(R.id.country256);
        state=findViewById(R.id.state256);
        city=findViewById(R.id.city256);

        fab1=findViewById(R.id.fabChoosePic1);
        fab2=findViewById(R.id.fabChoosePic);
        fab3=findViewById(R.id.fabChoosePic3);
        fab4=findViewById(R.id.fabChoosePic4);
        fab5=findViewById(R.id.fabChoosePic5);
        fab6=findViewById(R.id.fabChoosePic6);


        add=findViewById(R.id.request1);
        user=findViewById(R.id.userId);
        HashMap<String, String> kojo=sharedPrefManager.getUserDetail();
        String kajoee=kojo.get(SharedPrefManager.ID);
        user.setText(kajoee);

        //text
        title=findViewById(R.id.name22);
        desc=findViewById(R.id.email);
        loca=findViewById(R.id.location);
        floors  =findViewById(R.id.floors);
        bedrooms =findViewById(R.id.bedrooms);
        bathrooms=findViewById(R.id.bath);
        garages=findViewById(R.id.garages);
        area=findViewById(R.id.area);
        size=findViewById(R.id.size);
        rentPrice=findViewById(R.id.rent);
        before=findViewById(R.id.before);
        after=findViewById(R.id.after);
        address=findViewById(R.id.address333);





        //checkbox
        center=findViewById(R.id.centercooling);
        balcony=findViewById(R.id.balcony);
        pet=findViewById(R.id.pet);
        berb=findViewById(R.id.barbeque);
        fire=findViewById(R.id.firealarm);
        kit=findViewById(R.id.modernkitchen);
        storage=findViewById(R.id.storage);
        dryer=findViewById(R.id.Dryer);
        heating=findViewById(R.id.heating);
        pool=findViewById(R.id.pool);
        laundry=findViewById(R.id.laundry);
        sauna=findViewById(R.id.sauna);
        gy=findViewById(R.id.gymn);

        elevator=findViewById(R.id.elevator);
        dish=findViewById(R.id.dishwasher);
       emergency=findViewById(R.id.exit);

       add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String user_i=user.getText().toString().trim();
               String pro_ti=title.getText().toString().trim();
               String pro_desc=desc.getText().toString().trim();
               String pro_loc=loca.getText().toString().trim();
               String pro_floo=floors.getText().toString().trim();
               String pro_bedro=bedrooms.getText().toString().trim();
               String pro_bathss=bathrooms.getText().toString().trim();
               String pro_gara=garages.getText().toString().trim();
               String pro_areaa=area.getText().toString().trim();
               String pro_sizes=size.getText().toString().trim();
               String pro_lenti=rentPrice.getText().toString().trim();
               String pro_befo=before.getText().toString().trim();
               String pro_afte=after.getText().toString().trim();
               String pro_add=address.getText().toString().trim();

               String pro_city=city.getSelectedItem().toString();
               String pro_type=type.getSelectedItem().toString();
               String pro_country=country.getSelectedItem().toString();
               String pro_state=state.getSelectedItem().toString();
               String pro_status=status.getSelectedItem().toString();

               String imagea=getStringImage(bitmap1);
               String imageb=getStringImage(bitmap2);
               String imagec=getStringImage(bitmap3);
               String imaged=getStringImage(bitmap4);
               String imagee=getStringImage(bitmap5);
               String imagef=getStringImage(bitmap6);




               Boolean pro_center =center.isChecked();
               Boolean pro_balcony=balcony.isChecked();
               Boolean pro_pet=pet.isChecked();
               Boolean pro_berb=berb.isChecked();
               Boolean pro_fire=fire.isChecked();
               Boolean pro_kit=kit.isChecked();
               Boolean pro_storage=storage.isChecked();
               Boolean pro_dryer=dryer.isChecked();
               Boolean pro_heating=heating.isChecked();
               Boolean pro_pool=pool.isChecked();
               Boolean pro_laundry=laundry.isChecked();
               Boolean pro_sauna=sauna.isChecked();
               Boolean pro_gym=gy.isChecked();

               Boolean pro_elevator=elevator.isChecked();
               Boolean pro_dish=dish.isChecked();
               Boolean pro_emr=emergency.isChecked();

//                String pro_center=String.valueOf(center.isChecked());
//                String pro_balcony=String.valueOf(balcony.isChecked());
//                String pro_pet=String.valueOf(pet.isChecked());
//                String pro_berb=String.valueOf(berb.isChecked());
//                String pro_fire=String.valueOf(fire.isChecked());
//                String pro_kit=String.valueOf(kit.isChecked());
//                String pro_dryer=String.valueOf(dryer.isChecked());
//                String pro_heating=String.valueOf(heating.isChecked());
//                String pro_pool=String.valueOf(pool.isChecked());
//                String pro_laundry=String.valueOf(laundry.isChecked());
//                String pro_sauna=String.valueOf(sauna.isChecked());
//                String pro_gymn=String.valueOf(gy.isChecked());
//                String pro_elevator=String.valueOf(elevator.isChecked());
//                String pro_dish=String.valueOf(dish.isChecked());
//                String pro_emr=String.valueOf(emergency.isChecked());
//                String pro_storage=String.valueOf(storage.isChecked());




               if(TextUtils.isEmpty(pro_ti)){
                   title.setError("Property Title is required");
               }
               else if(TextUtils.isEmpty(pro_desc)){
                   desc.setError("Property decsription is required");
               }
               else if(TextUtils.isEmpty(pro_loc)){
                   loca.setError("Property Location is required");
               }
               else if(TextUtils.isEmpty(pro_floo)) {
                   floors.setError("Floors is required");
               }

               else if(TextUtils.isEmpty(pro_bedro)){
                   bedrooms.setError("Bedrooms is required");
               }
               else if(TextUtils.isEmpty(pro_bathss)){
                   bathrooms.setError("Property Location is required");
               }
               else if(TextUtils.isEmpty(pro_gara)) {
                   garages.setError("Garages is required");
               }

               else if(TextUtils.isEmpty(pro_areaa)){
                   area.setError("Area is required");
               }
               else if(TextUtils.isEmpty(pro_sizes)){
                   size.setError("Size is required");
               }
               else if(TextUtils.isEmpty(pro_lenti)) {
                   rentPrice.setError("Rentor Price is required");
               }

               else if(TextUtils.isEmpty(pro_befo)){
                   before.setError("Price is required");
               }
               else if(TextUtils.isEmpty(pro_afte)){
                   after.setError("Property Location is required");
               }
               else if(TextUtils.isEmpty(pro_add)) {
                   address.setError("Floors is required");
               }




               else{
                   ProgressDialog dialog=new ProgressDialog(AddPropertyActivity.this);
                   dialog.setTitle("Adding Property...");
                   dialog.setMessage("Please wait while we add you property...");
                   dialog.show();
                   dialog.setCanceledOnTouchOutside(false);


                   Call<Users> call= apiInterface.addProperty(user_i,pro_ti,pro_desc,pro_type,pro_status,pro_loc,pro_bedro,pro_bathss,pro_floo,pro_gara,pro_areaa,pro_sizes,pro_lenti,pro_befo,pro_afte,
                           pro_center,pro_balcony,pro_pet,pro_berb,pro_fire,pro_kit,pro_storage,pro_dryer,pro_pool,pro_heating,pro_laundry,pro_sauna,pro_gym,pro_elevator,pro_dish,pro_emr,
                           imagea,imageb,imagec,imaged,imagee,imagef,
                           pro_add,pro_country,pro_city,pro_state);
                   call.enqueue(new Callback<Users>() {
                       @Override
                       public void onResponse(Call<Users> call, Response<Users> response) {

                           if(response.body().getResponse().equals("Ok")){



                                   Toast.makeText(AddPropertyActivity.this,"Property Added", Toast.LENGTH_SHORT).show();

                            dialog.dismiss();
                           }
                           else if(response.body().getResponse().equals("failed")){
                               Toast.makeText(AddPropertyActivity.this, "Something went wrong,Please try again....", Toast.LENGTH_SHORT).show();
                               dialog.dismiss();
                           }

                           else if(response.body().getResponse().equals("already")){
                               Toast.makeText(AddPropertyActivity.this, "This Email already exists,Please try another....", Toast.LENGTH_SHORT).show();
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

       fab1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               chooseFile();
           }



       });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFile1();
            }



        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFile2();
            }



        });

        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFile3();
            }



        });

        fab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFile4();
            }



        });

        fab6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFile5();
            }



        });

        populateStatus();
        populateType();
        populateCountry();
        populateState();
        populateCity();

    }



    private void populateState() {
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Northern");
        adapter.add("Western");
        adapter.add("Eastern");
        adapter.add("Central");

        state.setAdapter(adapter);
        state.setSelection(0);
    }

    private void populateCity() {
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Gulu");
        adapter.add("Arua");
        adapter.add("Abim");
        adapter.add("Adjumani");
        adapter.add("Agago");
        adapter.add("Alebtong");
        adapter.add("amolatar");
        adapter.add("Amudat");
        adapter.add("Amuru");
        adapter.add("Apac");
        adapter.add("Dokolo");
        adapter.add("Kabong");
        adapter.add("Kitgum");
        adapter.add("Koboko");
        adapter.add("Kole");
        adapter.add("Kotido");
        adapter.add("Lamwo");
        adapter.add("Lira");
        adapter.add("Maracha");
        adapter.add("Moroto");
        adapter.add("Nakapiripirit");
        adapter.add("Moyo");
        adapter.add("Napak");
        adapter.add("Nebbi");
        adapter.add("Nwoya");
        adapter.add("Otuke");
        adapter.add("Oyam");
        adapter.add("Pader");
        adapter.add("Yumbe");
        adapter.add("Zombo");
        adapter.add("Buhwej");
        adapter.add("Buliisa");
        adapter.add("Bundibugyo");
        adapter.add("Bushenyi");
        adapter.add("Hoima");
        adapter.add("Isingiro");
        adapter.add("Ibanda");
        adapter.add("Kabale");
        adapter.add("Kabarole");
        adapter.add("Kamwenge");
        adapter.add("Kanungu");
        adapter.add("Kasese");
        adapter.add("Kibaale");
        adapter.add("Kiruhura");
        adapter.add("Kiryandongo");
        adapter.add("Kisoro");
        adapter.add("Kyegwegwa");
        adapter.add("Masindi");
        adapter.add("Mitooma");
        adapter.add("Ntoroko");
        adapter.add("Ntungamo");
        adapter.add("Rubiriz");
        adapter.add("Rukungiri");
        adapter.add("Sheema");
        adapter.add("Mbale");
        adapter.add("Soroti");
        adapter.add("Amuria");
        adapter.add("Budaka");
        adapter.add("Bugiri");
        adapter.add("Bukedea");
        adapter.add("Bukwa");
        adapter.add("Bulamburi");
        adapter.add("Busia");
        adapter.add("Butaleja");
        adapter.add("Buyende");
        adapter.add("Iganga");
        adapter.add("Jinja");
        adapter.add("Kaberamaido");
        adapter.add("Kamuli");
        adapter.add("Kapchorwa");
        adapter.add("Katakwi");
        adapter.add("Kibuku");
        adapter.add("Kumi");
        adapter.add("Kweni");
        adapter.add("Luuka");
        adapter.add("Manafwa");
        adapter.add("Mayuge");
        adapter.add("Mbale");
        adapter.add("Namayingo");
        adapter.add("Namutumba");
        adapter.add("Ngora");
        adapter.add("Pallisa");
        adapter.add("Serere");
        adapter.add("Tororo");
        adapter.add("Kampala");
        adapter.add("Masaka");
        adapter.add("Mukon");
        adapter.add("Rakai");
        adapter.add("Kalangala");
        adapter.add("Buikwe");
        adapter.add("Bukomansimbi");
        adapter.add("Butambala");
        adapter.add("Buvuma");
        adapter.add("Gomba");
        adapter.add("Kalungu");
        adapter.add("Kayunga");
        adapter.add("Kiboga");
        adapter.add("Kyankwanzi");
        adapter.add("Luweero");
        adapter.add("Lwengo");
        adapter.add("Lyantonde");
        adapter.add("Mityana");
        adapter.add("Mpigi");
        adapter.add("Mubende");
        adapter.add("Mbarara");
        adapter.add("Nakaseke");
        adapter.add("Nakasongola");
        adapter.add("Sembabule");
        adapter.add("Wakiso");


        city.setAdapter(adapter);
        city.setSelection(0);

    }

    private void populateCountry() {
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Uganda");

        country.setAdapter(adapter);
        country.setSelection(0);
    }

    private void populateType() {
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Apartments");
        adapter.add("Houses");
        adapter.add("Offices");
        adapter.add("Villas");
        adapter.add("Hostels");


        type.setAdapter(adapter);
        type.setSelection(0);

    }

    private void populateStatus() {
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Rental");
        adapter.add("Hostel");
        adapter.add("Tousrist BnB");


        status.setAdapter(adapter);
        status.setSelection(0);
    }


    private void chooseFile() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
    }

    private void chooseFile1() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 2);
    }

    private void chooseFile2() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 3);
    }

    private void chooseFile3() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 4);
    }

    private void chooseFile4() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 5);
    }

    private void chooseFile5() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 6);
    }


    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        //bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);





        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {

                bitmap1 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                img1.setImageBitmap(bitmap1);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {

                bitmap2 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                img2.setImageBitmap(bitmap2);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        else if (requestCode == 3 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {

                bitmap3 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                img3.setImageBitmap(bitmap3);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if (requestCode == 4 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {

                bitmap4 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                img4.setImageBitmap(bitmap4);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if (requestCode == 5 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {

                bitmap5 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                img5.setImageBitmap(bitmap5);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if (requestCode == 6 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {

                bitmap6 = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                img6.setImageBitmap(bitmap6);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


    @Override
    public void onStart() {
        super.onStart();

        if (!sharedPrefManager.isLogin()) {

            sharedPrefManager.editor.clear();
            sharedPrefManager.editor.commit();

            Intent intent = new Intent(AddPropertyActivity.this,BottomActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }else{

        }
    }


}