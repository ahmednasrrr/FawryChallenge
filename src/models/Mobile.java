package models;

import interfaces.Shippable;

public class Mobile extends NonExpirableProduct implements Shippable {

    private double weight;

    public Mobile(String productName, double unitPrice, int availableQuantity, double weight) {
        super(productName, unitPrice, availableQuantity);
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
