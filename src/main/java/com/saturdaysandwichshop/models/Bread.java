package com.saturdaysandwichshop.models;

public class Bread {

//info about bread type
//white, wheat, rye, wrap

    private String breadType;
    private double breadPrice;

    public Bread(String breadType, double breadPrice) {
        this.breadType = breadType;
        this.breadPrice = breadPrice;
    }
//getters and setters
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

//toString formatting
    @Override
    public String toString() {
        return "Bread{" +
                "breadType='" + breadType + '\'' +
                ", breadPrice=" + breadPrice +
                '}';
    }
}
