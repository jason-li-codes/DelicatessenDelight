package com.pluralsight.utilizedclasses;

import com.pluralsight.fooditems.*;
import com.pluralsight.fooditems.enums.*;
import com.pluralsight.fooditems.sandwich.*;

import java.util.Scanner;

public class UserInterface {

    // Define a CustomerOrder and Scanner as private static attributes
    private static CustomerOrder customerOrder;
    private static Scanner input;

    // Initialize private attributes
    private void init() {
        customerOrder = new CustomerOrder();
        input = new Scanner(System.in);
    }

    // Main display method
    public void display() {
        // Call initializing method
        init();
        // Show homepage
        while (true) {
            // Print homepage
            PrintColumns.twoColumns("""
                    Welcome to Delicatessen Delights!
                    (1) Start new order
                    (0) Exit
                    """, PrintMenu.homepage());
            // Get first character of user input
            char mainMenuOption = getValidInput(String.class).charAt(0);
            switch (mainMenuOption) {
                case '1' -> orderMenu(); // Call orderMenu method
                case '0' -> {
                    System.out.println("EXITING....");
                    input.close(); // Close Scanner
                    return; // End program
                }
                default -> System.out.println("Invalid menu option, please try again.");
            }
        }
    }

    private static void orderMenu() {

        while (true) {
            // Print order menu
            PrintColumns.twoColumns("""
                    What item would you like to add to your order?
                    (1) Add a sandwich
                    (2) Add a drink
                    (3) Add chips
                    (4) Checkout
                    (0) Return to main menu
                    """, PrintMenu.fullMenu());
            // Get first character of user input
            char orderMenuOption = getValidInput(String.class).charAt(0);
            switch (orderMenuOption) {
                case '1' -> addSandwich(); // Call addSandwich method
                case '2' -> addDrink(); // Call addDrink method
                case '3' -> addChips(); // Call addChips method
                case '4' -> checkoutMenu(); // Call checkoutMenu
                case '0' -> {
                    customerOrder.getMenuItems().clear(); // Clear customerOrder as program exits
                    System.out.println("Returning to main menu....");
                    return;
                }
                default -> System.out.println("Invalid menu option, please try again.");
            }
        }

    }

    private static void checkoutMenu() {

        while (true) {
            // Print checkout menu
            PrintColumns.twoColumns("""
                    Would you like to checkout?
                    (1) Yes, checkout
                    (2) No, I want to remove an item
                    (3) Return to previous menu
                    """, OrderWriter.toString(customerOrder));
            // Get first character of user input
            char checkoutMenuOption = getValidInput(String.class).charAt(0);
            switch (checkoutMenuOption) {
                case '1' -> {
                    checkout(); // Call checkout method
                    return;
                }
                case '2' -> checkoutRemoveMenu(); // Call checkoutRemoveMenu method
                case '3' -> {
                    return;
                }
                default -> System.out.println("Invalid menu option, please try again.");
            }
        }
    }

    private static void checkoutRemoveMenu() {

        while (true) {
            // Print options
            PrintColumns.twoColumns("""
                    Which number item would you like to remove?
                    Or, press (0) to return to previous menu
                    """, OrderWriter.toString(customerOrder));
            // Get integer from user
            int removeItemNum = getValidInput(Integer.class);
            // If integer is invalid, reprompt
            if (removeItemNum < 0 || removeItemNum > customerOrder.getMenuItems().size()) {
                System.out.println("Sorry, I don't see that number on the order.");
                // If integer is 0, exit
            } else if (removeItemNum == 0) {
                return;
                // Otherwise, remove appropriate MenuItem by using index
            } else {
                customerOrder.getMenuItems().remove(removeItemNum - 1);
                System.out.println("Item successfully removed.");
            }
        }
    }

    private static void checkout() {
        // Call writeReceipt static method
        OrderWriter.writeReceipt(customerOrder);
        // Print receipt and thank you message
        PrintColumns.twoColumns("""
                Your receipt has been printed.
                Thank you for coming to Delicatessen Delights, please come again!
                """, OrderWriter.toString(customerOrder));
        // Clear customerOrder
        customerOrder.getMenuItems().clear();
        input.close(); // Close scanner
        System.exit(0); // Exit program
    }

    private static void addSandwich() {

        while (true) {
            // Print options
            PrintColumns.twoColumns("""
                    What kind of sandwich would you like?
                    (S) Specials
                    (C) Custom
                    (X) Return to previous menu
                    """, PrintMenu.sandwichMenu());
            // Get first character of user input
            char sandwichMenuOption = getValidInput(String.class).charAt(0);
            switch (sandwichMenuOption) {
                case 's' -> specialsMenu(); // Call specialMenu
                case 'c' -> buildSandwich(); // Call buildSandwich
                case 'x' -> {
                    System.out.println("Returning to previous menu....");
                    return;
                }
                default -> System.out.println("Invalid menu option, please try again.");
            }
        }
    }


    private static void specialsMenu() {

        while (true) {
            // Print options
            PrintColumns.twoColumns("""
                    Which special would you like?
                    (1) Green Mountain Melt
                    (2) Smokehouse Stack
                    (3) Southwest Sunrise
                    (4) Pastrami King
                    (5) Garden Delight
                    (6) Mediterranean Delight
                    (0) Return to previous menu
                    """, PrintMenu.specialsMenu());
            // Get first character of user input
            char specialsMenuOption = getValidInput(String.class).charAt(0);
            boolean isRunning = true;
            while (isRunning) {
                // Create correct SpecialSandwichOrder based on user input
                switch (specialsMenuOption) {
                    case '1' -> {
                        customerOrder.getMenuItems().add(new SpecialSandwichOrder("green mountain melt"));
                        isRunning = false;
                    }
                    case '2' -> {
                        customerOrder.getMenuItems().add(new SpecialSandwichOrder("smokehouse stack"));
                        isRunning = false;
                    }
                    case '3' -> {
                        customerOrder.getMenuItems().add(new SpecialSandwichOrder("southwest sunrise"));
                        isRunning = false;
                    }
                    case '4' -> {
                        customerOrder.getMenuItems().add(new SpecialSandwichOrder("pastrami king"));
                        isRunning = false;
                    }
                    case '5' -> {
                        customerOrder.getMenuItems().add(new SpecialSandwichOrder("garden delight"));
                        isRunning = false;
                    }
                    case '6' -> {
                        customerOrder.getMenuItems().add(new SpecialSandwichOrder("mediterranean delight"));
                        isRunning = false;
                    }
                    case '0' -> {
                        System.out.println("Returning to previous menu....");
                        return;
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            isRunning = true;
            while (isRunning) {
                // Print options
                PrintColumns.twoColumns("""
                        Would you like to add another special?
                        (Y) Yes
                        (N) No, return to previous menu
                        """, PrintMenu.specialsMenu());
                // Get first character of user input
                char addSpecialOption = getValidInput(String.class).charAt(0);
                switch (addSpecialOption) {
                    case 'y' -> isRunning = false; // End while loops
                    case 'n' -> {
                        return; // Exit method
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
        }
    }

    private static void buildSandwich() {

        Size sandwichSize = null;
        boolean isRunning = true;
        while (isRunning) {
            // Print options
            PrintColumns.twoColumns("""
                    What size of sandwich would you like?
                    (S) Small
                    (M) Medium
                    (L) Large
                    (X) Cancel sandwich order
                    """, PrintMenu.sandwichMenu());
            // Get first character of user input
            char addSandwichMenuOption = getValidInput(String.class).charAt(0);
            // Get appropriate Size
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
                case 'X' -> {
                    System.out.println("Returning to previous menu....");
                    return;
                }
                default -> System.out.println("Invalid menu option, please try again.");
            }
        }

        BreadType breadType = null;
        isRunning = true;
        while (isRunning) {
            // Print options
            PrintColumns.twoColumns("""
                    What type of bread would you like?
                    (1) White
                    (2) Multigrain
                    (3) Wheat
                    (4) Rye
                    (0) Cancel sandwich order
                    """, PrintMenu.sandwichMenu());
            // Get first character of user input
            char chooseBreadMenuOption = getValidInput(String.class).charAt(0);
            // Assign correct BreadType
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
        // Create basic SandwichOrder
        SandwichOrder currentSandwich = new SandwichOrder(new Bread(breadType), sandwichSize);

        isRunning = true;
        while (isRunning) {
            // Print options
            PrintColumns.twoColumns("""
                    Would you like your sandwich toasted?
                    (Y) Yes
                    (N) No""", PrintMenu.sandwichMenu());
            // Get first character of user input
            char chooseToastedOption = getValidInput(String.class).charAt(0);
            // Set correct isToasted boolean value
            switch (chooseToastedOption) {
                case 'y' -> {
                    currentSandwich.setToasted(true);
                    isRunning = false;
                }
                case 'n' -> {
                    currentSandwich.setToasted(false);
                    isRunning = false;
                }
                default -> System.out.println("Invalid menu option, please try again.");
            }
        }

        // Call methods to add SandwichFillings
        addSandwichMeat(currentSandwich);
        addSandwichCheese(currentSandwich);
        addSandwichToppings(currentSandwich);
        addSandwichSauces(currentSandwich);
        addSandwichSides(currentSandwich);

        System.out.println("Sandwich successfully added to your order.");
    }

    private static void addSandwichMeat(SandwichOrder currentSandwich) {

        while (true) {
            MeatType meatType = null;
            boolean isRunning = true;
            while (isRunning) {
                // Print options
                PrintColumns.threeColumns("""
                        What meat would you like to add to your sandwich?
                            (1) Turkey
                            (2) Ham
                            (3) Chicken
                            (4) Roast Beef
                            (5) Pastrami
                            (6) Bacon
                            (0) None
                        """, PrintMenu.sandwichMenu(), currentSandwich.toString("Current sandwich:"));
                // Get first character of user input
                char chooseMeatMenuOption = getValidInput(String.class).charAt(0);
                // Assign correct MeatType
                switch (chooseMeatMenuOption) {
                    case '1' -> {
                        meatType = MeatType.TURKEY;
                        isRunning = false;
                    }
                    case '2' -> {
                        meatType = MeatType.HAM;
                        isRunning = false;
                    }
                    case '3' -> {
                        meatType = MeatType.CHICKEN;
                        isRunning = false;
                    }
                    case '4' -> {
                        meatType = MeatType.ROAST_BEEF;
                        isRunning = false;
                    }
                    case '5' -> {
                        meatType = MeatType.PASTRAMI;
                        isRunning = false;
                    }
                    case '6' -> {
                        meatType = MeatType.BACON;
                        isRunning = false;
                    }
                    case '0' -> {
                        return;
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            boolean isExtra = false;
            isRunning = true;
            while (isRunning) {
                // Print options
                PrintColumns.threeColumns("""
                        Would you like extra of that?
                        (Y) Yes
                        (N) No
                        """, PrintMenu.sandwichMenu(), currentSandwich.toString("Current sandwich:"));
                // Get first character of user input
                char chooseMeatExtraOption = getValidInput(String.class).charAt(0);
                // Assign correct isExtra boolean
                switch (chooseMeatExtraOption) {
                    case 'y' -> {
                        isExtra = true;
                        isRunning = false;
                    }
                    case 'n' -> isRunning = false;
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            // Add meat to SandwichOrder
            currentSandwich.addMeat(new PremiumToppingMeat(meatType, isExtra));
            PrintColumns.threeColumns("""
                    Would you like to add another meat?
                    (Y) Yes
                    (N) No
                    """, PrintMenu.sandwichMenu(), currentSandwich.toString("Current sandwich:"));
            isRunning = true;
            while (isRunning) {
                char chooseAnotherMeatOption = getValidInput(String.class).charAt(0);
                switch (chooseAnotherMeatOption) {
                    case 'y' -> isRunning = false;
                    case 'n' -> {
                        return;
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
        }
    }

    private static void addSandwichCheese(SandwichOrder currentSandwich) {

        while (true) {
            CheeseType cheeseType = null;
            boolean isRunning = true;
            while (isRunning) {
                // Print options
                PrintColumns.threeColumns("""
                        What cheese would you like to add to your sandwich?
                            (1) American
                            (2) Swiss
                            (3) Cheddar
                            (4) Provolone
                            (0) None
                        """, PrintMenu.sandwichMenu(), currentSandwich.toString("Current sandwich:"));
                // Get first character of user input
                char chooseCheeseMenuOption = getValidInput(String.class).charAt(0);
                // Assign correct CheeseType
                switch (chooseCheeseMenuOption) {
                    case '1' -> {
                        cheeseType = CheeseType.AMERICAN;
                        isRunning = false;
                    }
                    case '2' -> {
                        cheeseType = CheeseType.SWISS;
                        isRunning = false;
                    }
                    case '3' -> {
                        cheeseType = CheeseType.CHEDDAR;
                        isRunning = false;
                    }
                    case '4' -> {
                        cheeseType = CheeseType.PROVOLONE;
                        isRunning = false;
                    }
                    case '0' -> {
                        return;
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            // Ask for extra cheese
            boolean isExtra = false;
            isRunning = true;
            while (isRunning) {
                PrintColumns.threeColumns("""
                            Would you like extra of that cheese?
                            (Y) Yes
                            (N) No
                        """, PrintMenu.sandwichMenu(), currentSandwich.toString("Current sandwich:"));
                char chooseCheeseExtraOption = getValidInput(String.class).charAt(0);
                // Assign correct isExtra boolean value
                switch (chooseCheeseExtraOption) {
                    case 'y' -> {
                        isExtra = true;
                        isRunning = false;
                    }
                    case 'n' -> isRunning = false;
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            // Add cheese to sandwich
            currentSandwich.addCheese(new PremiumToppingCheese(cheeseType, isExtra));
            // Ask if they want another
            PrintColumns.threeColumns("""
                    Would you like to add another cheese?
                    (Y) Yes
                    (N) No
                    """, PrintMenu.sandwichMenu(), currentSandwich.toString("Current sandwich:"));
            isRunning = true;
            while (isRunning) {
                char chooseAnotherCheeseOption = getValidInput(String.class).charAt(0);
                switch (chooseAnotherCheeseOption) {
                    case 'y' -> isRunning = false; // loop adds another
                    case 'n' -> {
                        return; // done with cheese selection
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
        }
    }

    private static void addSandwichToppings(SandwichOrder currentSandwich) {

        while (true) {
            RegularToppingType toppingType = null;
            boolean isRunning = true;
            while (isRunning) {
                // Print options
                PrintColumns.threeColumns("""
                        What topping would you like to add to your sandwich?
                            (1) Lettuce
                            (2) Tomato
                            (3) Onion
                            (4) Peppers
                            (5) Jalapeños
                            (6) Pickles
                            (7) Olives
                            (8) Spinach
                            (9) Mushrooms
                            (0) None
                        """, PrintMenu.sandwichMenu(), currentSandwich.toString("Current sandwich:"));
                // Get first character of user input
                char chooseToppingMenuOption = getValidInput(String.class).charAt(0);
                // Assign RegularToppingType
                switch (chooseToppingMenuOption) {
                    case '1' -> {
                        toppingType = RegularToppingType.LETTUCE;
                        isRunning = false;
                    }
                    case '2' -> {
                        toppingType = RegularToppingType.TOMATO;
                        isRunning = false;
                    }
                    case '3' -> {
                        toppingType = RegularToppingType.ONION;
                        isRunning = false;
                    }
                    case '4' -> {
                        toppingType = RegularToppingType.PEPPERS;
                        isRunning = false;
                    }
                    case '5' -> {
                        toppingType = RegularToppingType.JALAPENOS;
                        isRunning = false;
                    }
                    case '6' -> {
                        toppingType = RegularToppingType.PICKLES;
                        isRunning = false;
                    }
                    case '7' -> {
                        toppingType = RegularToppingType.OLIVES;
                        isRunning = false;
                    }
                    case '8' -> {
                        toppingType = RegularToppingType.SPINACH;
                        isRunning = false;
                    }
                    case '9' -> {
                        toppingType = RegularToppingType.MUSHROOMS;
                        isRunning = false;
                    }
                    case '0' -> {
                        return;
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            // Ask for extra topping
            boolean isExtra = false;
            isRunning = true;
            while (isRunning) {
                PrintColumns.threeColumns("""
                            Would you like extra of that topping?
                            (Y) Yes
                            (N) No
                        """, PrintMenu.sandwichMenu(), currentSandwich.toString("Current sandwich:"));
                char chooseToppingExtraOption = getValidInput(String.class).charAt(0);
                switch (chooseToppingExtraOption) {
                    case 'y' -> {
                        isExtra = true;
                        isRunning = false;
                    }
                    case 'n' -> isRunning = false;
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            // Add topping to sandwich
            currentSandwich.addRegularTopping(new RegularTopping(toppingType, isExtra));
            // Ask if they want another topping
            PrintColumns.threeColumns("""
                    Would you like to add another topping?
                    (Y) Yes
                    (N) No
                    """, PrintMenu.sandwichMenu(), currentSandwich.toString("Current sandwich:"));
            isRunning = true;
            while (isRunning) {
                char chooseAnotherToppingOption = getValidInput(String.class).charAt(0);
                switch (chooseAnotherToppingOption) {
                    case 'y' -> isRunning = false; // Loop continues
                    case 'n' -> {
                        return; // Done adding toppings
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
        }
    }

    private static void addSandwichSauces(SandwichOrder currentSandwich) {

        while (true) {
            SauceType sauceType = null;
            boolean isRunning = true;
            while (isRunning) {
                // Print options
                PrintColumns.threeColumns("""
                        What sauce would you like to add to your sandwich?
                            (1) Mayo
                            (2) Mustard
                            (3) Guacamole
                            (4) Pesto
                            (5) Ranch
                            (6) Caesar
                            (0) None
                        """, PrintMenu.sandwichMenu(), currentSandwich.toString("Current sandwich:"));
                // Get first character of user input
                char chooseSauceOption = getValidInput(String.class).charAt(0);
                // Assign correct SauceType
                switch (chooseSauceOption) {
                    case '1' -> {
                        sauceType = SauceType.MAYO;
                        isRunning = false;
                    }
                    case '2' -> {
                        sauceType = SauceType.MUSTARD;
                        isRunning = false;
                    }
                    case '3' -> {
                        sauceType = SauceType.GUACAMOLE;
                        isRunning = false;
                    }
                    case '4' -> {
                        sauceType = SauceType.PESTO;
                        isRunning = false;
                    }
                    case '5' -> {
                        sauceType = SauceType.RANCH;
                        isRunning = false;
                    }
                    case '6' -> {
                        sauceType = SauceType.CAESAR;
                        isRunning = false;
                    }
                    case '0' -> {
                        System.out.println("Returning to previous menu...");
                        return;
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            // Add Sauce to SandwichOrder
            currentSandwich.addSauce(new Sauce(sauceType));
            // Ask if they want another
            PrintColumns.threeColumns("""
                    Would you like to add another sauce?
                    (Y) Yes
                    (N) No
                    """, PrintMenu.sandwichMenu(), currentSandwich.toString("Current sandwich:"));
            isRunning = true;
            while (isRunning) {
                // Get first character of user input
                char chooseAnotherSauceOption = getValidInput(String.class).charAt(0);
                switch (chooseAnotherSauceOption) {
                    case 'y' -> isRunning = false; // Continue loop
                    case 'n' -> {
                        return; // Done adding sauces
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
        }
    }

    private static void addSandwichSides(SandwichOrder currentSandwich) {

        while (true) {
            SideType sideType = null;
            boolean isRunning = true;
            while (isRunning) {
                // Print options
                PrintColumns.threeColumns("""
                        What side would you like to add?
                            (1) Pickles
                            (2) Fries
                            (0) None
                        """, PrintMenu.sandwichMenu(), currentSandwich.toString("Current sandwich:"));
                // Get first character of user input
                char chooseSideOption = getValidInput(String.class).charAt(0);
                // Assign correct SideType
                switch (chooseSideOption) {
                    case '1' -> {
                        sideType = SideType.PICKLES;
                        isRunning = false;
                    }
                    case '2' -> {
                        sideType = SideType.FRIES;
                        isRunning = false;
                    }
                    case '0' -> {
                        System.out.println("Returning to previous menu...");
                        return;
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            // Add selected side
            currentSandwich.addSide(new Side(sideType));
            // Ask if they want another
            PrintColumns.threeColumns("""
                    Would you like to add another side?
                    (Y) Yes
                    (N) No
                    """, PrintMenu.sandwichMenu(), currentSandwich.toString("Current sandwich:"));
            isRunning = true;
            while (isRunning) {
                char chooseAnotherSideOption = getValidInput(String.class).charAt(0);
                switch (chooseAnotherSideOption) {
                    case 'y' -> isRunning = false; // Loop again
                    case 'n' -> {
                        return;
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
        }
    }

    private static void addDrink() {

        Size drinkSize = null;
        boolean isRunning = true;
        while (isRunning) {
            // Print options
            PrintColumns.twoColumns("""
                    What size of drink would you like?
                    (S) Small
                    (M) Medium
                    (L) Large
                    (0) Cancel drink order
                    """, PrintMenu.drinksMenu());
            // Get first character of user input
            char addDrinkMenuOption = getValidInput(String.class).charAt(0);
            // Assign correct size
            switch (addDrinkMenuOption) {
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

        DrinkType drinkType = null;
        isRunning = true;
        while (isRunning) {
            // Print options
            PrintColumns.twoColumns("""
                    What type of drink would you like?
                    (1) KO-KUH
                    (2) SPRY-TUH
                    (3) PEP-UH-SEE
                    (4) DOK-TUH PEP-UH
                    (5) MONS-TUH
                    (0) Cancel drink order
                    """, PrintMenu.drinksMenu());
            // Get first character of user input
            char chooseBreadMenuOption = getValidInput(String.class).charAt(0);
            // Assign correct DrinkType
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
        // Add Drink to customerOrder
        customerOrder.getMenuItems().add(new Drink(drinkType, drinkSize));
    }

    private static void addChips() {

        ChipsType chipsType = null;
        boolean isRunning = true;
        while (isRunning) {
            // Print options
            PrintColumns.twoColumns("""
                    What type of chips would you like?
                    (1) Po-Tay-Tohz
                    (2) Free-Tohz
                    (3) Toasty-Tohz
                    (4) Taki-Tohz
                    (5) Dory-Tohz
                    (0) Cancel chips order
                    """, PrintMenu.chipsMenu());
            // Get first character of user input
            char chooseChipsMenuOption = getValidInput(String.class).charAt(0);
            // Assign correct ChipsType
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
                    return;  // Exit the method
                }
                default -> System.out.println("Invalid menu option, please try again.");
            }
        }
        // Add Chips to customerOrder
        customerOrder.getMenuItems().add(new Chips(chipsType));
    }

    private static <T> T getValidInput(Class<T> type) {

        // Initialize String and parsedValue
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
            // Check if parsedValue is null before looping
            if (parsedValue != null) {
                return parsedValue;
            } else {
                System.out.println("Sorry, I don't know what you mean, please try again.");
            }
        }
    }

}
