package com.jether.wirentiuserapp.Model;


public class ImageSliderModel {

    int image;

    public ImageSliderModel(String galleryImage1) {

    }

    public ImageSliderModel(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
