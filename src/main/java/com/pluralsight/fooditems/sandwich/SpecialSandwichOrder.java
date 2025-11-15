package com.pluralsight.fooditems.sandwich;

import com.pluralsight.fooditems.enums.*;

public class SpecialSandwichOrder extends SandwichOrder {

    // SpecialSandwichOrder has only one unique attribute, its sandwichName
    private final String sandwichName;

    // Constructor takes in sandwichName
    public SpecialSandwichOrder(String specialSandwich) {
        // Call on constructor of superclass SandwichOrder
        super(selectBread(specialSandwich), Size.MEDIUM);
        this.sandwichName = specialSandwich;
        // Call private method to set up SpecialSandwichOrder
        configureSandwich(specialSandwich);
    }

    // Getter
    public String getSandwichName() {
        return sandwichName;
    }

    // Configure sandwich toppings, meats, cheese, sauces
    private void configureSandwich(String specialSandwich) {
        // Use switch case to create appropriate SandwichOrder with the correct SandwichFilling
        switch (specialSandwich) {
            case "Green Mountain Melt":
                this.addMeat(new PremiumToppingMeat(MeatType.TURKEY, true));
                this.addCheese(new PremiumToppingCheese(CheeseType.AMERICAN, true));
                this.addRegularTopping(new RegularTopping(RegularToppingType.LETTUCE, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.TOMATO, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.SPINACH, false));
                this.addSauce(new Sauce(SauceType.PESTO));
                this.addSide(new Side(SideType.PICKLES));
                break;

            case "Smokehouse Stack":
                this.addMeat(new PremiumToppingMeat(MeatType.ROAST_BEEF, true));
                this.addMeat(new PremiumToppingMeat(MeatType.BACON, true));
                this.addCheese(new PremiumToppingCheese(CheeseType.CHEDDAR, true));
                this.addRegularTopping(new RegularTopping(RegularToppingType.ONION, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.PEPPERS, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.PICKLES, false));
                this.addSauce(new Sauce(SauceType.MUSTARD));
                this.addSide(new Side(SideType.FRIES));
                break;

            case "Southwest Sunrise":
                this.addMeat(new PremiumToppingMeat(MeatType.CHICKEN, true));
                this.addCheese(new PremiumToppingCheese(CheeseType.PROVOLONE, true));
                this.addRegularTopping(new RegularTopping(RegularToppingType.JALAPENOS, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.LETTUCE, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.TOMATO, false));
                this.addSauce(new Sauce(SauceType.GUACAMOLE));
                this.addSide(new Side(SideType.PICKLES));
                break;

            case "Pastrami King":
                this.addMeat(new PremiumToppingMeat(MeatType.PASTRAMI, true));
                this.addCheese(new PremiumToppingCheese(CheeseType.SWISS, true));
                this.addRegularTopping(new RegularTopping(RegularToppingType.ONION, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.PICKLES, false));
                this.addSauce(new Sauce(SauceType.RANCH));
                this.addSide(new Side(SideType.FRIES));
                break;

            case "Garden Delight":
                this.addCheese(new PremiumToppingCheese(CheeseType.PROVOLONE, true));
                this.addRegularTopping(new RegularTopping(RegularToppingType.LETTUCE, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.TOMATO, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.SPINACH, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.MUSHROOMS, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.OLIVES, false));
                this.addSauce(new Sauce(SauceType.PESTO));
                this.addSide(new Side(SideType.PICKLES));
                break;

            case "Taste of the Mediterranean":
                this.addCheese(new PremiumToppingCheese(CheeseType.PROVOLONE, true));
                this.addRegularTopping(new RegularTopping(RegularToppingType.SPINACH, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.OLIVES, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.TOMATO, false));
                this.addRegularTopping(new RegularTopping(RegularToppingType.PEPPERS, false));
                this.addSauce(new Sauce(SauceType.CAESAR));
                this.addSide(new Side(SideType.PICKLES));
                break;
            // Default message is best practice but should never run, since user doesn't have access to private method
            default:
                System.out.println("Unknown special sandwich: " + specialSandwich);
        }
        // All SpecialSandwichOrders have these attribute values
        this.setToasted(true);
        this.price = 10;
    }

    // Select bread for each special sandwich based on sandwichName
    private static Bread selectBread(String specialSandwich) {
        return switch (specialSandwich) {
            case "Green Mountain Melt", "Garden Delight" -> new Bread(BreadType.MULTIGRAIN);
            case "Smokehouse Stack", "Pastrami King" -> new Bread(BreadType.RYE);
            case "Southwest Sunrise" -> new Bread(BreadType.WHITE);
            default -> new Bread(BreadType.WHEAT);
        };
    }

}
