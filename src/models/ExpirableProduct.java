package models;

public abstract class ExpirableProduct extends Product {
    protected long expirationTimestamp;

    public ExpirableProduct(String productName, double unitPrice, int availableQuantity, long expirationTimestamp) {
        super(productName, unitPrice, availableQuantity);
        this.expirationTimestamp = expirationTimestamp;

    }

    @Override
    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();

        if (expirationTimestamp <= 0) {
            System.out.println("Warning: Product ' " + productName + "' has an invalid expiration timestamp.");
            return true;
        }

        return currentTime > expirationTimestamp;
    }

}
