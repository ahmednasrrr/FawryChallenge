package models;

import interfaces.Shippable;

public class Biscuits extends ExpirableProduct implements Shippable {
    private double weight;

    public Biscuits(String productName, double unitPrice, int availableQuantity, long expirationDate, double weight) {
        super(productName, unitPrice, availableQuantity, expirationDate);
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
