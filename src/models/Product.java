package models;

public abstract class Product {
    protected String productName;
    protected double unitPrice;
    protected int availableQuantity;

    public Product(String productName, double unitPrice, int availableQuantity) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.availableQuantity = availableQuantity;

    }


    public String getName() {
        return productName;
    }

    public double getPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return availableQuantity;
    }


    public boolean isInStock(int requestedQuantity) {
        return availableQuantity >= requestedQuantity;
    }

    // Reduces the available quantity after purchase
    public void reduceQuantity(int soldQuantity) {
        if (soldQuantity <= availableQuantity) {
            availableQuantity -= soldQuantity;
        }
    }


    public abstract boolean isExpired();


    public abstract boolean requiresShipping();

}

