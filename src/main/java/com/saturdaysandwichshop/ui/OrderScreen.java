package com.saturdaysandwichshop.ui;
import com.saturdaysandwichshop.models.*;
import com.saturdaysandwichshop.orders.Order;
import com.saturdaysandwichshop.orders.Receipt;
import com.saturdaysandwichshop.orders.ReceiptFileManager;
import com.saturdaysandwichshop.utilities.ConsoleHelper;
import com.saturdaysandwichshop.utilities.MenuPrint;
import com.saturdaysandwichshop.utilities.OrderScreenHelper;
import java.util.List;


public class OrderScreen {

//add sandwich, drinks, chips, checkout, cancel

    private final Order order = new Order();

    //main menu
    public void displayOrderMenu() {

        while (true) {
            MenuPrint.printMainMenu();
            int choice = OrderScreenHelper.promptForOption("Choose An Option", 0, 4);
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

        MenuPrint.printBreadMenu();
        int breadOption = OrderScreenHelper.promptForOption("-----Choose Bread Option-----", 1, 4);
        String breadType = switch (breadOption) {
            case 1 -> "White";
            case 2 -> "Wheat";
            case 3 -> "Rye";
            case 4 -> "Wrap";
            default -> "White";
        };

//size
        MenuPrint.printSizeMenu();
        int sizeChoice = OrderScreenHelper.promptForOption("-----Choose Size Option-----", 1, 3);
        int size = switch (sizeChoice) {
            case 1 -> 4;
            case 2 -> 8;
            case 3 -> 12;
            default -> 4;
        };

//toasted(y/n)

        boolean toasted = OrderScreenHelper.promptForYesOrNo("-----Would you like your sandwich toasted?-----");


//sandwich making
        Sandwich sandwich = new Sandwich(new Bread(breadType), size, toasted);
        addToppings(sandwich);
        order.addItem(sandwich);
        System.out.println("Sandwich Added");
    }

    //add drink
    //size and flavor
    public void addDrink() {

        MenuPrint.printDrinkSizeMenu();
        int drinkSizeChoice = OrderScreenHelper.promptForOption("-----Choose A Drink Size-----", 1, 3);

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
//flavor

        MenuPrint.printDrinkFlavors();
        int drinkFlavorChoice = OrderScreenHelper.promptForOption("-----Choose Drink Flavor-----", 1, 3);

        String flavor = switch (drinkFlavorChoice) {
            case 1 -> "Coke";
            case 2 -> "Sprite";
            case 3 -> "Lemonade";
            default -> "Coke";
        };

        Drinks drink = new Drinks(size, flavor, price);
        order.addItem(drink);
        System.out.println("Your " + size + " " + flavor + " has been added!");

    }

    //add chips - Doritos, Lays, Sunchips - 1.50
    private void addChips() {

        MenuPrint.printChipMenu();
        int chipChoice = OrderScreenHelper.promptForOption("Choose Chip Type", 1, 3);

        String type = switch (chipChoice) {
            case 1 -> "Doritos";
            case 2 -> "Lays";
            case 3 -> "Sunchips";
            default -> "Doritos";
        };

        Chips chips = new Chips(type);
        order.addItem(chips);
        System.out.println("Your " + type + " Have been added");
    }

    //toppings
    private void addToppings(Sandwich sandwich) {
        while (true) {

            MenuPrint.printToppingMenu();
            int choice = OrderScreenHelper.promptForOption("Choose An Option: ", 0, 4);

            //toppings options "menu"
            switch (choice) {
                case 1 -> addRegularTopping(sandwich);
                case 2 -> addMeatToppings(sandwich);
                case 3 -> addCheeseToppings(sandwich);
                case 4 -> addSauce(sandwich);
                // case 5 -> addSides(sandwich);
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

        while (true) {
            MenuPrint.printRegularToppingMenu();
            List<Integer> choices = OrderScreenHelper.promptForChoices("Enter One or More toppings (Separate By Comma)",
                    9);
            if (choices.isEmpty()) {
                System.out.println("Regular Toppings Added!");
                return;
            }
        //switch case for toppings
            for (int choice : choices) {
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

                if (toppingName != null) {
                    s.getToppings().add(new Toppings(toppingName, false, false, 0.0));
                    System.out.println("Added" + " " + toppingName);
                }
            }
        }
    }

    //meats
    //steak, ham, salami, roast beef, chicken, bacon
    private void addMeatToppings(Sandwich s) {

        MenuPrint.printPremiumMeatOptions();
        List<Integer> choices = OrderScreenHelper.promptForChoices("Enter Meat Option (Separate By Comma 1, 3)", 6);

        if (choices.isEmpty()) {
            System.out.println("Finished add Meat");
            return;
        }

        for (int choice : choices) {
            String meat = switch (choice) {
                case 1 -> "Steak";
                case 2 -> "Ham";
                case 3 -> "Salami";
                case 4 -> "Roast Beef";
                case 5 -> "Chicken";
                case 6 -> "Bacon";
                default -> null;
            };

            if (meat == null) continue;

            boolean extra = OrderScreenHelper.promptForYesOrNo("Extra " + meat + "?");
            if (!extra) {
                System.out.println("Skipped Extra " + meat);
                continue;
            }
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

            double totalPrice = extra ? base + extraCost : base;

            s.getToppings().add(new Toppings(meat, true, extra, totalPrice));
            System.out.println("Extra " + meat + " added");
        }
    }
    //cheese toppings .75, 1.50, 2.25
    //american, provolone, cheddar, swiss
    //extra - .30, .60, .90

    private void addCheeseToppings(Sandwich s) {
        MenuPrint.printCheeseToppings();

        List<Integer> choices = OrderScreenHelper.promptForChoices("Add Cheeses", 4);

        if (choices.isEmpty()) {
            System.out.println("Finished with cheese");
            return;
        }
        for (int choice : choices) {
            String cheese = switch (choice) {
                case 1 -> "American";
                case 2 -> "Provolone";
                case 3 -> "Cheddar";
                case 4 -> "Swiss";
                default -> null;
            };

            if (cheese == null)
                continue;

            //extra portion
            boolean extra = OrderScreenHelper.promptForYesOrNo("Extra Portion " + cheese + "?");
            if (!extra) {
                System.out.println("Skipped Extra " + cheese);
                continue;
            }

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

                s.getToppings().add(new Toppings(cheese, true, extra, finalPrice));
                System.out.println(cheese + " added");
            }
    }

    //sauce
    private void addSauce(Sandwich s) {

        while (true) {
            MenuPrint.printSauceOptions();

            List<Integer> choices = OrderScreenHelper.promptForChoices("Enter Sauce Choice", 7);

            if (choices.isEmpty()) {
                System.out.println("Finished with sauces");
                return;
            }

            for (int choice : choices) {
                String sauce = switch (choice) {
                    case 1 -> "Mayo";
                    case 2 -> "Mustard";
                    case 3 -> "Ketchup";
                    case 4 -> "Ranch";
                    case 5 -> "Thousand Island";
                    case 6 -> "Vinaigrette";
                    case 7 -> "Au Jus";
                    default -> null;
                };

                if (sauce != null) {
                    s.getToppings().add(new Toppings(sauce, false, false, 0.0));
                    System.out.println(sauce + " Added");
                }
            }
        }
    }
    //checkout
    private void checkout() {

        MenuPrint.printCheckoutMenu();
        //print items in order
        order.getItems().forEach(item -> {
            System.out.println(item);
            System.out.printf("Price: $%.2f%n%n", item.getProductName(), item.getPrice());
        });
        double subTotal = order.getItems().stream()
                .mapToDouble(ProductMain::getPrice)
                .sum();
                //tax rate in nc for prepared food = 4.75% :)
                double taxRate = 0.0475;
                double tax = subTotal * taxRate;
                double total = subTotal + tax;

                System.out.println("=========================");
                System.out.printf("Subtotal : $%.2f%n", subTotal);
                System.out.printf("Tax (4.75%%) : $%.2f%n", tax);
                System.out.printf("Total : $%.2f%n", total);

                //order screen checkout option,
                //todo: save to txt file (receipt)
                boolean finishOrder = OrderScreenHelper.promptForYesOrNo("Thanks for ordering from Saturday Sandwich ");
                if (finishOrder) {
                //ask if they wnt a receipt here !!
                //save receipt
                    ReceiptFileManager fileManager = new ReceiptFileManager();
                    fileManager.saveReceipt(order);

                //clear for next order
                    order.clear();
                } else {
                    System.out.println("Order Cancelled. Returning to menu.");
                }
            }
        }
