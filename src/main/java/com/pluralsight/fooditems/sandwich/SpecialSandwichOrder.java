package com.pluralsight.fooditems.sandwich;

import com.pluralsight.fooditems.enums.*;


public class SpecialSandwichOrder extends SandwichOrder {

    private String sandwichName;

    public SpecialSandwichOrder(String specialSandwich) {
        super(selectBread(specialSandwich), Size.MEDIUM); // call to parent constructor
        this.sandwichName = specialSandwich;
        configureSandwich(specialSandwich);
    }

    // Configure sandwich toppings, meats, cheese, sauces
    private void configureSandwich(String specialSandwich) {
        switch (specialSandwich.toLowerCase()) {
            case "green mountain melt":
                this.addMeat(new PremiumToppingMeat(MeatType.TURKEY, true));
                this.addCheese(new PremiumToppingCheese(CheeseType.AMERICAN, true));
                this.addRegularTopping(new RegularTopping(RegularToppingType.LETTUCE, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.TOMATO, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.SPINACH, false));
                this.addSauce(new Sauce(SauceType.PESTO));
                this.addSide(new Side(SideType.PICKLES));
                this.setToasted(true);
                this.price = 10;
                break;

            case "smokehouse stack":
                this.addMeat(new PremiumToppingMeat(MeatType.ROAST_BEEF, true));
                this.addMeat(new PremiumToppingMeat(MeatType.BACON, true));
                this.addCheese(new PremiumToppingCheese(CheeseType.CHEDDAR, true));
                this.addRegularTopping(new RegularTopping(RegularToppingType.ONION, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.PEPPERS, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.PICKLES, false));
                this.addSauce(new Sauce(SauceType.MUSTARD));
                this.addSide(new Side(SideType.FRIES));
                this.setToasted(true);
                this.price = 10;
                break;

            case "southwest sunrise":
                this.addMeat(new PremiumToppingMeat(MeatType.CHICKEN, true));
                this.addCheese(new PremiumToppingCheese(CheeseType.PROVOLONE, true));
                this.addRegularTopping(new RegularTopping(RegularToppingType.JALAPENOS, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.LETTUCE, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.TOMATO, false));
                this.addSauce(new Sauce(SauceType.GUACAMOLE));
                this.addSide(new Side(SideType.PICKLES));
                this.setToasted(true);
                this.price = 10;
                break;

            case "pastrami king":
                this.addMeat(new PremiumToppingMeat(MeatType.PASTRAMI, true));
                this.addCheese(new PremiumToppingCheese(CheeseType.SWISS, true));
                this.addRegularTopping(new RegularTopping(RegularToppingType.ONION, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.PICKLES, false));
                this.addSauce(new Sauce(SauceType.RANCH));
                this.addSide(new Side(SideType.FRIES));
                this.setToasted(true);
                this.price = 10;
                break;

            case "garden delight":
                this.addCheese(new PremiumToppingCheese(CheeseType.PROVOLONE, true));
                this.addRegularTopping(new RegularTopping(RegularToppingType.LETTUCE, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.TOMATO, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.SPINACH, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.MUSHROOMS, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.OLIVES, false));
                this.addSauce(new Sauce(SauceType.PESTO));
                this.addSide(new Side(SideType.PICKLES));
                this.setToasted(true);
                this.price = 10;
                break;

            case "mediterranean delight":
                this.addCheese(new PremiumToppingCheese(CheeseType.PROVOLONE, true));
                this.addRegularTopping(new RegularTopping(RegularToppingType.SPINACH, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.OLIVES, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.TOMATO, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.PEPPERS, false));
                this.addSauce(new Sauce(SauceType.CAESAR));
                this.addSide(new Side(SideType.PICKLES));
                this.setToasted(true);
                this.price = 10;
                break;

            default:
                System.out.println("Unknown special sandwich: " + specialSandwich);
        }
    }

    // Select bread for each special sandwich
    private static Bread selectBread(String specialSandwich) {
        return switch (specialSandwich.toLowerCase()) {
            case "green mountain melt", "garden delight" -> new Bread(BreadType.MULTIGRAIN);
            case "smokehouse stack", "pastrami king" -> new Bread(BreadType.RYE);
            case "southwest sunrise" -> new Bread(BreadType.WHITE);
            default -> new Bread(BreadType.WHEAT);
        };
    }

    @Override
    public String toString() {
        super.toString(sandwichName);
    }

}
