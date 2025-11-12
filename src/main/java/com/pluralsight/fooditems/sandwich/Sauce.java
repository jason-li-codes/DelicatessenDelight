package com.pluralsight.fooditems.sandwich;

import com.pluralsight.fooditems.Calories;

public class Sauce extends Calories {

    private final SauceType sauceType;

    public Sauce(SauceType sauceType) {
        this.sauceType = sauceType;
        updateCalories();
    }

    public void updateCalories() {
        this.calories = switch (sauceType) {
            case MAYO -> 50;
            case MUSTARD -> 10;
            case GUACAMOLE -> 150;
            case PESTO -> 200;
            case RANCH -> 120;
            case CAESAR -> 130;
        };
    }

}
