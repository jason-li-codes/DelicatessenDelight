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

        // Create LocalDateTime for title of new file
        LocalDateTime currentTime = LocalDateTime.now();
        // Format LocalDateTime to be valid as file name
        String formattedDate = currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        // Create new file name
        String newFileName = "receipts/" + formattedDate + "_DELI_ORDER.txt";
        // Use try with resources to write receipt
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(newFileName))) {
            // Write header
            bufWriter.write(currentTime.toString() + "\n");
            bufWriter.write("-------------------------------------\n");
            // Write each MenuItem with numbers
            int itemNumber = 1;
            for (MenuItem menuItem : customerOrder.getMenuItems()) {
                bufWriter.write(itemNumber++ + ". ");
                bufWriter.write(formatOrder(menuItem));
            }
            // Write total price and calories at bottom of receipt
            bufWriter.write("-------------------------------------\n");
            bufWriter.write("Total Price: " + customerOrder.getTotalPrice() + "\n");
            bufWriter.write("Total Calories: " + customerOrder.getTotalCalories() + "\n");
            bufWriter.write("-------------------------------------\n");
            bufWriter.write("Thank you for coming to\nDelicatessen Delights,\nplease come again!");
            System.out.println("File created successfully.");
        } catch (FileNotFoundException e) { // Handles FileNotFoundException
            System.out.println("Sorry, there's a problem creating the receipt, please try again later.");
        } catch (IOException e) { // Handles other IOExceptions
            System.out.println("Sorry, there's a problem writing the receipt, please try again later.");
        }
    }

    public static String toString(CustomerOrder customerOrder) {
        // Initialize StringBuilder
        StringBuilder orderString = new StringBuilder();
        // Append number and MenuItem details with forEach loop
        int itemNumber = 1;
        for (MenuItem menuItem : customerOrder.getMenuItems()) {
            orderString.append(itemNumber++)
                    .append(". ")
                    .append(formatOrder(menuItem))
                    .append("\n");  // Add newline after each item
        }
        // Add total price and calories at bottom of receipt
        orderString.append("-------------------------------------\n")
                .append("Total Price: ").append(String.format("$%.2f", customerOrder.getTotalPrice())).append("\n")
                .append("Total Calories: ").append(customerOrder.getTotalCalories()).append("\n");
        // Convert to String
        return orderString.toString();
    }

    public static String formatOrder(MenuItem menuItem) {
        // Check child class of each MenuItem to have correct title for each toString method
        if (menuItem instanceof SandwichOrder s) {
            if (s instanceof SpecialSandwichOrder sp) {
                return sp.toString(sp.getSandwichName());
            } else {
                return s.toString("SANDWICH");
            }
        } else if (menuItem instanceof Drink d) {
            return d.toString("DRINK");
        } else if (menuItem instanceof Chips c) {
            return c.toString("CHIPS");
        }
        // Redundant return statement to appease compiler
        return "";
    }
}
