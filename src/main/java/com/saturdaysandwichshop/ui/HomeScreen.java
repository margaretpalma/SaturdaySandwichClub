package com.saturdaysandwichshop.ui;

import com.saturdaysandwichshop.utilities.ConsoleHelper;

public class HomeScreen {
    //main screen

    //display menu loops, runs until user chooses to exit
    public void menuDisplay() {

        while (true) {

            System.out.println("""
                ========================================================
                        SATURDAY SANDWICH SHOP — Main Entrance
                --------------------------------------------------------
                  1) Start a New Order
                --------------------------------------------------------
                  0) Exit the Shop
                ========================================================
                """);
            int choice = ConsoleHelper.promptForInt("Enter Option Here (1/0)");

            switch (choice) {
                case 1 -> {
                    OrderScreen orderScreen = new OrderScreen();
                    orderScreen.displayOrderMenu();
                }
                case 0 -> {
                    System.out.println("See You Next Saturday!");
                    return;
                }
                default -> System.out.println("Invalid choice - try again.");
            }
        }
    }
}