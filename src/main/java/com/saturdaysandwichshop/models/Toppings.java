package com.saturdaysandwichshop.models;

public class Toppings {

    //toppings - premium or extra toppings
    //meats, cheeses, regular toppings

    private String toppingName;
    private boolean premiumTopping;
    private boolean extraPortion;
    private double toppingPrice;

    //constructor
    public Toppings(String toppingName, boolean premiumTopping,
                    boolean extraPortion, double toppingPrice) {
        this.toppingName = toppingName;
        this.premiumTopping = premiumTopping;
        this.extraPortion = extraPortion;
        this.toppingPrice = toppingPrice;
    }

    //getters and setters
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
        return toppingPrice;
    }
    public void setPrice(double price) {
        this.toppingPrice = price;
    }


    //to string
    @Override
    public String toString() {
        //ternary opterator - if//else
        //if isPremiumTopping is true return premium, if its not return regular

        String type = premiumTopping ? "Premium Topping" : "Regular Topping";
        String extra = extraPortion ? "(Extra Portion)" : "";
        return String.format(toppingName,  extraPortion, toppingName, toppingPrice);
    }

}
