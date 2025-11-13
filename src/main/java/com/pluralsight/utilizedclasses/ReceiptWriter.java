package com.pluralsight.utilizedclasses;

import com.pluralsight.fooditems.*;
import com.pluralsight.fooditems.addons.*;
import com.pluralsight.fooditems.sandwich.*;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void writeReceipt(CustomerOrder customerOrder) {

        String formattedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String newFileName = formattedDate + "_DELI_ORDER.txt";

        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(newFileName))) {
            bufWriter.write(newFileName.substring(0, newFileName.length() - 4) + "\n\n");
            bufWriter.write("--------------------------------------------------------\n");
            for (MenuItem menuItem : customerOrder.getMenuItems()) { // Writes each transaction to file
                bufWriter.write(formatReceipt(menuItem));
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

    public static String formatReceipt(MenuItem menuItem) {

        if (menuItem instanceof SandwichOrder s) {

            StringBuilder receiptLine = new StringBuilder();
            // Add Header
            receiptLine.append("=====================================\n")
                    .append("              SANDWICH               \n")
                    .append("=====================================\n");
            // Add basic order information
            receiptLine.append(String.format("Size: %s\n", s.getSize()));
            receiptLine.append(String.format("Bread: %s\n", s.getBread().getBreadType()));
            // Add Toasting Option
            receiptLine.append("Toasted: ").append(s.isToasted() ? "Yes" : "No").append("\n");
            // Add Meats
            if (!s.getPremiumToppingMeats().getItems().isEmpty()) {
                receiptLine.append("Meats:\n");
                for (PremiumToppingMeat meat : s.getPremiumToppingMeats().getItems()) {
                    receiptLine.append(" - ").append(meat.getMeatType()).append(" (")
                            .append(meat.isExtra() ? "Extra" : "Regular").append(")\n");
                }
            } else {
                receiptLine.append("No meats selected.\n");
            }
            // Add Cheeses
            if (!s.getPremiumToppingCheeses().getItems().isEmpty()) {
                receiptLine.append("Cheeses:\n");
                for (PremiumToppingCheese cheese : s.getPremiumToppingCheeses().getItems()) {
                    receiptLine.append(" - ").append(cheese.getCheeseType()).append(" (")
                            .append(cheese.isExtra() ? "Extra" : "Regular").append(")\n");
                }
            } else {
                receiptLine.append("No cheeses selected.\n");
            }
            // Add Regular Toppings
            if (!s.getRegularToppings().getItems().isEmpty()) {
                receiptLine.append("Toppings:\n");
                for (RegularTopping topping : s.getRegularToppings().getItems()) {
                    receiptLine.append(" - ").append(topping.getRegularToppingType()).append("\n");
                }
            } else {
                receiptLine.append("No toppings selected.\n");
            }
            // Add Sauces
            if (!s.getSauces().getItems().isEmpty()) {
                receiptLine.append("Sauces:\n");
                for (Sauce sauce : s.getSauces().getItems()) {
                    receiptLine.append(" - ").append(sauce.getSauceType()).append("\n");
                }
            } else {
                receiptLine.append("No sauces selected.\n");
            }
            // Add Sides
            if (!s.getSides().getItems().isEmpty()) {
                receiptLine.append("Sides:\n");
                for (Side side : s.getSides().getItems()) {
                    receiptLine.append("  - ").append(side.getSideType()).append("\n");
                }
            } else {
                receiptLine.append("No sides selected.\n");
            }
            // Add Price and Calories
            receiptLine.append("=====================================\n")
                    .append(String.format("Price: $%.2f\n", s.getPrice()))
                    .append(String.format("Calories: %d\n", s.getCalories()));
            // Add Footer
            receiptLine.append("=====================================\n");
            // Return StringBuilder as String
            return receiptLine.toString();

        } else if (menuItem instanceof Drink d) {

            // Add Header
            // Return StringBuilder as String
            return "=====================================\n" +
                    "                DRINK                \n" +
                    "=====================================\n" +
                    // Add Order Information
                    String.format("Size: %s\n", d.getSize()) +
                    String.format("Brand: %s\n", d.getDrinkType()) +
                    // Add Price and Calories
                    "=====================================\n" +
                    String.format("Price: $%.2f\n", d.getPrice()) +
                    String.format("Calories: %d\n", d.getCalories()) +
                    // Add Footer
                    "=====================================\n";

        } else if (menuItem instanceof Chips c) {
            // Add Header
            // Return StringBuilder as String
            return "=====================================\n" +
                    "                CHIPS                \n" +
                    "=====================================\n" +
                    // Add Order Information
                    String.format("Brand: %s\n", c.getChipsType()) +
                    // Add Price and Calories
                    "=====================================\n" +
                    String.format("Price: $%.2f\n", c.getPrice()) +
                    String.format("Calories: %d\n", c.getCalories()) +
                    // Add Footer
                    "=====================================\n";
        }
        return "";
    }
}
