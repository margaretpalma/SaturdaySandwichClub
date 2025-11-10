package com.saturdaysandwichshop.ui;
import com.saturdaysandwichshop.models.*;
import com.saturdaysandwichshop.orders.Order;
import com.saturdaysandwichshop.orders.Receipt;
import com.saturdaysandwichshop.orders.ReceiptFileManager;
import com.saturdaysandwichshop.utilities.ConsoleHelper;


public class OrderScreen {

    //add sandwich, drinks, chips, checkout, cancel

    private final Order order = new Order();


    //main menu
    public void displayOrderMenu() {

        while (true) {
            System.out.println();
        }

        public void displayOrderScreen() {
            System.out.println("""
                    -----Order Menu ----
                    1 - Add Sandwich
                    2 - 
                    3- 
                    """);
        }

        int choice = ConsoleHelper.promptForInt("Choose An Option");

        switch (choice) {
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
}
        //add sandwich
        //white, wheat, rye, wrap
        private void addSandwich() {
            int size = ConsoleHelper.promptForInt("Enter A Size: 4, 8, 12");
            String breadType = ConsoleHelper.promptForString("Enter Bread Type: White, Wheat, Rye, Wrap");
            double breadPrice = 0;

            Sandwich sandwich = new Sandwich("Sandwich", 0.0, new Bread(breadType, breadPrice), size, false);

            order.addItem(sandwich);
            System.out.println("Sandwich Added");
        }

        //add drink
        public void addDrink(){
        String size = ConsoleHelper.promptForString("Select Drink Size: ")
        String flavor = ConsoleHelper.promptForString("Select Drink Flavor: ");

        Drinks drink = new Drinks(size, flavor);
            order.addItem(drink);
            System.out.println("Drink Added");
        }

        //add chips

        private void addChips(){
            String type = ConsoleHelper.promptForString("Select A Chip Size");
            Chips chips = new Chips(type);
            order.addItem(chips);

            System.out.println("Chips Added");
}
        private void checkout(){
            System.out.println(Receipt.generate(order));
            new ReceiptFileManager().saveReceipt(order);
            System.out.println("Receipt Saved");
}
}