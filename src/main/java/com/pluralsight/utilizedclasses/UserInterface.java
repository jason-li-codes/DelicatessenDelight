package com.pluralsight.utilizedclasses;

import java.util.Scanner;

public class UserInterface {

    private CustomerOrder customerOrder;
    private static Scanner input;

    private void init() {
        this.customerOrder = new CustomerOrder();
        input = new Scanner(System.in);
    }

    public void display() {

        init();

        while (true) {
            System.out.println("""
                    Welcome to DELI-catessen DELI-ght!
                    ======================MAIN MENU======================
                    (1) Start new order
                    (0) Exit
                    """);

            char mainMenuOption = getValidInput(String.class, false).charAt(0);
            switch (mainMenuOption) {
                case '1' -> orderMenu();
                case '0' -> {
                    System.out.println("EXITING....");
                    input.close();
                    return;
                }
                default -> System.out.println("Invalid menu option, please try again.");
            }
        }
    }

    private static void orderMenu() {




    }

    private static <T> T getValidInput(Class<T> type, boolean allowNull) {

        String userInput;
        T parsedValue = null;

        while (true) {
            userInput = input.nextLine().trim();  // Accept input as a String
            // Check the type and parse accordingly
            if (type == Integer.class) {
                try {
                    parsedValue = type.cast(Integer.parseInt(userInput));
                } catch (NumberFormatException ignored) {
                }
            } else if (type == Double.class) {
                try {
                    parsedValue = type.cast(Double.parseDouble(userInput));
                } catch (NumberFormatException ignored) {
                }
            } else if (type == String.class) {
                // Accept the string value if it's not empty or if null is allowed
                if (!userInput.isEmpty()) {
                    parsedValue = type.cast(userInput);
                }
            }
            // If value is valid or null is allowed
            if (allowNull || parsedValue != null) {
                return parsedValue;
            } else {
                System.out.println("Sorry, I don't know what you mean, please try again.");
            }
        }
    }


}
