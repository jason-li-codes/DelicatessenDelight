package com.pluralsight.fooditems.sandwich;

import com.pluralsight.fooditems.Calories;

public enum Bread implements Calories {

    WHITE(100),      // White bread has 70 calories
    MULTIGRAIN(90),  // Multigrain bread has 90 calories
    WHEAT(80),       // Wheat bread has 80 calories
    RYE(85);         // Rye bread has 85 calories

    private final int calories;

    // Constructor to set the calories value for each bread type
    Bread(int calories) {
        this.calories = calories;
    }

    // Getter method to retrieve the calories value
    @Override
    public int getCalories() {
        return calories;
    }
}
