package com.saturdaysandwichshop.models;

public class Chips {

    private String chipType;
    private double chipPrice;

    public Chips(String chipType, double chipPrice) {
        this.chipType = chipType;
        this.chipPrice = chipPrice;
    }

    public String getChipType() {
        return chipType;
    }

    public void setChipType(String chipType) {
        this.chipType = chipType;
    }

    public double getChipPrice() {
        return chipPrice;
    }

    public void setChipPrice(double chipPrice) {
        this.chipPrice = chipPrice;
    }
}