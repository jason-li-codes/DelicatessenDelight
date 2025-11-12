package com.pluralsight.fooditems.sandwich;

import com.pluralsight.fooditems.Calories;

public abstract class SandwichFilling extends Calories {

    protected boolean isExtra;

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean isExtra) {
        this.isExtra = isExtra;
    }
}