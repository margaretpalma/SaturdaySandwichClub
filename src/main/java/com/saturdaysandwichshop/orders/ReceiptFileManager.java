package com.saturdaysandwichshop.orders;

import com.saturdaysandwichshop.models.ProductMain;
import com.saturdaysandwichshop.models.Sandwich;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {


    //receipts are stored here //NEW RECEIPT FOR EACH ORDER
    private static final String Receipt_Folder = "Receipts";

    //from orderscreen to save receipt

    public void saveReceipt(Order order){
    File folder = new File(Receipt_Folder);

    //if the folder doesnt exsist, create it
        if(!folder.exists()){
            folder.mkdir();
        }

        //timestamp generation

        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmSS"));

        //path

        File file = new File(folder, timeStamp + ".txt");

        //write to file

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(generateReceipt(order));

            System.out.println("Receipt Saved!");
        }
        catch (IOException e){
            System.out.println("Error saving receipt!" + e.getMessage());
        }
    }

    private String generateReceipt(Order order){

        StringBuilder sb = new StringBuilder();

        //header for receipt
        sb.append("========================\n");
        sb.append(" Saturday Sandwich Shop\n");
        sb.append("========================\n\n");

        //item details for receipt

        for (ProductMain item : order.getItems()){
            //if sandwich = sandwich print sandwich format

            if (item instanceof Sandwich s){

                //name
                sb.append(s.getProductName()).append(" $")
                        .append(String.format("%.2f", s.getPrice()))
                        .append("\n\n");

                //toppings

                sb.append("Toppings: ")
                        .append(s.getToppingsList()).append("\n\n");
            }
            else {
                sb.append(item.getProductName()).append(" $")
                        .append(String.format("%.2f", item.getPrice()))
                        .append("\n");
            }
        }
        //totals

        double subTotal = order.getItems().stream().mapToDouble(ProductMain::getBasePrice).sum();

        //nc tax rate is 4.75%
        double taxRate = 0.0475;
        double tax = subTotal * taxRate;
        double total = subTotal + tax;
        sb.append("----------------------------------------------\n");
        sb.append("Subtotal: $").append(String.format("%.2f", subTotal)).append("\n");
        sb.append("Tax (4.75): $").append(String.format("%.2f", subTotal)).append("\n");
        sb.append("Total: $").append(String.format("%.2f", subTotal)).append("\n");
        sb.append("-------------------------------------------\n");
        return sb.toString();

    }
}



//catch exception











