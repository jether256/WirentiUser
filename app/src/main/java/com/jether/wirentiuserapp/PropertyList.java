package com.jether.wirentiuserapp;

public class PropertyList {

    private String TouristBnB;
    private String Rental;
    private String Hostel;


    public PropertyList(String touristBnB, String rental, String hostel) {
        TouristBnB = touristBnB;
        Rental = rental;
        Hostel = hostel;
    }

    public String getTouristBnB() {
        return TouristBnB;
    }

    public void setTouristBnB(String touristBnB) {
        TouristBnB = touristBnB;
    }

    public String getRental() {
        return Rental;
    }

    public void setRental(String rental) {
        Rental = rental;
    }

    public String getHostel() {
        return Hostel;
    }

    public void setHostel(String hostel) {
        Hostel = hostel;
    }

    @Override
    public String toString() {
        return "PropertyList{" +
                "TouristBnB='" + TouristBnB + '\'' +
                ", Rental='" + Rental + '\'' +
                ", Hostel='" + Hostel + '\'' +
                '}';
    }
}
