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
        boolean toasted = ConsoleHelper.promptForString("Sandwhich Toasted? (Y/N)").toLowerCase().startsWith("y");

        Sandwich sandwich = new Sandwich(new Bread(breadType), size, toasted);
        //addToppings(sandwich);
        order.addItem(sandwich);
        System.out.println("Your sandwhich has been added");
    }

    //add drink
    //size and flavor
    public void addDrink() {
        String size = ConsoleHelper.promptForString("Select Drink Size: Small/Medium/Large");

        //todo cherry, orange grape? add flavor options - where?
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
    //add chips - Doritos, Lays, Sunchips - 1.50
    private void addChips(){
        String type = ConsoleHelper.promptForString("Choose Chip Type: (Doritos, Lays, Sunchips)");
        Chips chips = new Chips(type);
        order.addItem(chips);

        System.out.println("Your Chips Have been added");
    }

    //toppings
    private void addToppings(Sandwich sandwich){
        while (true){
            System.out.println("""
                    ---Choose Toppings---
                    1. Add Regular Topping
                    2. Add Meat (Premium)
                    3. Add Cheese (Premium)
                    4. Add Sauce
                    0. End Toppings   
                    """);

            int choice = ConsoleHelper.promptForInt("Choose An Option: ");

            switch (choice){
                case 1 -> addRegularTopping(sandwich);
                case 2 -> addMeatToppings(sandwich);
                case 3 -> addCheeseToppings(sandwich);
                case 4 -> addSauce(sandwich);
                case 0 -> {
                    System.out.println("Finished Topping.");
                    return;
                }
                default -> System.out.println("Invalid Option!");
            }
        }
    }

    //add regular topping - free
    private void addRegularTopping(Sandwich s){
        System.out.println("""
                Regular Topping: 
                -lettuce
                -peppers
                -onions
                -tomatoes
                -jalapenos
                -cucumbers
                -pickles
                -guacamole
                -mushrooms
                """);

        String t = ConsoleHelper.promptForString("Choose Toppings:  ");
        Toppings toppings = new Toppings(t, false, false, 0.0);

        s.getToppings().add(toppings);
        System.out.println(t + "added!");
    }

//
    //meats
    //steak, ham, salami, roast beef, chicken, bacon
    private void addMeatToppings(Sandwich s) {
        System.out.println("""
                Meat Options:
                1. Steak
                2. Ham
                3. Salami
                4. Roast Beef
                5. Chicken
                6. Bacon
                """);

        String t = ConsoleHelper.promptForString("Choose Meat: ");
        boolean extra = ConsoleHelper.promptForString("Extra Portion: (Y/N").toLowerCase().startsWith("y");

        double base = switch (s.getSize()) {
            case 4 -> 1.00;
            case 8 -> 2.00;
            case 12 -> 3.00;
            default -> 1.00;
        };

        double price = extra ? base + (base / 2) : base;

        Toppings topping = new Toppings(t, true, extra, price);

        s.getToppings().add(topping);
        System.out.println(t + "added");
    }


    //cheese toppings .75, 1.50, 2.25
    //american, provolone, cheddar, swiss
    //extra - .30, .60, .90

    private void addCheeseToppings(Sandwich s){
        System.out.println("""
                Cheese: 
                1. American
                2. Provolone
                3. Cheddar 
                4. Swiss
                """);




    }
}



    //receipt generator
    //receipt file manager
    //saving receipt
    private void checkout(){
        System.out.println("---Your Order---");
        System.out.println(Receipt.generate(order));
        //.txt file
        ReceiptFileManager manager = new ReceiptFileManager();
        manager.saveReceipt(order);
        System.out.println("Receipt Saved");
        System.out.println("Return to home screen ");
    }

