package com.pluralsight.fooditems.sandwich;

import com.pluralsight.fooditems.Calories;

public enum Side implements Calories {

    FRIES(375),     // Fries have 375 calories
    PICKLES(10);    // Pickles have 10 calories

    private final int calories;

    Side(int calories) {
        this.calories = calories;
    }

    @Override
    public int getCalories() {
        return calories;
    }
}
