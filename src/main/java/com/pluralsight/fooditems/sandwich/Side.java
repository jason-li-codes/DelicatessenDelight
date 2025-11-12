package com.pluralsight.fooditems.sandwich;

import com.pluralsight.fooditems.Calories;

public class Side extends Calories {

    private final SideType sideType;

    public Side(SideType sideType) {
        this.sideType = sideType;
        updateCalories();
    }

    private void updateCalories() {
        this.calories = switch (sideType) {
            case FRIES -> 375;
            case PICKLES -> 20;
        };
    }
}
