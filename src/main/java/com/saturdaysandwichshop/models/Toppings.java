package com.saturdaysandwichshop.models;

public class Toppings {

    //toppings
    //meats, cheeses, regular toppings

    private String toppingName;
    private boolean premiumTopping;
    private boolean extraPortion;
    private double price;

    public Toppings(String toppingName, boolean premiumTopping,
                    boolean extraPortion, double price) {
        this.toppingName = toppingName;
        this.premiumTopping = premiumTopping;
        this.extraPortion = extraPortion;
        this.price = price;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public boolean isPremiumTopping() {
        return premiumTopping;
    }

    public void setPremiumTopping(boolean premiumTopping) {
        this.premiumTopping = premiumTopping;
    }

    public boolean isExtraPortion() {
        return extraPortion;
    }

    public void setExtraPortion(boolean extraPortion) {
        this.extraPortion = extraPortion;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
