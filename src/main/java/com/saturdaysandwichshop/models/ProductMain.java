package com.saturdaysandwichshop.models;

import com.saturdaysandwichshop.interfaces.Pricing;

//abstract parent class items you can buy
public abstract class ProductMain implements Pricing {

//product name and starting price
    protected String productName;
    protected double basePrice;

//constructor
    public ProductMain(String productName, double basePrice) {
        this.productName = productName;
        this.basePrice = basePrice;
    }


    //getters / setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

//override price, define own logic in classes
    @Override
    public abstract double getPrice();

//formatting
    @Override
    public String toString() {
        return String.format("%s - $%.2f",
                productName,
                basePrice);
    }
}
