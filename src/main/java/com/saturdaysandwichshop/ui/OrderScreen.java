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
            System.out.println("""
                    --Order Menu--
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    0) Cancel Order
                    """);

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

        System.out.println("""
                ---Bread Options ---
                1) White
                2) Wheat
                3) Rye
                4) Wrap
                """);
        int breadChoice = ConsoleHelper.promptForInt("Choose a bread:");
        String breadType = switch (breadChoice){

            case 1 -> "White";
            case 2 -> "Wheat";
            case 3 -> "Rye";
            case 4 -> "Wrap";
            default -> "White";
        };
//size
        System.out.println("""
                ---Size Option---
                1. 4
                2. 8
                3. 12
                """);

        int sizeChoice = ConsoleHelper.promptForInt("Choose Size: ");
        int size = switch (sizeChoice) {
            case 1 -> 4;
            case 2 -> 8;
            case 3 -> 12;
            default -> 4;
        };

//toasted(y/n)

        boolean toasted = ConsoleHelper.promptForString("Toasted? (Y/N)")
                .toLowerCase().startsWith("y");

        Sandwich sandwich = new Sandwich(new Bread(breadType), size, toasted);
        addToppings(sandwich);
        order.addItem(sandwich);
        System.out.println("Sandwich Added");
    }

    //add drink
    //size and flavor
    public void addDrink() {

        System.out.println("""
                ---Drink Sizes---
                1) Small ($2.00)
                2) Medium ($2.50)
                3) Large ($3.00)
                """);

        int drinkSizeChoice = ConsoleHelper.promptForInt("Choose Size: ");

        String size = switch (drinkSizeChoice) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "Small";
        };

        double price = switch (drinkSizeChoice) {
            case 1 -> 2.00;
            case 2 -> 2.50;
            case 3 -> 3.00;
            default -> 2.00;
        };

        int drinkFlavorChoice = ConsoleHelper.promptForInt("Choose Flavor: ");
        String type = switch (drinkFlavorChoice) {
            case 1 -> "Coke";
            case 2 -> "Sprite";
            case 3 -> "Lemonade";
            default -> "Coke";
        };

        Drinks drink = new Drinks(size,type, price);
        order.addItem(drink);
        System.out.println("Your drink has been added!");

    }

    //add chips - Doritos, Lays, Sunchips - 1.50
    private void addChips() {
        System.out.println("""
                ---Chip Options---
                1) Doritos
                2) Lays
                3) Sunchips
                """);
        int chipChoice = ConsoleHelper.promptForInt("Choose Chips: ");

        String type = switch (chipChoice) {
            case 1 -> "Doritos";
            case 2 -> "Lays";
            case 3 -> "Sunchips";
            default -> "Doritos";
        };

        Chips chips = new Chips(type);
        order.addItem(chips);
        System.out.println(type + "Your Chips Have been added");
    }

    //toppings
    private void addToppings(Sandwich sandwich) {
        while (true) {
            System.out.println("""
                    ---Choose Toppings---
                    1. Add Regular Topping
                    2. Add Meat (Premium)
                    3. Add Cheese (Premium)
                    4. Add Sauce
                    0. End Toppings
                    """);

            int choice = ConsoleHelper.promptForInt("Choose An Option: ");

            switch (choice) {
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

    //todo: make regular toppings LOOP
    private void addRegularTopping(Sandwich s) {
        System.out.println("""
                Regular Topping:
                1) Lettuce
                2) Peppers
                3) Onions
                4) Tomatoes
                5) Jalapenos
                6) Cucumbers
                7) Pickles
                8) Guacamole
                9) Mushrooms
                """);

        int choice = ConsoleHelper.promptForInt("Choose a topping: ");
        //if 0;

        if (choice == 0) {
            System.out.println("No Regular Topping Added");
            return;
        }

        String toppingName = switch (choice) {
            case 1 -> "Lettuce";
            case 2 -> "Peppers";
            case 3 -> "Onion";
            case 4 -> "Tomatoes";
            case 5 -> "Jalapenos";
            case 6 -> "Cucumbers";
            case 7 -> "Pickles";
            case 8 -> "Guacamole";
            case 9 -> "Mushroom";
            default -> null;
        };

        if (toppingName == null) {
            System.out.println("Invalid choice, try again!");
            return;
        }

        Toppings topping = new Toppings(toppingName, false, false, 0.0);
        s.getToppings().add(topping);

        System.out.println(toppingName + "added");
    }

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

        double extraCost = switch (s.getSize()) {
            case 4 -> 0.50;
            case 8 -> 1.00;
            case 12 -> 1.50;
            default -> 0.50;
        };

        double price = extra ? base + extraCost : base;
        Toppings topping = new Toppings(t, true, extra, price);

        s.getToppings().add(topping);
        System.out.println(t + "added");
    }

    //cheese toppings .75, 1.50, 2.25
    //american, provolone, cheddar, swiss
    //extra - .30, .60, .90
    private void addCheeseToppings(Sandwich s) {
        System.out.println("""
                Cheese:
                1) American
                2) Provolone
                3) Cheddar
                4) Swiss
                0) Cancel
                """);

        int choice = ConsoleHelper.promptForInt("Choose Cheese: ");

        String cheese = switch (choice){
            case 1 -> "American";
            case 2 -> "Provolone";
            case 3 -> "Cheddar";
            case 4 -> "Swiss";
            case 0 -> {
                System.out.println("No cheese added!");
                yield null;
            }
            default -> {
                System.out.println("Invalid cheese choice");
                yield null;
            }
        };

        if (cheese == null) return;

        boolean extra = ConsoleHelper.promptForString("Extra (Y/N)").toLowerCase().startsWith("y");

        double base = switch (s.getSize()) {
            case 4 -> 0.75;
            case 8 -> 1.50;
            case 12 -> 2.25;
            default -> 0.75;
        };

        double extraCost = switch (s.getSize()) {
            case 4 -> 0.30;
            case 8 -> 0.60;
            case 12 -> 0.90;
            default -> 0.30;
        };

        double finalPrice = extra ? base + extraCost : base;

        Toppings topping = new Toppings(cheese, true, extra, finalPrice);
        s.getToppings().add(topping);
        System.out.println(cheese + "added");
    }


        private void addSauce(Sandwich s){
            System.out.println("""
                    Sauces:
                    1) Mayo
                    2) Mustard
                    3) Ketchup
                    4) Ranch
                    5) Thousand Island
                    6) Vinaigrette
                    0) Cancel
                    """);

        int choice = ConsoleHelper.promptForInt("Choose A Sauce: ");
        String sauce = switch (choice){
            case 1 -> "Mayo";
            case 2 -> "Mustard";
            case 3 -> "Ketchup";
            case 4 -> "Ranch";
            case 5 -> "Thousand Island";
            case 6 -> "Vinaigrette";
            case 0 -> {
                System.out.println("No Sauce");
                yield null;
            }
            default -> {
                System.out.println("Invalid option");
                yield null;
            }
        };
        if(sauce == null) return;

        Toppings topping = new Toppings(sauce, false, false, 0.0);
         s.getToppings().add(topping);
            System.out.println(sauce + "Added");
    }



//checkout
    private void checkout () {

        if (order.getItems().isEmpty()) {
            System.out.println("Order empty!");
            return;
        }
        System.out.println("\n---Your Order ---");
        System.out.println(Receipt.generate(order));

        ReceiptFileManager manager = new ReceiptFileManager();
        manager.saveReceipt(order);

        System.out.println("rceipt saved");
        System.out.println("Returning to home screen");
        return;

    }
    }