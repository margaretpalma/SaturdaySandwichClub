package com.saturdaysandwichshop.models;


public class Drinks {


    //size flavor price
    private String drinkSize;
    private String drinkflavor;
    private double drinkPrice;




    public Drinks(String drinkSize, String drinkflavor, double drinkPrice) {
        this.drinkSize = drinkSize;
        this.drinkflavor = drinkflavor;
        this.drinkPrice = drinkPrice;
    }

    public String getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(String drinkSize) {
        this.drinkSize = drinkSize;
    }

    public String getDrinkflavor() {
        return drinkflavor;
    }

    public void setDrinkflavor(String drinkflavor) {
        this.drinkflavor = drinkflavor;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(double drinkPrice) {
        this.drinkPrice = drinkPrice;
    }
}
