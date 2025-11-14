package com.saturdaysandwichshop.models;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//sandwich has-a topping/bread/size/toast (y/n)

public class Sandwich extends ProductMain {
    //main item
    //sandwich options go here
    //4 8 12
    private Bread bread;
    private List<Toppings> toppings;
    private int size;
    private boolean toasted;

    public Sandwich(Bread bread, int size, boolean toasted) {
        super("Sandwich", 0.0);
        this.bread = bread;
        this.toppings = new ArrayList<>();
        this.size = size;
        this.toasted = toasted;

    }

    //get/set
    public Bread getBread() {
        return bread;
    }

    public int getSize() {
        return size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }


    //pricing

    @Override
    public double getPrice() {
        double sizePrice =
                switch (size) {
                    case 4 -> 5.50;
                    case 8 -> 7.00;
                    case 12 -> 8.50;
                    default -> 0.0;
                };

//getting the price using streams


        double toppingTotal = toppings.stream()
                .mapToDouble(Toppings::getPrice)
                .sum();

        return sizePrice + toppingTotal;
    }

    //helper methods
    public String getToppingsList() {
        if (toppings.isEmpty()) return "No toppings";
        return toppings.stream()
                .map(t -> t.getToppingName() +
                        (t.isExtraPortion() ? " *Extra*" : "") +
                        (t.isPremiumTopping() ? " *Premium*" : ""))
                .collect(Collectors.joining(", "));
    }

//format display for receipt
    @Override
    public String toString() {

        String toppingList =
                 toppings.stream()
                .map(t -> t.getToppingName() + (t.isExtraPortion() ? "(Extra Portion)" : ""))
                .collect(Collectors.joining(", "));

        return String.format("%d\" %s %s | Toppings: [%s] | Total: $%.2f",
                size,
                bread.getBreadType(),
                toasted ? "(Toasted)" : "",
                toppingList,
                getPrice()
        );
    }
}
