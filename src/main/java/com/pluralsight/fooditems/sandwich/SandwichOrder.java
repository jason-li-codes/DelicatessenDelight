package com.pluralsight.fooditems.sandwich;

import com.pluralsight.fooditems.MenuItem;
import com.pluralsight.fooditems.Size;

import java.util.ArrayList;

public class SandwichOrder implements MenuItem {

    private Bread bread;
    private final ArrayList<PremiumToppingMeat> premiumToppingMeats;
    private final ArrayList<PremiumToppingCheese> premiumToppingCheeses;
    private final ArrayList<RegularTopping> regularToppings;
    private final ArrayList<Sauce> sauces;
    private Size size;
    private boolean isToasted;
    private Side side;

    public SandwichOrder(Bread bread) {
        this.bread = bread;
        this.premiumToppingMeats = new ArrayList<>();
        this.premiumToppingCheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.isToasted = false;
        this.side = null;
    }

    public Bread getBread() {
        return bread;
    }

    public ArrayList<PremiumToppingMeat> getPremiumToppingMeats() {
        return premiumToppingMeats;
    }

    public ArrayList<PremiumToppingCheese> getPremiumToppingCheeses() {
        return premiumToppingCheeses;
    }

    public ArrayList<RegularTopping> getRegularToppings() {
        return regularToppings;
    }

    public ArrayList<Sauce> getSauces() {
        return sauces;
    }

    public Size getSize() {
        return size;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public Side getSide() {
        return side;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public void addMeat(PremiumToppingMeat premiumToppingMeat) {
        if (premiumToppingMeats.size() == 2) {
            System.out.println("You may only have up to 2 meats in your sandwich.");
        } else {
            this.premiumToppingMeats.add(premiumToppingMeat);
        }
    }

    public void addMeat(PremiumToppingCheese premiumToppingCheese) {
        if (premiumToppingCheeses.size() == 2) {
            System.out.println("You may only have up to 2 cheeses in your sandwich.");
        } else {
            this.premiumToppingCheeses.add(premiumToppingCheese);
        }
    }

    public void addRegularTopping(RegularTopping regularTopping) {
        if (regularToppings.size() == 5) {
            System.out.println("You may only have up to 5 toppings in your sandwich.");
        } else {
            this.regularToppings.add(regularTopping);
        }
    }

    public void addSauce(Sauce sauce) {
        if (sauces.size() == 3) {
            System.out.println("You may only have up to 3 sauces in your sandwich.");
        } else {
            this.sauces.add(sauce);
        }
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public int getCalories() {

        int totalCal = 0;
        totalCal += bread.getCalories();
        totalCal += premiumToppingMeats.stream()
                .mapToInt(PremiumToppingMeat::getCalories) // Extract calories from each meat topping
                .sum();
        totalCal += premiumToppingCheeses.stream()
                .mapToInt(PremiumToppingCheese::getCalories) // Extract calories from each cheese topping
                .sum();
        totalCal += regularToppings.stream()
                .mapToInt(RegularTopping::getCalories) // Extract calories from each regular topping
                .sum();
        totalCal += sauces.stream()
                .mapToInt(Sauce::getCalories) // Extract calories from each sauce
                .sum();
        totalCal += (side != null) ? side.getCalories() : 0;

        return totalCal;
    }
}
