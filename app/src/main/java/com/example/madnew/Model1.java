package com.example.madnew;

public class Model1 {

    String Foodname;
    String Fooddetails;
    int FoodPhoto;


    public Model1(String foodname, String fooddetails, int foodPhoto) {
        this.Foodname = foodname;
        this.Fooddetails = fooddetails;
        this.FoodPhoto = foodPhoto;
    }


    public String getFoodname() {

        return Foodname;
    }

    public String getFooddetails() {
        return Fooddetails;
    }

    public int getFoodPhoto() {

        return FoodPhoto;
    }

}
