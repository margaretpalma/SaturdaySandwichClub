package com.saturdaysandwichshop.models;

import com.saturdaysandwichshop.interfaces.Priceing;

public abstract class ProductMain implements Priceing {

    protected String productName;
    protected double basePrice;

    public ProductMain(String productName, double basePrice) {
        this.productName = productName;
        this.basePrice = basePrice;
    }

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

    @Override
    public abstract double getPrice();

    @Override
    public String toString() {
        return productName + " - $" + basePrice;
    }
}
