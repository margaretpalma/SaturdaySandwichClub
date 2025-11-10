package com.saturdaysandwichshop.models;

//info about bread type

public class Bread extends ProductMain {

//white, wheat, rye, wrap



    private String breadType;



//constructor - super
    public Bread(String breadType, double breadPrice) {
        super(breadType, breadPrice);
        this.breadType = breadType;
    }
//getters and setters
    public String getBreadType() {
        return breadType;
    }
    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

//override
    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public String toString(){
    return breadType + "Bread $" + basePrice + "");
    }
}

