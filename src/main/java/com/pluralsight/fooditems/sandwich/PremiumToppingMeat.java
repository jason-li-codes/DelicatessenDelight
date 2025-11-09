package com.pluralsight.fooditems.sandwich;

public class PremiumToppingMeat implements Ingredient {

    private final MeatType meatType;
    private boolean isExtra;

    // Constructor to set the calories value for each premium cheese topping
    PremiumToppingMeat(MeatType meatType, boolean isExtra) {
        this.meatType = meatType;
        this.isExtra = isExtra;
    }

    // Getter method to retrieve the calories value
    @Override
    public int getCalories() {
        return meatType.getCalories();
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
