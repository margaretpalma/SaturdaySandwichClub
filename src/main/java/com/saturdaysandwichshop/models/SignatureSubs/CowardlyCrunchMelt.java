package com.saturdaysandwichshop.models.SignatureSubs;

import com.saturdaysandwichshop.models.Bread;
import com.saturdaysandwichshop.models.Sandwich;
import com.saturdaysandwichshop.models.Toppings;

public class CowardlyCrunchMelt extends Sandwich {



    public CowardlyCrunchMelt(Bread bread, int size, boolean toasted) {
        super(new Bread("Rye"), 4, false);

        getToppings().add(new Toppings("Ham", true,true,2.00));
        getToppings().add(new Toppings("Swiss", true,false,1.50));
        getToppings().add(new Toppings("Onion", false,false,0));
        getToppings().add(new Toppings("Pickles", false, false, 0));
        getToppings().add(new Toppings("Mustard", false,false, 0));

    }

    @Override
    public String getProductName(){
        return "Cowardly Crunch Melt";
    }
}
