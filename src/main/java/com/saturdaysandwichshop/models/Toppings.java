package com.saturdaysandwichshop.models;

public class Toppings extends ProductMain {

    //toppings - premium or extra toppings
    //meats, cheeses, regular toppings
    //inherits from productmain


    private String toppingName;
    private boolean premiumTopping;
    private boolean extraPortion;

    public Toppings(String toppingName, boolean premiumTopping, boolean extraPortion, double price) {
        super(toppingName, price);
        this.toppingName = toppingName;
        this.premiumTopping = premiumTopping;
        this.extraPortion = extraPortion;
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

//price override
    @Override
    public double getPrice(){
        return basePrice;
    }

//to string
    @Override
    public String toString() {
        //ternary opterator - if//else
        //if isPremiumTopping is true return premium, if its not return regular

        String extra = extraPortion ? " (Extra)" : "";
        String premium = premiumTopping ? " (Premium)" : "";

        return String.format("%s%s%s - $%.2f",
                toppingName,
                extra,
                premium,
                basePrice);
    }
}
