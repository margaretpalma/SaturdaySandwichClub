package com.saturdaysandwichshop.models;


public class Drinks extends ProductMain {


//size flavor price
//cherry, orange, grape
    private String drinkSize;
    private String drinkFlavor;

//constructor
    public Drinks(String drinkSize, String drinkFlavor, double drinkPrice) {
        super("Drink", drinkPrice);
        this.drinkSize = drinkSize;
        this.drinkFlavor = drinkFlavor;
    }
//getters and setters
    public String getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(String drinkSize) {
        this.drinkSize = drinkSize;
    }

    public String getDrinkFlavor() {
        return drinkFlavor;
    }

    public void setDrinkFlavor(String drinkFlavor) {
        this.drinkFlavor = drinkFlavor;
    }


//get price
    @Override
    public double getPrice(){
        return basePrice;
    }

    @Override
    public String getProductName(){
        return drinkSize + " " + drinkFlavor;
    }

//formatting
    @Override
    public String toString(){
        return "=== Drink Option ===\n" +
                "Size: " + drinkSize + "\n" + "Flavor: " + drinkFlavor;
    }
}