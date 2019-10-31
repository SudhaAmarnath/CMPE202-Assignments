public class BuildOrder {

    public static BurgerComposite getOrder() {
    	
        String[] burgerOptions = {};
        String[] cheeseOptions = {};
        String[] premiumCheeseOptions = {};
        String[] sauceOptions = {};
        String[] toppingOptions = {};
        String[] premiumToppingOptions = {};
        String[] bunOptions = {};
        String[] sideOptions = {};
        String[] chooseSideOrders = {};

        
        Composite order = new Order("Order");

        CustomBurger sideOrders = new CustomBurger("Choose Side orders");
        // SideOrder1
        chooseSideOrders = new String[] {"Crispy Onion Strings"};
        sideOrders = new CustomBurger("Choose side orders");
        sideOrders.addChild(new Side("Choose Side Order", chooseSideOrders));
        order.addChild(sideOrders);
        // SideOrder2
        chooseSideOrders = new String[] {"The Purist"};
        sideOrders = new CustomBurger("Choose Side orders");
        sideOrders.addChild(new Side("Choose Side Order", chooseSideOrders));
        order.addChild(sideOrders);
        
        
        CustomBurger customBurger = new CustomBurger("Build Your Own Burger");        
        // Burger1
        burgerOptions = new String[] { "Beef*", "1/3lb.", "On A Bun" };
        bunOptions = new String[] { "Hamburger Bun", "Medium" };        
        cheeseOptions = new String[] { "Danish Blue Cheese", "Horseradish Cheddar" };
        sauceOptions = new String[] { "Apricot Sauce" };
        toppingOptions = new String[] { "Bermuda Red Onion", "Black Olives", "Carrot Strings", "Coleslaw" };
        premiumCheeseOptions = new String[] {};
        premiumToppingOptions = new String[] { "Applewood Smoked Bacon" };
        customBurger = new CustomBurger("Build Your Own Burger");
        customBurger.addChild(new Burger("Burger Options", burgerOptions));
        customBurger.addChild(new Bun("Bun Options", bunOptions));        
        customBurger.addChild(new Cheese("Cheese Options", cheeseOptions));
        customBurger.addChild(new PremiumCheese("Premium Cheese Options", premiumCheeseOptions));
        customBurger.addChild(new Sauce("Sauce Options", sauceOptions));
        customBurger.addChild(new Toppings("Toppings Options", toppingOptions));
        customBurger.addChild(new PremiumToppings("Premium Toppings Options", premiumToppingOptions));
        customBurger.addChild(new Side("Side Options", sideOptions));
        order.addChild(customBurger);


        // Burger2
        burgerOptions = new String[] { "Veggie", "2/3lb.", "In a Bowl" };
        bunOptions = new String[] { "Potato Bun", "Large" };        
        cheeseOptions = new String[] { "Danish Blue Cheese", "Horseradish Cheddar", "Imported Swiss" };
        sauceOptions = new String[] { "Basil Pesto", "Ginger Soy Glaze" };
        toppingOptions = new String[] { "Grilled Onions", "Black Olives", "Jalapenos", "Coleslaw", "Sprouts" };
        premiumCheeseOptions = new String[] {"French Cheese"};
        premiumToppingOptions = new String[] { "Avacodo" };        
        customBurger = new CustomBurger("Build Your Own Burger");
        customBurger.addChild(new Burger("Burger Options", burgerOptions));
        customBurger.addChild(new Bun("Bun Options", bunOptions));        
        customBurger.addChild(new Cheese("Cheese Options", cheeseOptions));
        customBurger.addChild(new PremiumCheese("Premium Cheese Options", premiumCheeseOptions));
        customBurger.addChild(new Sauce("Sauce Options", sauceOptions));
        customBurger.addChild(new Toppings("Toppings Options", toppingOptions));
        customBurger.addChild(new PremiumToppings("Premium Toppings Options", premiumToppingOptions));
        customBurger.addChild(new Side("Side Options", sideOptions));
        order.addChild(customBurger);

        return order;
        
    }

}
