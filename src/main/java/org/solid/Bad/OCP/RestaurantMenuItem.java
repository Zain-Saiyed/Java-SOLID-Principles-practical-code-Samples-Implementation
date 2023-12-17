package org.solid.Bad.OCP;

public class RestaurantMenuItem {
    private String itemName;
    private double itemPrice;
    private String itemType;

    public RestaurantMenuItem(String itemName, double itemPrice, String itemType) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}