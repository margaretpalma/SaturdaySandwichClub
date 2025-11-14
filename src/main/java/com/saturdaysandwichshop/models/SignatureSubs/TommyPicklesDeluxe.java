package com.saturdaysandwichshop.models.SignatureSubs;

import com.saturdaysandwichshop.models.*;
import com.saturdaysandwichshop.models.Sandwich;

public class TommyPicklesDeluxe extends Sandwich {

    public TommyPicklesDeluxe(Bread bread, int size, boolean toasted) {
        super(new Bread("Wheat"), 12, false);


        getToppings().add(new Toppings("Chicken", true, false, 2.00));
        getToppings().add(new Toppings("Swiss", true, false, 1.50));
        getToppings().add(new Toppings("Cucumbers", false, false, 0));
        getToppings().add(new Toppings("Pickles", false, false, 0));
        getToppings().add(new Toppings("Vinaigrette", false, false, 0));

    }

    @Override
    public String getProductName() {
        return "Tommy Pickles Deluxe";
    }
}

