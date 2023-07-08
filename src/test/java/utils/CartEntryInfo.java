package utils;

public class CartEntryInfo {
    private int quantity;
    private double amount;

    public CartEntryInfo(int quantity, double amount) {
        this.quantity = quantity;
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return amount;
    }
}