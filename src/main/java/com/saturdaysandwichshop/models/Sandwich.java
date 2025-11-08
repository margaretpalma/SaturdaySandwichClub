package com.saturdaysandwichshop.models;

import java.util.List;

public class Sandwich {
    //main item
    //sandwich options go here

    private Bread bread;
    private List<Toppings> toppings;
    private int size;
    private boolean toasted;
    private double basePrice;

    public Sandwich(Bread bread, List<Toppings> toppings, int size, boolean toasted,
                    double basePrice) {
        this.bread = bread;
        this.toppings = toppings;
        this.size = size;
        this.toasted = toasted;
        this.basePrice = basePrice;
    }

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(List<Toppings> toppings) {
        this.toppings = toppings;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}
