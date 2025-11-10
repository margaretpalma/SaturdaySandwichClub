package com.saturdaysandwichshop.models;


public class Drinks extends ProductMain {


    //size flavor price
    private String drinkSize;
    private String drinkflavor;

    public Drinks(String productName, double basePrice, String drinkSize, String drinkflavor) {
        super(productName, basePrice);
        this.drinkSize = drinkSize;
        this.drinkflavor = drinkflavor;
    }


    @Override
    public double getPrice(){
        return basePrice;
    }
}
