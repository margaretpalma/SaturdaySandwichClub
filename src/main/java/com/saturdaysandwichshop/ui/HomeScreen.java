package com.saturdaysandwichshop.ui;

import com.saturdaysandwichshop.utilities.ConsoleHelper;

public class HomeScreen {
    //main screen

    //display menu loops, runs until user chooses to exit
    public void menuDisplay() {

        while (true) {
            System.out.println("Welcome to Saturday Sandwich Shop");

            System.out.println("1) New Order ");

            System.out.println("0) Exit");

            int choice = ConsoleHelper.promptForInt("Enter Option Here (1/0)");

//            switch (choice) {
//                case 1 -> new OrderScreen().displayOrderScreen();
//                case 0 -> {
//                    System.out.println("See you next Saturday!");
//                    return;


                }
            }
        }