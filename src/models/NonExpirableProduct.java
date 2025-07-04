package models;

public abstract class NonExpirableProduct extends Product {

    public NonExpirableProduct(String productName, double unitPrice, int availableQuantity) {
        super(productName, unitPrice, availableQuantity);

    }

    @Override
    public boolean isExpired() {

        return false;
    }

}
