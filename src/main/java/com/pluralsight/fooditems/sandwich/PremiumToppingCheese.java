package com.pluralsight.fooditems.sandwich;

public class PremiumToppingCheese extends SandwichFilling {

    private CheeseType cheeseType;

    public PremiumToppingCheese(CheeseType cheeseType, boolean isExtra) {
        this.cheeseType = cheeseType;
        this.isExtra = isExtra;
        updateCalories();
    }

    public void setCheeseType(CheeseType cheeseType) {
        this.cheeseType = cheeseType;
        updateCalories();
    }

    public void updateCalories() {
        this.calories = switch (cheeseType) {
            case AMERICAN -> 75;
            case SWISS -> 100;
            case CHEDDAR -> 110;
            case PROVOLONE -> 90;
        };
    }
}
