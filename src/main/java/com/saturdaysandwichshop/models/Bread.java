package com.saturdaysandwichshop.models;

public class Bread {


    //white, wheat, rye, wrap
    private String breadType;
    private double breadPrice;

    public Bread(String breadType, double breadPrice) {
        this.breadType = breadType;
        this.breadPrice = breadPrice;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public double getBreadPrice() {
        return breadPrice;
    }

    public void setBreadPrice(double breadPrice) {
        this.breadPrice = breadPrice;
    }
}
