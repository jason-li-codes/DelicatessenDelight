package com.pluralsight.fooditems.sandwich;

import com.pluralsight.fooditems.enums.CheeseType;
import com.pluralsight.fooditems.enums.MeatType;
import com.pluralsight.fooditems.enums.RegularToppingType;
import com.pluralsight.utilizedclasses.FixedArrayList;
import com.pluralsight.fooditems.MenuItem;
import com.pluralsight.fooditems.enums.Size;

public class SandwichOrder extends MenuItem {

    private Bread bread;
    private Size size;
    private final FixedArrayList<PremiumToppingMeat> premiumToppingMeats;
    private final FixedArrayList<PremiumToppingCheese> premiumToppingCheeses;
    private final FixedArrayList<RegularTopping> regularToppings;
    private final FixedArrayList<Sauce> sauces;
    private final FixedArrayList<Side> sides;
    private boolean isToasted;

    public SandwichOrder(Bread bread, Size size) {
        this.bread = bread;
        this.size = size;
        this.premiumToppingMeats = new FixedArrayList<>(2);
        this.premiumToppingCheeses = new FixedArrayList<>(2);
        this.regularToppings = new FixedArrayList<>(5);
        this.sauces = new FixedArrayList<>(3);
        this.sides = new FixedArrayList<>(2);
        this.isToasted = false;
        this.calories = bread.getCalories();
        this.price = switch (size) {
            case SMALL -> 5.50;
            case MEDIUM -> 7;
            case LARGE -> 8.50;
        };
    }

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

    public void addMeat(PremiumToppingMeat premiumToppingMeat) {
        try {
            this.premiumToppingMeats.add(premiumToppingMeat);
            updateCalories();
            updatePrice();
        } catch (IllegalArgumentException e) {
            System.out.println(premiumToppingMeat + " not added, you may only have up to 2 meats in your sandwich.");
        }
    }

    public void addCheese(PremiumToppingCheese premiumToppingCheese) {
        try {
            this.premiumToppingCheeses.add(premiumToppingCheese);
            updateCalories();
            updatePrice();
        } catch (IllegalArgumentException e) {
            System.out.println(premiumToppingCheese + " not added, you may only have up to 2 cheeses in your sandwich.");
        }
    }

    public void addRegularTopping(RegularTopping regularTopping) {
        try {
            this.regularToppings.add(regularTopping);
            updateCalories();
        } catch (IllegalArgumentException e) {
            System.out.println(regularTopping + " not added, you may only have up to 5 toppings in your sandwich.");
        }
    }

    public void addSauce(Sauce sauce) {
        try {
            this.sauces.add(sauce);
            updateCalories();
        } catch (IllegalArgumentException e) {
            System.out.println(sauce + " not added, you may only have up to 3 sauces in your sandwich.");
        }
    }

    public void addSide(Side side) {
        try {
            this.sides.add(side);
            updateCalories();
        } catch (IllegalArgumentException e) {
            System.out.println(side + " not added, you may only have up to 2 sides with your sandwich.");
        }
    }

    public void removeMeat(int index) {
        try {
            PremiumToppingMeat thisMeat = this.premiumToppingMeats.getItems().remove(index);
            System.out.println(thisMeat + " removed.");
            updateCalories();
            updatePrice();
        } catch (Exception e) {
            System.out.println("Error removing meat: " + e.getMessage());
        }
    }

    public void removeCheese(int index) {
        try {
            PremiumToppingCheese thisCheese = this.premiumToppingCheeses.getItems().remove(index);
            System.out.println(thisCheese + " removed.");
            updateCalories();
            updatePrice();
        } catch (Exception e) {
            System.out.println("Error removing cheese: " + e.getMessage());
        }
    }

    public void removeRegularTopping(int index) {
        try {
            RegularTopping thisRegularTopping = this.regularToppings.getItems().remove(index);
            System.out.println(thisRegularTopping + " removed.");
            updateCalories();
        } catch (Exception e) {
            System.out.println("Error removing topping: " + e.getMessage());
        }
    }

    public void removeSauce(int index) {
        try {
            Sauce thisSauce = this.sauces.getItems().remove(index);
            System.out.println(thisSauce + " removed.");
            updateCalories();
        } catch (Exception e) {
            System.out.println("Error removing sauce: " + e.getMessage());
        }
    }

    public void removeSide(int index) {
        try {
            Side thisSide = this.sides.getItems().remove(index);
            System.out.println(thisSide + " removed.");
            updateCalories();
        } catch (Exception e) {
            System.out.println("Error removing side: " + e.getMessage());
        }
    }

    public void updateMeatType(int index, MeatType meatType) {
        this.premiumToppingMeats.getItems().get(index).setMeatType(meatType);
        updateCalories();
    }

    public void updateCheeseType(int index, CheeseType cheeseType) {
        this.premiumToppingCheeses.getItems().get(index).setCheeseType(cheeseType);
        updateCalories();
    }

    public void updateRegularToppingType(int index, RegularToppingType RegularToppingType) {
        this.regularToppings.getItems().get(index).setRegularToppingType(RegularToppingType);
        updateCalories();
    }

    public void updateMeatExtra(int index, boolean isExtra) {
        this.premiumToppingMeats.getItems().get(index).setExtra(isExtra);
        updateCalories();
        updatePrice();
    }

    public void updateCheeseExtra(int index, boolean isExtra) {
        this.premiumToppingCheeses.getItems().get(index).setExtra(isExtra);
        updateCalories();
        updatePrice();
    }

    public void updateRegularToppingExtra(int index, boolean isExtra) {
        this.regularToppings.getItems().get(index).setExtra(isExtra);
        updateCalories();
    }

    public void updatePrice() {

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

        price = totalPrice;
    }

    public void updateCalories() {

        int totalCal = 0;
        totalCal += bread.getCalories();
        totalCal += premiumToppingMeats.getItems().stream()
                .mapToInt(PremiumToppingMeat::getCalories) // Extract calories from each meat topping
                .sum();
        totalCal += premiumToppingCheeses.getItems().stream()
                .mapToInt(PremiumToppingCheese::getCalories) // Extract calories from each cheese topping
                .sum();
        totalCal += regularToppings.getItems().stream()
                .mapToInt(RegularTopping::getCalories) // Extract calories from each regular topping
                .sum();
        totalCal += sauces.getItems().stream()
                .mapToInt(Sauce::getCalories) // Extract calories from each sauce
                .sum();
        totalCal += sides.getItems().stream()
                .mapToInt(Side::getCalories) // Extract calories from each side
                .sum();

        this.calories = totalCal * switch (size) {
            case SMALL -> 1;
            case MEDIUM -> 2;
            case LARGE -> 3;
        };
    }

    @Override
    public String toString(String title) {

        StringBuilder receiptLine = new StringBuilder();
        // Add Header
        receiptLine.append(title).append("\n")
                .append("=====================================\n");
        // Add basic order information
        receiptLine.append(String.format("Size: %s\n", getSize()));
        receiptLine.append(String.format("Bread: %s\n", getBread().getBreadType()));
        // Add Toasting Option
        receiptLine.append("Toasted: ").append(isToasted() ? "Yes" : "No").append("\n");
        // Add Meats
        if (!getPremiumToppingMeats().getItems().isEmpty()) {
            receiptLine.append("Meats:\n");
            for (PremiumToppingMeat meat : getPremiumToppingMeats().getItems()) {
                receiptLine.append(" - ").append(meat.getMeatType()).append(" (")
                        .append(meat.isExtra() ? "Extra" : "Regular").append(")\n");
            }
        } else {
            receiptLine.append("No meats selected.\n");
        }
        // Add Cheeses
        if (!getPremiumToppingCheeses().getItems().isEmpty()) {
            receiptLine.append("Cheeses:\n");
            for (PremiumToppingCheese cheese : getPremiumToppingCheeses().getItems()) {
                receiptLine.append(" - ").append(cheese.getCheeseType()).append(" (")
                        .append(cheese.isExtra() ? "Extra" : "Regular").append(")\n");
            }
        } else {
            receiptLine.append("No cheeses selected.\n");
        }
        // Add Regular Toppings
        if (!getRegularToppings().getItems().isEmpty()) {
            receiptLine.append("Toppings:\n");
            for (RegularTopping topping : getRegularToppings().getItems()) {
                receiptLine.append(" - ").append(topping.getRegularToppingType()).append("\n");
            }
        } else {
            receiptLine.append("No toppings selected.\n");
        }
        // Add Sauces
        if (!getSauces().getItems().isEmpty()) {
            receiptLine.append("Sauces:\n");
            for (Sauce sauce : getSauces().getItems()) {
                receiptLine.append(" - ").append(sauce.getSauceType()).append("\n");
            }
        } else {
            receiptLine.append("No sauces selected.\n");
        }
        // Add Sides
        if (!getSides().getItems().isEmpty()) {
            receiptLine.append("Sides:\n");
            for (Side side : getSides().getItems()) {
                receiptLine.append("  - ").append(side.getSideType()).append("\n");
            }
        } else {
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
