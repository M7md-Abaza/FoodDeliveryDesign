package com.m7mdabaza.fooddelivery.ui.models;

public class PopularModel {
    String foodName, foodDescription;
    int imageURL;
    double rate;

    public PopularModel(int imageURL, String foodName, String foodDescription, double rate) {
        this.imageURL = imageURL;
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.rate = rate;
    }

    public int getImageURL() {
        return imageURL;
    }

    public void setImageURL(int imageURL) {
        this.imageURL = imageURL;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
