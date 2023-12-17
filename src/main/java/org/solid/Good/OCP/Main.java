package org.solid.Good.OCP;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n==============================================================================================================");
        System.out.println("OCP : Restaurant Billing Order scenario where for Festivals or Special offer class doesn't offer Extensibility");
        System.out.println("==============================================================================================================");
        System.out.println("*** Adhering to Open Close Principle");

        System.out.println("\n=====================================================================");
        System.out.println("Scenario: Special Offer Billing Order on a Festival (like Canada Day)");
        System.out.println("=====================================================================");

        // Creating a Billing Order ID
        String orderID = "BILL_1149";
        // Creating a Standard Restaurant Order
        RestaurantOrder restaurantOrder = new RestaurantOrder(orderID);
        // Adding customer's menu items to the order
        restaurantOrder.addMenuItemToOrder(new RestaurantMenuItem("Chicken Shawarma Plate", 16.79, "Middle-Eastern Cuisine"));
        restaurantOrder.addMenuItemToOrder(new RestaurantMenuItem("Mixed Grill Plate", 18.89, "Middle-Eastern Cuisine"));
        restaurantOrder.addMenuItemToOrder(new RestaurantMenuItem("8oz Hummus", 7.99, "Middle-Eastern Cuisine"));
        restaurantOrder.addMenuItemToOrder(new RestaurantMenuItem("Baklava", 7.96, "Middle-Eastern Dessert"));
        restaurantOrder.addMenuItemToOrder(new RestaurantMenuItem("Coca-Cola", 5.98, "Cold Drink"));

        // Creating Special Offer Order because Restaurant is offering a Special discount on a festival: like on Canada Day for example.
        SpecialOfferRestaurantOrder specialOfferRestaurantOrder = new SpecialOfferRestaurantOrder(restaurantOrder,25);
        // Customer wants to pay using Master card
        restaurantOrder.setPaymentMethod("Master Card");
        // Displaying the final order with Special Offer applied on the final invoice to customer
        specialOfferRestaurantOrder.displayOrderInvoice();
    }
}