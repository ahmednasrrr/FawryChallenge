package models;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {
    private List<CartItem> items;

    public ShoppingCart() {

        this.items = new ArrayList<>();
    }

    public void add(Product product, int quantity) {

        if (quantity <= 0) {

            throw new IllegalArgumentException("Quantity must be positive");
        }

        if (!product.isInStock(quantity)) {

            throw new IllegalArgumentException("Insufficient stock for " + product.getName());
        }


        for (CartItem item : items) {
            if (item.getProduct().getName().equals(product.getName())) {
                int newQuantity = item.getQuantity() + quantity;
                if (!product.isInStock(newQuantity)) {
                    throw new IllegalArgumentException("Insufficient stock for " + product.getName());
                }
                items.remove(item);
                items.add(new CartItem(product, newQuantity));
                return;
            }
        }

        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
}