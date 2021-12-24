package com.jether.wirentiuserapp.RetrofitApi;

public class People {


    public People() {

    }

    Integer ID;
    String FullName,UserType,MobileNumber,Email,Password;

    public People(Integer ID, String fullName, String userType, String mobileNumber, String email, String password) {
        this.ID = ID;
        FullName = fullName;
        UserType = userType;
        MobileNumber = mobileNumber;
        Email = email;
        Password = password;
    }

    public Integer getID() {
        return ID;
    }

    public String getFullName() {
        return FullName;
    }

    public String getUserType() {
        return UserType;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }
}
