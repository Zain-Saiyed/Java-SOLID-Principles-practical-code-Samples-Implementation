package org.solid.Bad.OCP;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n=============================================================================================================");
        System.out.println("OCP : Restaurant Billing Order scenario where for Festivals or Special offer class doesn't offer Extensibility");
        System.out.println("==============================================================================================================");
        System.out.println("*** Failing Open Close Principle");

        System.out.println("\n===========================================================");
        System.out.println("Scenario: Standard Billing Order after customer order");
        System.out.println("===========================================================");

        // Creating a Billing Order ID
        String orderID = "BILL_2835";
        // Creating a Standard Restaurant Order
        RestaurantOrder restaurantOrder = new RestaurantOrder(orderID);
        // Adding customer's menu items to the order
        restaurantOrder.addMenuItemToOrder(new RestaurantMenuItem("Chicken Shawarma Plate", 16.79, "Middle-Eastern cuisine"));
        restaurantOrder.addMenuItemToOrder(new RestaurantMenuItem("Mixed Grill Plate", 18.89, "Middle-Eastern cuisine"));
        restaurantOrder.addMenuItemToOrder(new RestaurantMenuItem("8oz Hummus", 7.99, "Middle-Eastern cuisine"));
        restaurantOrder.addMenuItemToOrder(new RestaurantMenuItem("Baklava", 7.96, "Middle-Eastern dessert"));
        restaurantOrder.addMenuItemToOrder(new RestaurantMenuItem("Coca-Cola", 5.98, "Cold Drink"));

        // Compute the total order bill amount with tax for the customer's order
        restaurantOrder.generateTotalOrderBillAmount();
        // Customer wants to pay using Credit card
        restaurantOrder.setPaymentMethod("Credit Card");
        // Displaying the final order invoice to customer
        restaurantOrder.displayOrderInvoice();
    }
}