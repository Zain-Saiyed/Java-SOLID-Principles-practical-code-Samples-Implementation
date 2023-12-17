package org.solid.Good.OCP;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestaurantOrder implements IRestaurantOrder {
    private String orderId;
    private Date orderDate;
    private List<RestaurantMenuItem> orderItems;
    private double billTaxAmount;
    private double subTotalBillAmount;
    private String paymentMethod;

    public RestaurantOrder(String orderId) {
        this.orderId = orderId;
        this.orderDate = new Date();
        this.orderItems = new ArrayList<>();
        this.billTaxAmount = 0;
        this.subTotalBillAmount = 0;
        this.paymentMethod = null;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void addMenuItemToOrder(RestaurantMenuItem menuItem) {
        orderItems.add(menuItem);
    }

    public void removeMenuItemFromOrder(RestaurantMenuItem menuItem) {
        orderItems.remove(menuItem);
    }
    @Override
    public double generateTotalOrderBillAmount() {
        this.subTotalBillAmount = 0;
        for (RestaurantMenuItem menuItem : this.orderItems) {
            this.subTotalBillAmount += menuItem.getItemPrice();
        }
        this.applyTax();
        double totalBillAmount = this.subTotalBillAmount + this.billTaxAmount;
        return totalBillAmount;
    }
    private void applyTax() {
        // Apply 15% HST tax on total Bill amount
        this.billTaxAmount = 0.15*this.subTotalBillAmount;
    }

    @Override
    public void displayOrderInvoice() {
        System.out.println("---------- INVOICE ----------");
        System.out.println("Order date    : " + this.orderDate);
        System.out.println("Order ID      : " + this.orderId);
        System.out.println("\n-----------------------");
        System.out.println("Ordered Items :");
        System.out.println("-----------------------");
        for (RestaurantMenuItem item : this.orderItems) {
            System.out.println(item.getItemName()+" ("+item.getItemType()+") ~~~~~~~ $" + item.getItemPrice());
        }
        System.out.println("\nPayment Method: " + this.paymentMethod);
        System.out.println("-----------------------------");
        System.out.println("SubTotal      : $" + this.subTotalBillAmount);
        System.out.println("HST 15.000%   : $" + Math.ceil(this.billTaxAmount));
        System.out.println("Total         : $" + this.generateTotalOrderBillAmount());
        System.out.println("-----------------------------");
    }
}