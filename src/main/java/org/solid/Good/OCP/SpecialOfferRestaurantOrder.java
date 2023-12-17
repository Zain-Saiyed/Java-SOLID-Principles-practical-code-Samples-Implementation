package org.solid.Good.OCP;

public class SpecialOfferRestaurantOrder implements IRestaurantOrder {
    private RestaurantOrder restaurantOrder;
    private double percentageCashBack;
    private double cashBackAmount;

    public SpecialOfferRestaurantOrder(RestaurantOrder restaurantOrder, double percentageCashBack) {
        this.restaurantOrder = restaurantOrder;
        this.percentageCashBack = percentageCashBack;
    }

    @Override
    public double generateTotalOrderBillAmount() {
        double currentBillAmount = restaurantOrder.generateTotalOrderBillAmount();
        this.cashBackAmount = (currentBillAmount * percentageCashBack / 100);
        double billAfterCashBack = currentBillAmount - this.cashBackAmount;
        return billAfterCashBack;
    }

    @Override
    public void displayOrderInvoice() {
        double finalBillAmount = this.generateTotalOrderBillAmount();
        restaurantOrder.displayOrderInvoice();
        System.out.println("Cash Back Amount ("+this.percentageCashBack+"%)           : $" + Math.floor(this.cashBackAmount));
        System.out.println("Total payable Bill after Cash Back : $"+Math.ceil(finalBillAmount));
        System.out.println("-----------------------------");
    }
}