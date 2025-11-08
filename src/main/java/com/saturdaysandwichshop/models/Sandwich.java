package com.saturdaysandwichshop.models;

import com.saturdaysandwichshop.interfaces.Customizable;

import java.util.ArrayList;
import java.util.List;
    //sandwich has-a topping/bread/size/toast (y/n)

public class Sandwich extends ProductMain implements Customizable {
    //main item
    //sandwich options go here
    //4 8 12
    private Bread bread;
    private List<Toppings> toppings;
    private int size;
    private boolean toasted;

    public Sandwich(String productName, double basePrice, Bread bread,
                    List<Toppings> toppings, int size, boolean toasted) {
        super(productName, basePrice);
        this.bread = bread;
        this.toppings = new ArrayList<>();
        this.size = size;
        this.toasted = toasted;

    }

    @Override
    public void addCustom(String option) {
        toppings.add(new Toppings(option, false,false, 0))
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
