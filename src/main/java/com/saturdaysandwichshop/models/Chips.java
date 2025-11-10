package com.saturdaysandwichshop.models;


public class Chips extends ProductMain {

    //Doritos, Lays, Sunchips

    private String chipType;
//constructor
    public Chips(String chipType) {
        super("Chips", 0.0);
        this.chipType = chipType;
    }
//getters and setters
    public String getChipType() {
        return chipType;

    }
    public void setChipType(String chipType) {
        this.chipType = chipType;
    }
//gets price
    @Override
    public double getPrice(){
        return basePrice;
    }
//formatting
    @Override
    public String toString(){
        return String.format(chipType + "Chips $" + basePrice);
    }
}