package com.saturdaysandwichshop.ui;

import com.saturdaysandwichshop.orders.Order;
import com.saturdaysandwichshop.utilities.ConsoleHelper;

public class OrderScreen {

    //add sandwich, drinks, chips, checkout, cancel

    private final Order order = new Order();

    public void displayOrderMenu() {
        while (true) {
            System.out.println();
        }

    }


    public void displayOrderScreen() {
        System.out.println("menu here");
    }

    int choice = ConsoleHelper.promptForInt("Choose An Option");

    switch(choice){
        case 1 -> addSandwich();
        case 2 -> addDrink();
        case 3 -> addChips();
        case 4 -> checkout();
        case 0 -> {
            System.out.println("Your Order Has Been Cancelled");
            return;
        }
        default -> System.out.println("Sorry, Invalid Selection");
    }
}

