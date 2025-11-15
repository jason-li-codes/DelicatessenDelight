package com.pluralsight.fooditems.sandwich;

import com.pluralsight.utilizedclasses.FixedArrayList;
import com.pluralsight.fooditems.MenuItem;
import com.pluralsight.fooditems.enums.Size;

public class SandwichOrder extends MenuItem {

    // SandwichOrder takes in all the following attributes, with several using FixedArrayLists
    private Bread bread;
    private Size size;
    private final FixedArrayList<PremiumToppingMeat> premiumToppingMeats;
    private final FixedArrayList<PremiumToppingCheese> premiumToppingCheeses;
    private final FixedArrayList<RegularTopping> regularToppings;
    private final FixedArrayList<Sauce> sauces;
    private final FixedArrayList<Side> sides;
    private boolean isToasted;

    // Constructor for SandwichOrder only requires a Bread and Size
    public SandwichOrder(Bread bread, Size size) {
        this.bread = bread;
        this.size = size;
        // FixedArrayLists are initialized with appropriate limits
        this.premiumToppingMeats = new FixedArrayList<>(2);
        this.premiumToppingCheeses = new FixedArrayList<>(2);
        this.regularToppings = new FixedArrayList<>(5);
        this.sauces = new FixedArrayList<>(3);
        this.sides = new FixedArrayList<>(2);
        this.isToasted = false;
        // Default calories are set based on bread
        this.calories = bread.getCalories();
        // Default price is set based on size
        this.price = switch (size) {
            case SMALL -> 5.50;
            case MEDIUM -> 7;
            case LARGE -> 8.50;
        };
    }

    // Getters and setters
    public Bread getBread() {
        return bread;
    }

    public FixedArrayList<PremiumToppingMeat> getPremiumToppingMeats() {
        return premiumToppingMeats;
    }

    public FixedArrayList<PremiumToppingCheese> getPremiumToppingCheeses() {
        return premiumToppingCheeses;
    }

    public FixedArrayList<RegularTopping> getRegularToppings() {
        return regularToppings;
    }

    public FixedArrayList<Sauce> getSauces() {
        return sauces;
    }

    public Size getSize() {
        return size;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public FixedArrayList<Side> getSides() {
        return sides;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
        updateCalories();
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public void setSize(Size size) {
        this.size = size;
        updateCalories();
        updatePrice();
    }

    // Custom adding methods which use try/catch blocks to avoid going over FixedArrayList limits
    // Each method updates calories and price attributes accordingly
    public void addMeat(PremiumToppingMeat premiumToppingMeat) {
        try {
            this.premiumToppingMeats.add(premiumToppingMeat);
            updateCalories();
            updatePrice();
        } catch (IllegalArgumentException e) {
            System.out.println(premiumToppingMeat.getMeatType().name() + " not added, you may only have up to 2 meats in your sandwich.");
        }
    }

    public void addCheese(PremiumToppingCheese premiumToppingCheese) {
        try {
            this.premiumToppingCheeses.add(premiumToppingCheese);
            updateCalories();
            updatePrice();
        } catch (IllegalArgumentException e) {
            System.out.println(premiumToppingCheese.getCheeseType().name() + " not added, you may only have up to 2 cheeses in your sandwich.");
        }
    }

    public void addRegularTopping(RegularTopping regularTopping) {
        try {
            this.regularToppings.add(regularTopping);
            updateCalories();
        } catch (IllegalArgumentException e) {
            System.out.println(regularTopping.getRegularToppingType().name() + " not added, you may only have up to 5 toppings in your sandwich.");
        }
    }

    public void addSauce(Sauce sauce) {
        try {
            this.sauces.add(sauce);
            updateCalories();
        } catch (IllegalArgumentException e) {
            System.out.println(sauce.getSauceType().name() + " not added, you may only have up to 3 sauces in your sandwich.");
        }
    }

    public void addSide(Side side) {
        try {
            this.sides.add(side);
            updateCalories();
        } catch (IllegalArgumentException e) {
            System.out.println(side.getSideType().name() + " not added, you may only have up to 2 sides with your sandwich.");
        }
    }

    // Update price of SandwichOrder by going through all attributes individually
    public void updatePrice() {

        // Base price depends on size
        double totalPrice = switch (size) {
            case SMALL -> 5.50;
            case MEDIUM -> 7;
            case LARGE -> 8.50;
        };

        // Calculate the total price for regular meats
        totalPrice += premiumToppingMeats.getItems().stream()
                // Map each item to its price based on the size (regular meat price)
                .mapToDouble(item -> switch (size) {
                    case SMALL -> 1;    // Regular meat price for small size
                    case MEDIUM -> 2;   // Regular meat price for medium size
                    case LARGE -> 3;    // Regular meat price for large size
                })
                .sum() +  // Sum the regular meat prices and add to total price

                // Calculate the total price for extra meats
                premiumToppingMeats.getItems().stream()
                        .filter(PremiumToppingMeat::isExtra)  // Filter the items where isExtra is true
                        .mapToDouble(item -> switch (size) {
                            case SMALL -> 0.50;   // Extra meat price for small size
                            case MEDIUM -> 1;     // Extra meat price for medium size
                            case LARGE -> 1.50;   // Extra meat price for large size
                        })
                        .sum();  // Sum all the extra meat prices

        // Calculate the total price for regular cheeses
        totalPrice += premiumToppingCheeses.getItems().stream()
                // Map each item to its price based on the size (regular cheese price)
                .mapToDouble(item -> switch (size) {
                    case SMALL -> 0.75;   // Regular cheese price for small size
                    case MEDIUM -> 1.50;  // Regular cheese price for medium size
                    case LARGE -> 2.25;   // Regular cheese price for large size
                })
                .sum() +  // Sum the regular cheese prices

                // Calculate the total price for extra cheeses
                premiumToppingCheeses.getItems().stream()
                        .filter(PremiumToppingCheese::isExtra)  // Filter the items where isExtra is true
                        .mapToDouble(item -> switch (size) {
                            case SMALL -> 0.30;   // Extra cheese price for small size
                            case MEDIUM -> 0.60;  // Extra cheese price for medium size
                            case LARGE -> 0.90;   // Extra cheese price for large size
                        })
                        .sum();  // Sum all the extra cheese prices
        // Update value by changing price attribute
        price = totalPrice;
    }

    // Update calories of SandwichOrder by going through all attributes individually
    public void updateCalories() {

        // Begin with integer of value 0
        int totalCal = 0;
        totalCal += bread.getCalories(); // Extract calories from bread
        totalCal += premiumToppingMeats.getItems().stream()
                .mapToInt(PremiumToppingMeat::getCalories) // Extract calories from each meat topping
                .sum() +
                premiumToppingMeats.getItems().stream()
                        .filter(PremiumToppingMeat::isExtra)  // Filter the items where isExtra is true
                        .mapToInt(PremiumToppingMeat::getCalories) // Get calories only for those extra
                        .sum();
        totalCal += premiumToppingCheeses.getItems().stream()
                .mapToInt(PremiumToppingCheese::getCalories) // Extract calories from each cheese topping
                .sum() +
                premiumToppingCheeses.getItems().stream()
                .filter(PremiumToppingCheese::isExtra)  // Filter the items where isExtra is true
                .mapToInt(PremiumToppingCheese::getCalories) // Get calories only for those extra
                .sum();
        totalCal += regularToppings.getItems().stream()
                .mapToInt(RegularTopping::getCalories) // Extract calories from each regular topping
                .sum() +
                regularToppings.getItems().stream()
                        .filter(RegularTopping::isExtra)  // Filter the items where isExtra is true
                        .mapToInt(RegularTopping::getCalories) // Get calories only for those extra
                        .sum();
        totalCal += sauces.getItems().stream()
                .mapToInt(Sauce::getCalories) // Extract calories from each sauce
                .sum();
        totalCal += sides.getItems().stream()
                .mapToInt(Side::getCalories) // Extract calories from each side
                .sum();

        // Use multiplier depending on SandwichOrder size
        this.calories = totalCal * switch (size) {
            case SMALL -> 1;
            case MEDIUM -> 2;
            case LARGE -> 3;
        };
    }

    // Overridden toString method, which outputs String with cleaner formatting
    @Override
    public String toString(String title) {

        // Use StringBuilder to build larger String with cleaner formatting
        StringBuilder receiptLine = new StringBuilder();
        // Add Header
        receiptLine.append(title).append("\n")
                .append("=====================================\n");
        // Add basic order information
        receiptLine.append(String.format("Size: %s\n", getSize().name()));
        receiptLine.append(String.format("Bread: %s\n", getBread().getBreadType().name()));
        // Add Toasting Option
        receiptLine.append("Toasted: ").append(isToasted() ? "Yes" : "No").append("\n");

        // For FixedArrayLists, use forEach methods to accurately read all attributes
        // Add Meats
        if (!getPremiumToppingMeats().getItems().isEmpty()) {
            receiptLine.append("Meats:\n");
            for (PremiumToppingMeat meat : getPremiumToppingMeats().getItems()) {
                receiptLine.append(" - ").append(meat.getMeatType().name().replace("_", " ")).append(" (")
                        .append(meat.isExtra() ? "Extra" : "Regular").append(")\n");
            }
        } else { // If FixedArrayList is empty, output custom N/A String
            receiptLine.append("No meats selected.\n");
        }
        // Add Cheeses
        if (!getPremiumToppingCheeses().getItems().isEmpty()) {
            receiptLine.append("Cheeses:\n");
            for (PremiumToppingCheese cheese : getPremiumToppingCheeses().getItems()) {
                receiptLine.append(" - ").append(cheese.getCheeseType().name()).append(" (")
                        .append(cheese.isExtra() ? "Extra" : "Regular").append(")\n");
            }
        } else { // If FixedArrayList is empty, output custom N/A String
            receiptLine.append("No cheeses selected.\n");
        }
        // Add Regular Toppings
        if (!getRegularToppings().getItems().isEmpty()) {
            receiptLine.append("Toppings:\n");
            for (RegularTopping topping : getRegularToppings().getItems()) {
                receiptLine.append(" - ").append(topping.getRegularToppingType().name()).append(" (")
                        .append(topping.isExtra() ? "Extra" : "Regular").append(")\n");
            }
        } else { // If FixedArrayList is empty, output custom N/A String
            receiptLine.append("No toppings selected.\n");
        }
        // Add Sauces
        if (!getSauces().getItems().isEmpty()) {
            receiptLine.append("Sauces:\n");
            for (Sauce sauce : getSauces().getItems()) {
                receiptLine.append(" - ").append(sauce.getSauceType().name()).append("\n");
            }
        } else { // If FixedArrayList is empty, output custom N/A String
            receiptLine.append("No sauces selected.\n");
        }
        // Add Sides
        if (!getSides().getItems().isEmpty()) {
            receiptLine.append("Sides:\n");
            for (Side side : getSides().getItems()) {
                receiptLine.append("  - ").append(side.getSideType().name()).append("\n");
            }
        } else { // If FixedArrayList is empty, output custom N/A String
            receiptLine.append("No sides selected.\n");
        }
        // Add Price and Calories
        receiptLine.append("=====================================\n")
                .append(String.format("Price: $%.2f\n", getPrice()))
                .append(String.format("Calories: %d\n", getCalories()));
        // Add Footer
        receiptLine.append("=====================================\n");
        // Return StringBuilder as String
        return receiptLine.toString();
    }

}
