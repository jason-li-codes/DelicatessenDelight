package com.pluralsight.fooditems.sandwich;

import com.pluralsight.fooditems.Calories;

public enum CheeseType implements Calories {

    AMERICAN(75),    // American cheese has 75 calories
    SWISS(100),      // Swiss cheese has 100 calories
    CHEDDAR(110),    // Cheddar cheese has 110 calories
    PROVOLONE(90);   // Provolone cheese has 90 calories

    private final int calories;

    CheeseType(int calories) {
        this.calories = calories;
    }

    @Override
    public int getCalories() {
        return calories;
    }
}
