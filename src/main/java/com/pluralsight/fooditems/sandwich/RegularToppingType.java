package com.pluralsight.fooditems.sandwich;

import com.pluralsight.fooditems.Calories;

public enum RegularToppingType implements Calories {

    LETTUCE(5),        // Lettuce has 5 calories
    TOMATO(10),        // Tomato has 10 calories
    ONION(8),          // Onion has 8 calories
    PEPPERS(7),        // Peppers have 7 calories
    JALAPENOS(5),      // Jalapeños have 5 calories
    PICKLES(5),        // Pickles have 5 calories
    OLIVES(15),        // Olives have 15 calories
    SPINACH(10),       // Spinach has 10 calories
    MUSHROOMS(12);     // Mushrooms have 12 calories

    private final int calories;

    // Constructor to set the calories value for each regular topping
    RegularToppingType(int calories) {
        this.calories = calories;
    }

    // Getter method to retrieve the calories value
    @Override
    public int getCalories() {
        return calories;
    }
}
