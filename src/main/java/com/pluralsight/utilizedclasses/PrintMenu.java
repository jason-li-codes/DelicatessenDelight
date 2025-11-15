package com.pluralsight.utilizedclasses;

public class PrintMenu {

    // Static methods for printing full menus for cleaner formatting
    public static String homepage() {
        return """
                                      ^
                       ^!^               ^
                            _______________________
                    ^!^    |_______________________|
                            |.H.H.H.H.H.H.H.H.H.H.|    ^!^
                       _____||~|~|~|~|~|~|~|~|~|~||_____   ^!^
                      |______DELICATESSEN DELIGHTS______|
                 _)o(_ |  HH  |.H.H.H.H.H.H.H.H.|  HH  | _)o(_
                 /(|)\\ |  HH  ||~|~|~|~|~|~|~|~||  HH  | /(|)\\
                   N   |  __  |_________________|  __  |   N
                   N   |  HH  |.H.H.H.'`'.H.H.H.|  HH  |   N
                   N   |  HH  ||~|~|~|!X!|~|~|~||  HH  |   N
                 ~~^~^"|______|\"\"\"\"\"\"\"|~|\"\"\"\"\"\"\"|______|\"^~^~~
                .|~|.:.......:.|~|.:.......:.|~|.:.......:.|~|.
                _| |_|_|_|_|_|_| |_|_|_|_|_|_| |_|_|_|_|_|_| |_
                ~| |~~~~~~~~~~~| |~~~~~~~~~~~| |~~~~~~~~~~~| |~
                 | |           | |           | |           | |
                ^~^~^^ ~^  ~ ^~^~^^   ^~ ~  ^~~^^~`  ~~^  ~^^^~
                 ~~~ ^~^~  ^~ ^^~  ~^^   ~^^    ^~^  ~^~   ~^
                """;
    }

    public static String fullMenu() {
        return """
                ╔══════════════════════════════════════════════════════╦══════════════════════════════════════════════════════╗
                ║            DELICATESSEN DELIGHTS FULL MENU           ║    (All calorie counts shown are for SMALL sizes)    ║
                ╠══════════════════════════════════════════════════════╬══════════════════════════════════════════════════════╣
                ║ SANDWICH SIZES                                       ║ REGULAR TOPPINGS (Free, Limit: 5)                    ║
                ║   Small  (4") ............ $5.50                     ║   - Lettuce (5)           |   - Peppers (7)          ║
                ║   Medium (8") ............ $7.00                     ║   - Tomato (10)           |   - Jalapeños (5)        ║
                ║   Large  (12") ........... $8.50                     ║   - Onion (8)             |   - Pickles (5)          ║
                ╠══════════════════════════════════════════════════════╣   - Olives (15)           |   - Spinach (10)         ║
                ║ BREAD OPTIONS (Choose 1)                             ║   - Mushrooms (12)                                   ║
                ║   - White (70 cal)           |   - Wheat (80 cal)    ╠══════════════════════════════════════════════════════╣
                ║   - Multigrain (90 cal)      |   - Rye (85 cal)      ║ SAUCES (Free, Limit: 3)                              ║
                ╠══════════════════════════════════════════════════════╣   - Mayo (50)             |   - Ranch (120)          ║
                ║ PREMIUM MEATS (Limit: 2 meats)                       ║   - Mustard (10)          |   - Caesar (130)         ║
                ║   Small: $1 | Extra $0.50                            ║   - Guacamole (150)       |   - Pesto (200)          ║
                ║   Medium: $2 | Extra $1                              ╠══════════════════════════════════════════════════════╣
                ║   Large: $3 | Extra $1.50                            ║ SIDES (Free, Limit: 2)                               ║
                ║   - Turkey (120)             |   - Roast Beef (200)  ║   - Fries (375 cal)       |   - Pickles (10 cal)     ║
                ║   - Ham (100)                |   - Pastrami (250)    ╠══════════════════════════════════════════════════════╣
                ║   - Chicken (150)            |   - Bacon (300)       ║ DRINKS (8oz/16oz/24oz — $2 / $2.50 / $3)             ║
                ╠══════════════════════════════════════════════════════╣   - KO-KUH (100)          |   - PEP-UH-SEE (98)      ║
                ║ PREMIUM CHEESES (Limit: 2 cheeses)                   ║   - SPRY-TUH (90)         |   - DOK-TUH-PEP-UH (96)  ║
                ║   Small: $0.75 | Extra $0.30                         ║   - MONS-TUH (95)                                    ║
                ║   Medium: $1.50 | Extra $0.60                        ╠══════════════════════════════════════════════════════╣
                ║   Large: $2.25 | Extra $0.90                         ║ CHIPS (One size — $1.50)                             ║
                ║   - American (75)            |   - Cheddar (110)     ║   - PO-TAY-TOHZ (150)     |   - TOASTY-TOHZ (140)    ║
                ║   - Swiss (100)              |   - Provolone (90)    ║   - FREE-TOHZ (160)       |   - TAKI-TOHZ (155)      ║
                ║                                                      ║   - DORY-TOHZ (140)                                  ║
                ╚══════════════════════════════════════════════════════╩══════════════════════════════════════════════════════╝
                """;

    }

    public static String sandwichMenu() {
        return """
                ╔══════════════════════════════════════════════════════╦══════════════════════════════════════════════════════╗
                ║                DELICATESSEN DELIGHTS:                ║       (All calorie counts are for SMALL sizes)       ║
                ║                    SANDWICH MENU                     ║                                                      ║
                ╠══════════════════════════════════════════════════════╬══════════════════════════════════════════════════════╣
                ║ SANDWICH SIZES                                       ║ REGULAR TOPPINGS (Free, Limit: 5)                    ║
                ║   Small  (4")  ............ $5.50                    ║   - Lettuce (5)           |   - Peppers (7)          ║
                ║   Medium (8")  ............ $7.00                    ║   - Tomato (10)           |   - Jalapeños (5)        ║
                ║   Large  (12") ............ $8.50                    ║   - Onion (8)             |   - Pickles (5)          ║
                ╠══════════════════════════════════════════════════════╣   - Olives (15)           |   - Spinach (10)         ║
                ║ BREAD OPTIONS (Choose 1)                             ║   - Mushrooms (12)                                   ║
                ║   - White (70 cal)           |   - Wheat (80 cal)    ╠══════════════════════════════════════════════════════╣
                ║   - Multigrain (90 cal)      |   - Rye (85 cal)      ║ SAUCES (Free, Limit: 3)                              ║
                ╠══════════════════════════════════════════════════════╣   - Mayo (50)             |   - Ranch (120)          ║
                ║ PREMIUM MEATS (Limit: 2 meats)                       ║   - Mustard (10)          |   - Caesar (130)         ║
                ║   Small:  $1.00  | Extra: $0.50                      ║   - Guacamole (150)       |   - Pesto (200)          ║
                ║   Medium: $2.00  | Extra: $1.00                      ╠══════════════════════════════════════════════════════╣
                ║   Large:  $3.00  | Extra: $1.50                      ║ SIDES (Free, Limit: 2)                               ║
                ║   - Turkey (120 cal)     |   - Roast Beef (200 cal)  ║   - Fries (375 cal)       |   - Pickles (10 cal)     ║
                ║   - Ham (100 cal)        |   - Pastrami (250 cal)    ╠══════════════════════════════════════════════════════╣
                ║   - Chicken (150 cal)    |   - Bacon (300 cal)       ║ SPECIALS ($10.00)                                    ║
                ╠══════════════════════════════════════════════════════╣   - Green Mountain Melt (1030 cal)                   ║
                ║ PREMIUM CHEESES (Limit: 2 cheeses)                   ║   - Smokehouse Stack (2200 cal)                      ║
                ║   Small:  $0.75  | Extra: $0.30                      ║   - Southwest Sunrise (970 cal)                      ║
                ║   Medium: $1.50  | Extra: $0.60                      ║   - Pastrami King (1886 cal)                         ║
                ║   Large:  $2.25  | Extra: $0.90                      ║   - Garden Delight (874 cal)                         ║
                ║   - American (75 cal)      |   - Cheddar (110 cal)   ║   - Mediterranean Delight (714 cal)                  ║
                ║   - Swiss (100 cal)        |   - Provolone (90 cal)  ║                                                      ║
                ╚══════════════════════════════════════════════════════╩══════════════════════════════════════════════════════╝
                """;
    }

    public static String specialsMenu() {
        return """
                ╔══════════════════════════════════════════════════════╦══════════════════════════════════════════════════════╗
                ║               DELICATESSEN DELIGHTS:                 ║             SPECIALTY SANDWICH DETAILS               ║
                ║            PREMIUM SIGNATURE SANDWICHES              ║          (All sandwiches are MEDIUM sized)           ║
                ╠══════════════════════════════════════════════════════╬══════════════════════════════════════════════════════╣
                ║ GREEN MOUNTAIN MELT ...................... (1452 cal)║ SMOKEHOUSE STACK ........................ (3428 cal) ║
                ║ • Bread: Multigrain                                  ║ • Bread: Rye                                         ║
                ║ • Meat: Turkey (Extra)                               ║ • Meats: Roast Beef (Extra), Bacon (Extra)           ║
                ║ • Cheese: American (Extra)                           ║ • Cheese: Cheddar (Extra)                            ║
                ║ • Toppings: Lettuce, Tomato, Spinach                 ║ • Toppings: Onion, Peppers, Pickles                  ║
                ║ • Sauce: Pesto                                       ║ • Sauce: Mustard                                     ║
                ║ • Side: Pickles                                      ║ • Side: Fries                                        ║
                ║ • Toasted: Yes                                       ║ • Toasted: Yes                                       ║
                ╠══════════════════════════════════════════════════════╬══════════════════════════════════════════════════════╣
                ║ SOUTHWEST SUNRISE ........................ (1542 cal)║ PASTRAMI KING .......................... (2594 cal)  ║
                ║ • Bread: White                                       ║ • Bread: Rye                                         ║
                ║ • Meat: Chicken (Extra)                              ║ • Meat: Pastrami (Extra)                             ║
                ║ • Cheese: Provolone (Extra)                          ║ • Cheese: Swiss (Extra)                              ║
                ║ • Toppings: Jalapeños, Lettuce, Tomato               ║ • Toppings: Onion, Pickles                           ║
                ║ • Sauce: Guacamole                                   ║ • Sauce: Ranch                                       ║
                ║ • Side: Pickles                                      ║ • Side: Fries                                        ║
                ║ • Toasted: Yes                                       ║ • Toasted: Yes                                       ║
                ╠══════════════════════════════════════════════════════╬══════════════════════════════════════════════════════╣
                ║ GARDEN DELIGHT ........................... (1086 cal)║ MEDITERRANEAN DELIGHT ................. (906 cal)    ║
                ║ • Bread: Multigrain                                  ║ • Bread: Multigrain                                  ║
                ║ • Cheese: Provolone (Extra)                          ║ • Cheese: Provolone (Extra)                          ║
                ║ • Toppings: Lettuce, Tomato, Spinach, Mushrooms      ║ • Toppings: Spinach, Olives, Tomato, Peppers         ║
                ║ • Sauce: Pesto                                       ║ • Sauce: Caesar                                      ║
                ║ • Side: Pickles                                      ║ • Side: Pickles                                      ║
                ║ • Toasted: Yes                                       ║ • Toasted: Yes                                       ║
                ╚══════════════════════════════════════════════════════╩══════════════════════════════════════════════════════╝
                """;
    }

    public static String drinksMenu() {
        return """
                ╔══════════════════════════════════════════════════════════╗
                ║                  DELICATESSEN DELIGHTS:                  ║
                ║                       DRINKS MENU                        ║
                ╠══════════════════════════════════════════════════════════╣
                ║ DRINKS (Small 8oz / Medium 16oz / Large 24oz)            ║
                ║   Small  ............... $2.00                           ║
                ║   Medium ............... $2.50                           ║
                ║   Large  ............... $3.00                           ║
                ║     - KO-KUH (100 cal)          - PEP-UH-SEE (98 cal)    ║
                ║     - SPRY-TUH (90 cal)         - DOK-TUH-PEP-UH (96 cal)║
                ║     - MONS-TUH (95 cal)                                  ║
                ╚══════════════════════════════════════════════════════════╝
                """;
    }

    public static String chipsMenu() {
        return """
                ╔══════════════════════════════════════════════════════════╗
                ║                  DELICATESSEN DELIGHTS:                  ║
                ║                        CHIPS MENU                        ║
                ╠══════════════════════════════════════════════════════════╣
                ║ CHIPS (One size only, $1.50)                             ║
                ║     - PO-TAY-TOHZ (150 cal)      - TOASTY-TOHZ (140 cal) ║
                ║     - FREE-TOHZ (160 cal)        - TAKI-TOHZ (155 cal)   ║
                ║     - DORY-TOHZ (140 cal)                                ║
                ╚══════════════════════════════════════════════════════════╝
                """;
    }

}
