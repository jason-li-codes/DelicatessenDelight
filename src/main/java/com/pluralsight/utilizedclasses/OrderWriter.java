package com.pluralsight.utilizedclasses;

import com.pluralsight.fooditems.*;
import com.pluralsight.fooditems.sandwich.*;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderWriter {

    public static void writeReceipt(CustomerOrder customerOrder) {

        String formattedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String newFileName = formattedDate + "_DELI_ORDER.txt";

        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(newFileName))) {
            bufWriter.write(newFileName.substring(0, newFileName.length() - 4) + "\n\n");
            bufWriter.write("--------------------------------------------------------\n");
            int itemNumber = 1;
            for (MenuItem menuItem : customerOrder.getMenuItems()) {
                bufWriter.write(itemNumber++ + ". ");
                bufWriter.write(formatOrder(menuItem));
            }
            bufWriter.write("--------------------------------------------------------\n");
            bufWriter.write("Thank you for coming to Delicatessen Delights, please come again!");
            System.out.println("File created successfully.");
        } catch (FileNotFoundException e) { // Handles FileNotFoundException
            System.out.println("Sorry, there's a problem creating the receipt, please try again later.");
        } catch (IOException e) { // Handles other IOExceptions
            System.out.println("Sorry, there's a problem writing the receipt, please try again later.");
        }
    }

    public static String formatOrder(MenuItem menuItem) {

        if (menuItem instanceof SandwichOrder s) {
            s.toString("SANDWICH");
        } else if (menuItem instanceof Drink d) {
            d.toString("DRINK");
        } else if (menuItem instanceof Chips c) {
            c.toString("CHIPS");
        }
        return "";
    }
}
