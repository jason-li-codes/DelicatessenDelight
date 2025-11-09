package com.pluralsight.fooditems.sandwich;

public class RegularTopping implements Ingredient {

    private final RegularToppingType regularToppingType;
    private boolean isExtra;

    // Constructor to set the calories value for each regular topping
    RegularTopping(RegularToppingType regularToppingType, boolean isExtra) {
        this.regularToppingType = regularToppingType;
        this.isExtra = isExtra;
    }

    // Getter method to retrieve the calories value
    @Override
    public int getCalories() {
        return regularToppingType.getCalories();
    }

    @Override
    public boolean isExtra() {
        return isExtra;
    }

    // Setter to mark the topping as extra
    public void setExtra(boolean isExtra) {
        this.isExtra = isExtra;
    }
}
