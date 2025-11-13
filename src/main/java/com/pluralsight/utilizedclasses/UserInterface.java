package com.pluralsight.utilizedclasses;

import com.pluralsight.fooditems.Size;
import com.pluralsight.fooditems.addons.*;
import com.pluralsight.fooditems.sandwich.Bread;
import com.pluralsight.fooditems.sandwich.SandwichOrder;
import com.pluralsight.fooditems.sandwich.swtypes.BreadType;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private static CustomerOrder customerOrder;
    private static ArrayList<CustomerOrder> oldOrders;
    private static Scanner input;

    private void init() {
        customerOrder = new CustomerOrder();
        oldOrders = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public void display() {

        init();

        while (true) {
            System.out.println("""
                    Welcome to DELI-catessen DELI-ght!
                    ======================MAIN MENU======================
                    (1) Look at menu
                    (2) Start new order
                    (3) See previous orders
                    (0) Exit
                    """);

            char mainMenuOption = getValidInput(String.class, false).charAt(0);
            switch (mainMenuOption) {
                case '1' -> viewMenu();
                case '2' -> orderMenu();
                case '3' -> previousOrdersMenu();
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

        while (true) {
            System.out.println("""
                    What item would you like to add to your order?
                    (1) Add a sandwich
                    (2) Add a drink
                    (3) Add chips
                    (4) Checkout
                    (0) Cancel order, return to main menu
                    """);
            char orderMenuOption = getValidInput(String.class, false).charAt(0);
            switch (orderMenuOption) {
                case '1' -> addSandwich();
                case '2' -> addDrink();
                case '3' -> addChips();
                case '4' -> checkout();
                case '0' -> {
                    customerOrder.getMenuItems().clear();
                    System.out.println("Returning to main menu....");
                    return;
                }
                default -> System.out.println("Invalid menu option, please try again.");
            }
        }

    }

    public static void addSandwich() {

        System.out.println("""
                What size of sandwich would you like?
                (S) Small
                (M) Medium
                (L) Large
                (0) Cancel sandwich order
                """);
        Size sandwichSize = null;
        boolean isRunning = true;
        while (isRunning) {
            char addSandwichMenuOption = getValidInput(String.class, false).charAt(0);
            switch (addSandwichMenuOption) {
                case 's' -> {
                    sandwichSize = Size.SMALL;
                    isRunning = false;
                }
                case 'm' -> {
                    sandwichSize = Size.MEDIUM;
                    isRunning = false;
                }
                case 'l' -> {
                    sandwichSize = Size.LARGE;
                    isRunning = false;
                }
                case '0' -> {
                    System.out.println("Returning to previous menu....");
                    return;
                }
                default -> System.out.println("Invalid menu option, please try again.");
            }
        }
        System.out.println("""
                What type of bread would you like?
                (1) White
                (2) Multigrain
                (3) Wheat
                (4) Rye
                (0) Cancel sandwich order
                """);
        BreadType breadType = null;
        isRunning = true;
        while (isRunning) {
            char chooseBreadMenuOption = getValidInput(String.class, false).charAt(0);
            switch (chooseBreadMenuOption) {
                case '1' -> {
                    breadType = BreadType.WHITE;
                    isRunning = false;
                }
                case '2' -> {
                    breadType = BreadType.MULTIGRAIN;
                    isRunning = false;
                }
                case '3' -> {
                    breadType = BreadType.WHEAT;
                    isRunning = false;
                }
                case '4' -> {
                    breadType = BreadType.RYE;
                    isRunning = false;
                }
                case '0' -> {
                    System.out.println("Returning to previous menu....");
                    return;
                }
                default -> System.out.println("Invalid menu option, please try again.");
            }
        }

        SandwichOrder currentSandwich = new SandwichOrder(new Bread(breadType), sandwichSize);


    }

    private static void addDrink() {

        System.out.println("""
                What size of drink would you like?
                (S) Small
                (M) Medium
                (L) Large
                (0) Cancel drink order
                """);
        Size drinkSize = null;
        boolean isRunning = true;
        while (isRunning) {
            char addSandwichMenuOption = getValidInput(String.class, false).charAt(0);
            switch (addSandwichMenuOption) {
                case 's' -> {
                    drinkSize = Size.SMALL;
                    isRunning = false;
                }
                case 'm' -> {
                    drinkSize = Size.MEDIUM;
                    isRunning = false;
                }
                case 'l' -> {
                    drinkSize = Size.LARGE;
                    isRunning = false;
                }
                case '0' -> {
                    System.out.println("Returning to previous menu....");
                    return;
                }
                default -> System.out.println("Invalid menu option, please try again.");
            }
        }
        System.out.println("""
                What type of drink would you like?
                (1) KO-KUH
                (2) SPRY-TUH
                (3) PEP-UH-SEE
                (4) DOK-TUH PEP-UH
                (5) MONS-TUH
                (0) Cancel drink order
                """);
        DrinkType drinkType = null;
        isRunning = true;
        while (isRunning) {
            char chooseBreadMenuOption = getValidInput(String.class, false).charAt(0);
            switch (chooseBreadMenuOption) {
                case '1' -> {
                    drinkType = DrinkType.KO_KUH;
                    isRunning = false;
                }
                case '2' -> {
                    drinkType = DrinkType.SPRY_TUH;
                    isRunning = false;
                }
                case '3' -> {
                    drinkType = DrinkType.PEP_UH_SEE;
                    isRunning = false;
                }
                case '4' -> {
                    drinkType = DrinkType.DOK_TUH_PEP_UH;
                    isRunning = false;
                }
                case '5' -> {
                    drinkType = DrinkType.MONS_TUH;
                    isRunning = false;
                }
                case '0' -> {
                    System.out.println("Returning to previous menu....");
                    return;
                }
                default -> System.out.println("Invalid menu option, please try again.");
            }
        }
        customerOrder.getMenuItems().add(new Drink(drinkType, drinkSize));

    }

    private static void addChips() {

        System.out.println("""
                What type of chips would you like?
                (1) Po-Tay-Tohz
                (2) Free-Tohz
                (3) Toasty-Tohz
                (4) Taki-Tohz
                (5) Dory-Tohz
                (0) Cancel chips order
                """);
        // Loop to get valid input
        ChipsType chipsType = null;
        boolean isRunning = true;
        while (isRunning) {
            // Get valid user input (assuming `getValidInput` method or equivalent is present)
            char chooseChipsMenuOption = getValidInput(String.class, false).charAt(0);
            switch (chooseChipsMenuOption) {
                case '1' -> {
                    chipsType = ChipsType.PO_TAY_TOHZ;
                    isRunning = false;  // Exit loop after valid selection
                }
                case '2' -> {
                    chipsType = ChipsType.FREE_TOHZ;
                    isRunning = false;
                }
                case '3' -> {
                    chipsType = ChipsType.TOASTY_TOHZ;
                    isRunning = false;
                }
                case '4' -> {
                    chipsType = ChipsType.TAKI_TOHZ;
                    isRunning = false;
                }
                case '5' -> {
                    chipsType = ChipsType.DORY_TOHZ;
                    isRunning = false;
                }
                case '0' -> {
                    System.out.println("Returning to previous menu....");
                    return;  // Exit the method, effectively going back
                }
                default -> System.out.println("Invalid menu option, please try again.");
            }
        }
        customerOrder.getMenuItems().add(new Chips(chipsType));
    }

    private static <T> T getValidInput(Class<T> type, boolean allowNull) {

        String userInput;
        T parsedValue = null;

        while (true) {
            userInput = input.nextLine().trim().toLowerCase();  // Accept input as a String
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
