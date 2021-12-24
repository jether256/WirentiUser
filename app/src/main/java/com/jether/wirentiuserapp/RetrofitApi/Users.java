package com.jether.wirentiuserapp.RetrofitApi;

import com.google.gson.annotations.SerializedName;
import com.jether.wirentiuserapp.Model.ModelPropertyType;
import com.jether.wirentiuserapp.Model.MyPropertyModel;
import com.jether.wirentiuserapp.Model.PropertyModel;


import java.util.ArrayList;

public class Users {


    @SerializedName("response")
    private String Response;

    @SerializedName("ID")
    private String UserId;

    @SerializedName("UserType")
    private String UserTy;

    @SerializedName("FullName")
    private String UserName;

    @SerializedName("Email")
    private String UserEmail;

    @SerializedName("MobileNumber")
    private String UserMobi;

    @SerializedName("Password")
    private String UserPass;

    @SerializedName("Aboutme")
    private String UserAbout;





    @SerializedName("properties")
    private ArrayList<PropertyModel> property;


    @SerializedName("MyProperties")
    private ArrayList<MyPropertyModel> propertyMine;



    @SerializedName("tblpropertytype")
    private ArrayList<ModelPropertyType> propertType;

    public String getResponse() {
        return Response;
    }

    public String getUserId() {
        return UserId;
    }

    public String getUserTy() {
        return UserTy;
    }

    public String getUserName() {
        return UserName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public String getUserMobi() {
        return UserMobi;
    }

    public String getUserPass() {
        return UserPass;
    }

    public String getUserAbout() {
        return UserAbout;
    }

    public ArrayList<PropertyModel> getProperty() {
        return property;
    }

    public ArrayList<MyPropertyModel> getPropertyMine() {
        return propertyMine;
    }

    public ArrayList<ModelPropertyType> getPropertType() {
        return propertType;
    }
}
