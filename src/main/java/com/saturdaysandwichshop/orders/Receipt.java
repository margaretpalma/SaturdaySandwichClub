package com.saturdaysandwichshop.orders;

import com.saturdaysandwichshop.models.Sandwich;

import java.util.stream.Collectors;

public class Receipt {
    //readable receipt

    public static String generate(Order order) {

        //shop title:
        String header = """
                ----------------------------------
                         Saturday Sandwich Shop
                ----------------------------------
                """;

        //item section


        String items = order.getItems().stream()
             .map(item -> {

                 if (item instanceof Sandwich s){
                 return String.format("%s $%.2f\n Toppings : %s",
                 s.getProductName(),
                 s.getPrice(),
                 s.getToppingsList()
                 );
             }
             return String.format(
                     "%s $%.2f",
                     item.getProductName(),
                     item.getPrice());
             }).collect(Collectors.joining("\n"));

//footer

        String footer = String.format("""
                
                ----------------------------------
                Total: $%.2f
                ----------------------------------
                """, order.getTotal());

        return  header + items + footer;
    }
}