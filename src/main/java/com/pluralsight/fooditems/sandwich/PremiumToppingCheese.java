package com.pluralsight.fooditems.sandwich;

public class PremiumToppingCheese extends SandwichFilling {

    private CheeseType cheeseType;
    private boolean isExtra;

    // Constructor to set the calories value for each premium cheese topping
    PremiumToppingCheese(CheeseType cheeseType, boolean isExtra) {
        this.cheeseType = cheeseType;
        this.isExtra = isExtra;
    }

    // Getter method to retrieve the calories value
    @Override
    public int getCalories() {
        return cheeseType.getCalories();
    }

    @Override
    public boolean isExtra() {
        return isExtra;
    }

    // Setter to mark the topping as extra
    public void setExtra(boolean isExtra) {
        this.isExtra = isExtra;
    }

    public void setCheeseType(CheeseType cheeseType) {
        this.cheeseType = cheeseType;
    }
}
