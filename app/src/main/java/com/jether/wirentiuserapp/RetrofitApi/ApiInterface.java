package com.jether.wirentiuserapp.RetrofitApi;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/registration.php")
    Call<Users> performRegistration(
            @Query("FullName") String user_name,
            @Query("Email") String user_email,
            @Query("MobileNumber") String user_mobile,
            @Query("Password") String user_pass,
            @Query("UserType") int user_type
    );

    @GET("api/upDatePassword.php")
    Call<Users> updatePassword(
            @Query("ID") String user_id,
            @Query("Password") String user_pass

    );


    @GET("api/updateUser.php")
    Call<Users> updateUser(
            @Query("ID") String user_id,
            @Query("FullName") String user_name,
            @Query("Email") String user_email,
            @Query("MobileNumber") String user_mobile,
            @Query("Aboutme") String user_about

    );

    @GET("api/login.php")
    Call<Users> performLogin(
            @Query("Email") String user_email,
            @Query("Password") String user_pass

    );

    @POST("api/loadrequestInfo.php")
    Call<Users>requestKulaba(
            @Field("FullName") String user_name,
            @Field("Email") String user_email,
            @Field("MobileNumber") String user_mobile,
            @Field("Message") String user_message
            );

    @GET("api/loadrequestInfo.php")
    Call<Users> requestShowing(
            @Query("PropertyID") String pro_id,
            @Query("FullName") String user_name,
            @Query("Email") String user_email,
            @Query("MobileNumber") String user_mobile,
            @Query("Message") String user_mess

    );

    @GET("api/addProperty.php")
    Call<Users>addProperty(
            @Query("UserID") String user_iid,
            @Query("PropertyTitle") String pro_title,
            @Query("PropertDescription") String pro_dec,
            @Query("Type") String pro_type,
            @Query("Status") String pro_status,
            @Query("Location") String pro_location,
            @Query("Bedrooms") String pro_bed,
            @Query("Bathrooms") String pro_bath,
            @Query("Floors") String pro_floor,
            @Query("Garages") String pro_garage,
            @Query("Area") String pro_area,
            @Query("Size") String pro_size,
            @Query("RentorsalePrice") String pro_resale,
            @Query("BeforePriceLabel") String pro_before,
            @Query("AfterPriceLabel") String pro_after,
            @Query("CenterCooling") Boolean pro_center,
            @Query("Balcony") Boolean pro_balcony,
            @Query("PetFriendly") Boolean pro_pet,
            @Query("Barbeque") Boolean pro_barba,
            @Query("FireAlarm") Boolean pro_fire,
            @Query("ModernKitchen") Boolean pro_kitc,
            @Query("Storage") Boolean pro_storage,
            @Query("Dryer") Boolean pro_dryer,
            @Query("Heating") Boolean pro_heating,
            @Query("Pool") Boolean pro_pool,
            @Query("Laundry") Boolean pro_laundry,
            @Query("Sauna") Boolean pro_sauna,
            @Query("Elevator") Boolean pro_elevator,
            @Query("Gym") Boolean pro_gymn,
            @Query("Dishwasher") Boolean pro_dish,
            @Query("EmergencyExit") Boolean pro_exit,
            @Query("FeaturedImage") String pro_featured,
            @Query("GalleryImage1") String pro_gal1,
            @Query("GalleryImage2") String pro_gal2,
            @Query("GalleryImage3") String pro_gal3,
            @Query("GalleryImage4") String pro_gal4,
            @Query("GalleryImage5") String pro_gal5,
            @Query("Address") String pro_address,
            @Query("Country") String pro_country,
            @Query("City") String pro_city,
            @Query("State") String pro_state

    );

    @GET("api/insertreview.php")
    Call<Users> insertReview(
//            @Query("UserId") String user_id,
//            @Query("PropertyId") String pro_id,
            @Query("UserRemark") String user_remark


    );


    @GET("api/property.php")
   Call<Users> getProperties();

    @GET("api/myproperties.php")
    Call<Users> getMyProperties();

    @GET("api/propertytype.php")
    Call<Users> getPropertyType();


    // @GET("api/state.php")
    //Call<Users> getProperties (@Query("key") String keyword
    //);



}
