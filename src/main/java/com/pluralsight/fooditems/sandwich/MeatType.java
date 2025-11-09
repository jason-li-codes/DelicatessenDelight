package com.pluralsight.fooditems.sandwich;

import com.pluralsight.fooditems.Calories;

public enum MeatType implements Calories {

    TURKEY(120),     // Turkey has 120 calories
    HAM(100),        // Ham has 100 calories
    CHICKEN(150),    // Chicken has 150 calories
    ROAST_BEEF(200), // Roast beef has 200 calories
    PASTRAMI(250),   // Pastrami has 250 calories
    BACON(300);      // Bacon has 300 calories

    private final int calories;

    // Constructor to set the calories value for each premium topping type
    MeatType(int calories) {
        this.calories = calories;
    }

    // Getter method to retrieve the calories value
    @Override
    public int getCalories() {
        return calories;
    }
}