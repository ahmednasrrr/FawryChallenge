
package models;

public class ScratchCard extends NonExpirableProduct {
    public ScratchCard(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean requiresShipping() {
        return false;
    }
}