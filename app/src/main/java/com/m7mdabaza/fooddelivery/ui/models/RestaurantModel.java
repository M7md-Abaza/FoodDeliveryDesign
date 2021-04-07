package com.m7mdabaza.fooddelivery.ui.models;

public class RestaurantModel {
    int imageUrl;
    String foodName, foodCountry, foodTime, foodPrice;
    double foodRate;

    public RestaurantModel(int imageUrl, String foodName, String foodCountry, String foodTime, String foodPrice, double foodRate) {
        this.imageUrl = imageUrl;
        this.foodName = foodName;
        this.foodCountry = foodCountry;
        this.foodTime = foodTime;
        this.foodPrice = foodPrice;
        this.foodRate = foodRate;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodCountry() {
        return foodCountry;
    }

    public void setFoodCountry(String foodCountry) {
        this.foodCountry = foodCountry;
    }

    public String getFoodTime() {
        return foodTime;
    }

    public void setFoodTime(String foodTime) {
        this.foodTime = foodTime;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public double getFoodRate() {
        return foodRate;
    }

    public void setFoodRate(double foodRate) {
        this.foodRate = foodRate;
    }
}
