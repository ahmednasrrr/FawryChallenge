package models;

import interfaces.Shippable;

public class Cheese extends ExpirableProduct implements Shippable {
    private double weight;

    public Cheese(String productName, double unitPrice, int quantity, long expirationDate, double weight) {
        super(productName, unitPrice, quantity, expirationDate);
        this.weight = weight;
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
