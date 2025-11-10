package com.pluralsight.fooditems.sandwich;

import com.pluralsight.utilizedclasses.FixedArrayList;
import com.pluralsight.fooditems.MenuItem;
import com.pluralsight.fooditems.Size;

public class SandwichOrder implements MenuItem {

    private Bread bread;
    private final FixedArrayList<PremiumToppingMeat> premiumToppingMeats;
    private final FixedArrayList<PremiumToppingCheese> premiumToppingCheeses;
    private final FixedArrayList<RegularTopping> regularToppings;
    private final FixedArrayList<Sauce> sauces;
    private Size size;
    private boolean isToasted;
    private final FixedArrayList<Side> sides;

    public SandwichOrder(Bread bread) {
        this.bread = bread;
        this.premiumToppingMeats = new FixedArrayList<>(2);
        this.premiumToppingCheeses = new FixedArrayList<>(2);
        this.regularToppings = new FixedArrayList<>(5);
        this.sauces = new FixedArrayList<>(3);
        this.isToasted = false;
        this.sides = new FixedArrayList<>(2);
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
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void addMeat(PremiumToppingMeat premiumToppingMeat) {
        try {
            this.premiumToppingMeats.add(premiumToppingMeat);
        } catch (IllegalArgumentException e) {
            System.out.println(premiumToppingMeat + " not added, you may only have up to 2 meats in your sandwich.");
        }
    }

    public void addCheese(PremiumToppingCheese premiumToppingCheese) {
        try {
            this.premiumToppingCheeses.add(premiumToppingCheese);
        } catch (IllegalArgumentException e) {
            System.out.println(premiumToppingCheese + " not added, you may only have up to 2 cheeses in your sandwich.");
        }
    }

    public void addRegularTopping(RegularTopping regularTopping) {
        try {
            this.regularToppings.add(regularTopping);
        } catch (IllegalArgumentException e) {
            System.out.println(regularTopping + " not added, you may only have up to 5 toppings in your sandwich.");
        }
    }

    public void addSauce(Sauce sauce) {
        try {
            this.sauces.add(sauce);
        } catch (IllegalArgumentException e) {
            System.out.println(sauce + " not added, you may only have up to 3 sauces in your sandwich.");
        }
    }

    public void addSide(Side side) {
        try {
            this.sides.add(side);
        } catch (IllegalArgumentException e) {
            System.out.println(side + " not added, you may only have up to 2 sides with your sandwich.");
        }
    }

    public void removeMeat(int index) {
        try {
            PremiumToppingMeat thisMeat = this.premiumToppingMeats.getItems().remove(index);
            System.out.println(thisMeat + " removed.");
        } catch (Exception e) {
            System.out.println("Error removing meat: " + e.getMessage());
        }
    }

    public void removeCheese(int index) {
        try {
            PremiumToppingCheese thisCheese = this.premiumToppingCheeses.getItems().remove(index);
            System.out.println(thisCheese + " removed.");
        } catch (Exception e) {
            System.out.println("Error removing cheese: " + e.getMessage());
        }
    }

    public void removeRegularTopping(int index) {
        try {
            RegularTopping thisRegularTopping = this.regularToppings.getItems().remove(index);
            System.out.println(thisRegularTopping + " removed.");
        } catch (Exception e) {
            System.out.println("Error removing topping: " + e.getMessage());
        }
    }

    public void removeSauce(int index) {
        try {
            Sauce thisSauce = this.sauces.getItems().remove(index);
            System.out.println(thisSauce + " removed.");
        } catch (Exception e) {
            System.out.println("Error removing sauce: " + e.getMessage());
        }
    }

    public void removeSide(int index) {
        try {
            Side thisSide = this.sides.getItems().remove(index);
            System.out.println(thisSide + " removed.");
        } catch (Exception e) {
            System.out.println("Error removing side: " + e.getMessage());
        }
    }

    public void updateMeatType(int index, MeatType meatType) {
        this.premiumToppingMeats.getItems().get(index).setMeatType(meatType);
    }

    public void updateCheeseType(int index, CheeseType cheeseType) {
        this.premiumToppingCheeses.getItems().get(index).setCheeseType(cheeseType);
    }

    public void updateRegularToppingType(int index, RegularToppingType RegularToppingType) {
        this.regularToppings.getItems().get(index).setRegularToppingType(RegularToppingType);
    }

    public void updateMeatExtra(int index, boolean isExtra) {
        this.premiumToppingMeats.getItems().get(index).setExtra(isExtra);
    }

    public void updateCheeseExtra(int index, boolean isExtra) {
        this.premiumToppingCheeses.getItems().get(index).setExtra(isExtra);
    }

    public void updateRegularToppingExtra(int index, boolean isExtra) {
        this.regularToppings.getItems().get(index).setExtra(isExtra);
    }

    @Override
    public double getPrice() {

        double totalPrice = 0;

        totalPrice += switch (size) {
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

        return totalPrice;
    }

    @Override
    public int getCalories() {

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

        return switch (size) {
            case SMALL -> totalCal;
            case MEDIUM -> totalCal * 2;
            case LARGE -> totalCal * 3;
        };
    }
}
