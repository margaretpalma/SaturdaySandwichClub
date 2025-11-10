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
            System.out.println("Order Here!");
// todo        System.out.println - add sandwich
//            System.out.println - add drinks
//            System.out.println - add chips
//            System.out.println - checkout
//            System.out.println - cancel order - back to homepage
//
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

        String isToasted = ConsoleHelper.promptForString("Would You Like The Sandwich Toasted?(Y/N)").toLowerCase();

        boolean toasted = isToasted.startsWith("y");

        Sandwich sandwich = new Sandwich(new Bread(breadType), size, toasted);

        order.addItem(sandwich);
        System.out.println("Your sandwhich has been added");
    }

    //add drink
    public void addDrink() {
        String size = ConsoleHelper.promptForString("Select Drink Size: Small/Medium/Large");

        //cherry, orange grape?
        String flavor = ConsoleHelper.promptForString("Select Drink Flavor: ");

        //price based in size
        double price = switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 2.00;     //auto goes to size small
        };

        Drinks drinks = new Drinks(size, flavor, price);
        order.addItem(drinks);

        System.out.println("Your drink has been added!");

    }
    //add chips - Doritos, Lays, Sunchips
    private void addChips(){
        String type = ConsoleHelper.promptForString("Choose Chip Type: (Doritos, Lays, Sunchips)");
        Chips chips = new Chips(type);
        order.addItem(chips);

        System.out.println("Your Chips Have been added");
    }

    private void checkout(){
        //
    }

}