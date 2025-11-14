package com.pluralsight.utilizedclasses;

import com.pluralsight.fooditems.*;
import com.pluralsight.fooditems.enums.*;
import com.pluralsight.fooditems.sandwich.*;

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
                    (0) Return to main menu
                    """);
            char orderMenuOption = getValidInput(String.class, false).charAt(0);
            switch (orderMenuOption) {
                case '1' -> beginSandwich();
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

    public static void beginSandwich() {

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

        addSandwichMeat(currentSandwich);
        addSandwichCheese(currentSandwich);
        addSandwichToppings(currentSandwich);
        addSandwichSauces(currentSandwich);
        addSandwichSides(currentSandwich);
    }

    private static void addSandwichMeat(SandwichOrder currentSandwich) {

        System.out.println(currentSandwich.toString("Current order:"));

        boolean isRunning = true;
        while (isRunning) {
            MeatType meatType = null;
            System.out.println("""
                    What meat would you like to add to your sandwich?
                        (1) Turkey
                        (2) Ham
                        (3) Chicken
                        (4) Roast Beef
                        (5) Pastrami
                        (6) Bacon
                        (0) None
                    """);
            while (isRunning) {
                char chooseMeatMenuOption = getValidInput(String.class, false).charAt(0);
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
                System.out.println("""
                        Would you like extra of that?
                        (Y) Yes
                        (N) No
                        """);
                char chooseMeatExtraOption = getValidInput(String.class, false).charAt(0);
                switch (chooseMeatExtraOption) {
                    case 'Y' -> {
                        isExtra = true;
                        isRunning = false;
                    }
                    case 'N' -> isRunning = false;
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            currentSandwich.addMeat(new PremiumToppingMeat(meatType, isExtra));
            System.out.println("""
                    Would you like to add another meat?
                    (Y) Yes
                    (N) No
                    """);
            isRunning = true;
            while (isRunning) {
                char chooseAnotherMeatOption = getValidInput(String.class, false).charAt(0);
                switch (chooseAnotherMeatOption) {
                    case 'Y' -> isRunning = false;
                    case 'N' -> {
                        return;
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            isRunning = true;
        }
    }

    private static void addSandwichCheese(SandwichOrder currentSandwich) {

        System.out.println(currentSandwich.toString("Current order:"));

        boolean isRunning = true;
        while (isRunning) {
            CheeseType cheeseType = null;
            System.out.println("""
                    What cheese would you like to add to your sandwich?
                        (1) American
                        (2) Swiss
                        (3) Cheddar
                        (4) Provolone
                        (0) None
                    """);
            // Select cheese
            while (isRunning) {
                char chooseCheeseMenuOption = getValidInput(String.class, false).charAt(0);
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
                System.out.println("""
                        Would you like extra of that cheese?
                        (Y) Yes
                        (N) No
                        """);
                char chooseCheeseExtraOption = getValidInput(String.class, false).charAt(0);
                switch (chooseCheeseExtraOption) {
                    case 'Y' -> {
                        isExtra = true;
                        isRunning = false;
                    }
                    case 'N' -> isRunning = false;
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            // Add cheese to sandwich
            currentSandwich.addCheese(new PremiumToppingCheese(cheeseType, isExtra));
            // Ask if they want another
            System.out.println("""
                    Would you like to add another cheese?
                    (Y) Yes
                    (N) No
                    """);
            isRunning = true;
            while (isRunning) {
                char chooseAnotherCheeseOption = getValidInput(String.class, false).charAt(0);
                switch (chooseAnotherCheeseOption) {
                    case 'Y' -> isRunning = false; // loop adds another
                    case 'N' -> {
                        return; // done with cheese selection
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            isRunning = true;
        }
    }

    private static void addSandwichToppings(SandwichOrder currentSandwich) {

        System.out.println(currentSandwich.toString("Current order:"));

        boolean isRunning = true;
        while (isRunning) {
            RegularToppingType toppingType = null;

            System.out.println("""
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
                    """);
            // Select topping
            while (isRunning) {
                char chooseToppingMenuOption = getValidInput(String.class, false).charAt(0);
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
                System.out.println("""
                        Would you like extra of that topping?
                        (Y) Yes
                        (N) No
                        """);
                char chooseToppingExtraOption = getValidInput(String.class, false).charAt(0);
                switch (chooseToppingExtraOption) {
                    case 'Y' -> {
                        isExtra = true;
                        isRunning = false;
                    }
                    case 'N' -> isRunning = false;
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            // Add topping to sandwich
            currentSandwich.addRegularTopping(new RegularTopping(toppingType, isExtra));
            // Ask if they want another topping
            System.out.println("""
                    Would you like to add another topping?
                    (Y) Yes
                    (N) No
                    """);
            isRunning = true;
            while (isRunning) {
                char chooseAnotherToppingOption = getValidInput(String.class, false).charAt(0);
                switch (chooseAnotherToppingOption) {
                    case 'Y' -> isRunning = false; // loop continues
                    case 'N' -> {
                        return; // done adding toppings
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            isRunning = true;
        }
    }

    private static void addSandwichSauces(SandwichOrder currentSandwich) {

        System.out.println(currentSandwich.toString("Current order:"));
        boolean isRunning = true;
        while (isRunning) {
            SauceType sauceType = null;
            System.out.println("""
                    What sauce would you like to add to your sandwich?
                        (1) Mayo
                        (2) Mustard
                        (3) Guacamole
                        (4) Pesto
                        (5) Ranch
                        (6) Caesar
                        (0) None
                    """);
            // Select sauce
            while (isRunning) {
                char chooseSauceOption = getValidInput(String.class, false).charAt(0);
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
            currentSandwich.addSauce(new Sauce(sauceType));
            // Ask if they want another
            System.out.println("""
                    Would you like to add another sauce?
                    (Y) Yes
                    (N) No
                    """);
            isRunning = true;
            while (isRunning) {
                char chooseAnotherSauceOption = getValidInput(String.class, false).charAt(0);
                switch (chooseAnotherSauceOption) {
                    case 'Y' -> isRunning = false; // continue loop
                    case 'N' -> {
                        return; // done adding sauces
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            isRunning = true;
        }
    }

    private static void addSandwichSides(SandwichOrder currentSandwich) {

        System.out.println(currentSandwich.toString("Current order:"));

        boolean isRunning = true;
        while (isRunning) {
            SideType sideType = null;
            System.out.println("""
                What side would you like to add?
                    (1) Pickles
                    (2) Fries
                    (0) None
                """);
            // Select side
            while (isRunning) {
                char chooseSideOption = getValidInput(String.class, false).charAt(0);
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
            System.out.println("""
                Would you like to add another side?
                (Y) Yes
                (N) No
                """);
            isRunning = true;
            while (isRunning) {
                char chooseAnotherSideOption = getValidInput(String.class, false).charAt(0);
                switch (chooseAnotherSideOption) {
                    case 'Y' -> isRunning = false; // loop again
                    case 'N' -> {
                        return; // finish
                    }
                    default -> System.out.println("Invalid menu option, please try again.");
                }
            }
            isRunning = true;
        }
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
