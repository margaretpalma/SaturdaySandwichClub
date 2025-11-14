package com.saturdaysandwichshop.models.SignatureSubs;

import com.saturdaysandwichshop.models.Bread;
import com.saturdaysandwichshop.models.Sandwich;
import com.saturdaysandwichshop.models.Toppings;

public class DextersLab extends Sandwich {

    public DextersLab(){
        super(new Bread("White"), 8, true);

        //toppings for speciality sandwich

        getToppings().add(new Toppings("Bacon", true, false, 2.00));
        getToppings().add(new Toppings("Cheddar", true, false, 1.50));
        getToppings().add(new Toppings("Lettuce", false, false, 0));
        getToppings().add(new Toppings("Tomatoes", false, false, 0));
        getToppings().add(new Toppings("Ranch", false, false, 0));

    }
    @Override
    public String getProductName(){
        return "Dexter's Lab Secret Sub";
    }
}
