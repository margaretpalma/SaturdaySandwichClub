package com.saturdaysandwichshop.orders;

import java.util.stream.Collectors;

public class Receipt {
    //readable receipt

    public static String generate(Order order) {

        //shop title:
        //todo: formatting for receipt
        String header = """
                ---- Sat Sandwich Shop---""";

        String items = order.getItems().isEmpty() ? "No Items.\n" : order.getItems().isEmpty() :
        order.getItems().stream().map(items -> String.format("%-10 $%.2f",items.getProductName(),
                items.getPrice())).collect(Collectors.joining("\n"));

        //footer
        String footer = String.format("""
                Total: $%2f""", order.getTotal());

        return header + items + footer;
    }

    //util methods for building?

    //local date local time (normal receipt information)

    //format for intellij terminal ?
}
