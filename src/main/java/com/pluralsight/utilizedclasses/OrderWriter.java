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
        String newFileName = "receipts/" + formattedDate + "_DELI_ORDER.txt";

        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(newFileName))) {
            bufWriter.write(newFileName.substring(0, newFileName.length() - 4) + "\n\n");
            bufWriter.write("--------------------------------------------------------\n");
            int itemNumber = 1;
            for (MenuItem menuItem : customerOrder.getMenuItems()) {
                bufWriter.write(itemNumber++ + ". ");
                bufWriter.write(formatOrder(menuItem));
            }
            bufWriter.write("--------------------------------------------------------\n");
            bufWriter.write("Total Price: " + customerOrder.getTotalPrice() + "\n");
            bufWriter.write("Total Calories: " + customerOrder.getTotalCalories() + "\n");
            bufWriter.write("--------------------------------------------------------\n");
            bufWriter.write("Thank you for coming to Delicatessen Delights, please come again!");
            System.out.println("File created successfully.");
        } catch (FileNotFoundException e) { // Handles FileNotFoundException
            System.out.println("Sorry, there's a problem creating the receipt, please try again later.");
        } catch (IOException e) { // Handles other IOExceptions
            System.out.println("Sorry, there's a problem writing the receipt, please try again later.");
        }
    }

    public static String toString(CustomerOrder customerOrder) {

        StringBuilder orderString = new StringBuilder();

        int itemNumber = 1;
        for (MenuItem menuItem : customerOrder.getMenuItems()) {
            orderString.append(itemNumber++)
                    .append(". ")
                    .append(formatOrder(menuItem))
                    .append("\n");  // add newline after each item
        }
        orderString.append("--------------------------------------------------------\n")
                .append("Total Price: ").append(customerOrder.getTotalPrice()).append("\n")
                .append("Total Calories: ").append(customerOrder.getTotalCalories()).append("\n");
        // Convert to String
        return orderString.toString();
    }

    public static String formatOrder(MenuItem menuItem) {

        if (menuItem instanceof SandwichOrder s) {
            return s.toString("SANDWICH");
        } else if (menuItem instanceof Drink d) {
            return d.toString("DRINK");
        } else if (menuItem instanceof Chips c) {
            return c.toString("CHIPS");
        }
        return "";
    }
}
