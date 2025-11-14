package com.saturdaysandwichshop.utilities;
import java.util.*;
import java.util.stream.*;


//helper class for orderscreen
//user option all at the same time
//clean up orderscreen


public class OrderScreenHelper {


    //uses exiting Java streams, can be called from order screen
    //max = stops at max number option
    //=0 ; cancel
    public static List<Integer> promptForChoices(String message, int max) {
        while (true) {
            String input = ConsoleHelper.promptForString(message).trim();

            //cancel
            if (input.equals("0")) return List.of(0);

            //streams to clean input
            //convert string to int
            //.filter only numbers in range

            String[] parts = input.split(",");


            List<Integer> parsed = Arrays.stream(parts)
                    .map(String::trim)
                    .filter(s -> s.matches("\\d+"))
                    .map(Integer::parseInt)
                    .toList();

            //only num in range
            List<Integer> isValid = parsed.stream()
                    .filter(n -> n >= 1 && n <= max)
                    .toList();

            if(isValid.isEmpty() || isValid.size() != parsed.size()){
                System.out.println("That option wasn’t sugar, spice, OR anything nice. Try a number between 1 and " + max + "!");
                System.out.println("Example Input (1 , 3, 5");
                continue;
        }


            return isValid;
    }
}
    //number choices, min - max of options
    //
    public static int promptForOption(String message, int min, int max) {
        int choice;
        while (true) {
            choice = ConsoleHelper.promptForInt(message);
            if (choice >= min && choice <= max) {
                return choice;
            }
            System.out.println("Hold up! That wasn't in the script. Choose a number between " + min + " and " + max);
        }
    }
        //boolean for y/n
        //true if yes , false if no
        public static boolean promptForYesOrNo(String message) {
            while (true) {

                int choice = ConsoleHelper.promptForInt(message + "(1 = Yes, 2 = No)");
                if (choice == 1)
                    return true;
                if (choice == 2)
                    return false;

                System.out.println("Woah there! That option doesn't exist! Try again.");
            }
        }
    }



