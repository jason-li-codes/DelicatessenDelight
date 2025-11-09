package com.pluralsight.fooditems.sandwich;

import com.pluralsight.fooditems.Calories;

public enum Sauce implements Calories {

    MAYO(50),        // Mayo has 50 calories
    MUSTARD(10),     // Mustard has 10 calories
    GUAC(150),       // Guacamole has 150 calories
    PESTO(200),      // Pesto has 200 calories
    RANCH(120),      // Ranch has 120 calories
    CAESAR(130);     // Caesar dressing has 130 calories

    private final int calories;

    // Constructor to set the calories value for each sauce type
    Sauce(int calories) {
        this.calories = calories;
    }

    // Getter method to retrieve the calories value
    @Override
    public int getCalories() {
        return calories;
    }
}
