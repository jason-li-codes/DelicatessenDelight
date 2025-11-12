package com.pluralsight.fooditems.sandwich;

public class PremiumToppingMeat extends SandwichFilling {

    private MeatType meatType;

    // Constructor to set the calories value for each premium cheese topping
    PremiumToppingMeat(MeatType meatType, boolean isExtra) {
        this.meatType = meatType;
        this.isExtra = isExtra;
        updateCalories();
    }

    public void setMeatType(MeatType meatType) {
        this.meatType = meatType;
    }

    public void updateCalories() {
        this.calories = switch (meatType) {
            case TURKEY -> 120;
            case HAM -> 100;
            case CHICKEN -> 150;
            case ROAST_BEEF -> 200;
            case PASTRAMI -> 250;
            case BACON -> 300;
        };
    }
}
