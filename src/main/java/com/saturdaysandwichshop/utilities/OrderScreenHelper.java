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
        String input = ConsoleHelper.promptForString(message).trim();
        if (input.equals("0")) return List.of();

        //streams to clean input
        //convert string to int
        //.filter only numbers in range
        return Arrays.stream(input.split("-"))
                .map(String::trim)
                .filter(s -> s.matches("\\d+"))
                .map(Integer::parseInt)
                .filter(n -> n >= 1 && n <= max)
                .toList();
    }

    //number choices, min - max of options
    //
    public static int promptForOption(String message, int min, int max) {
        int choice;
        while (true) {
            choice = ConsoleHelper.promptForInt(message);
            if (choice >= min && choice <= max) ;
            return choice;

            //sout here for invalid choice
        }

      //boolean for y/n
       //true if yes , false if no
     boolean promptForToasted(String message){
            while (true) {
                int choice = ConsoleHelper.promptForInt(" 1. Yes, 2. No")
                if (choice == 1)
                    return true;
                if (choice == 2)
                    return false;
            }
        }
    }



