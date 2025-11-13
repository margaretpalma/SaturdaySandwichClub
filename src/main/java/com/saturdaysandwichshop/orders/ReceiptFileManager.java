package com.saturdaysandwichshop.orders;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {


    //receipts are stored here //NEW RECEIPT FOR EACH ORDER
    //java constants are in caps
 private static final String Receipt_Folder = "receipts";

     //check for folder
        public ReceiptFileManager(){
            File folder = new File(Receipt_Folder);

    //create a new folder for each receipt
//todo folder for receipts
            if(!folder.exists()){
                boolean createdFolder = folder.mkdir();

                if(!createdFolder){
                    System.out.println("Error finding receipts folder!");
                }
            }
        }

    //save receipt to file
   //timestamp for receipts - Local Date

    public void saveReceipt(Order order){
            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));


        //file IN receipt

    File file = new File(Receipt_Folder, timeStamp + ".txt");
    try (FileWriter writer = new FileWriter(file)){
        writer.write(Receipt.generate(order));

        //print
        System.out.println("Receipt Saved!" + file.getAbsolutePath());
    }
    catch (IOException e){
        System.out.println("Error Saving Receipt: " + e.getMessage());
    }
  }
}



//catch exception

//implements saving - used for saving the receipts











