package services;

import services.ShippingService;
import models.*;
import interfaces.Shippable;
import java.util.ArrayList;
import java.util.List;

// Main E-commerce System
public class ECommerceSystem {
    public static void checkout(Customer customer, ShoppingCart cart) {

        // Validate cart is not empty

        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty");
            return;
        }

        // Check for expired or out of stock products
        List<Shippable> shippableItems = new ArrayList<>();
        double subtotal = 0;

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            // Check if product is expired
            if (product.isExpired()) {
                System.out.println("Error: " + product.getName() + " is expired");
                return;
            }

            // Check if product is out of stock
            if (!product.isInStock(quantity)) {
                System.out.println("Error: " + product.getName() + " is out of stock");
                return;
            }

            subtotal += item.getTotalPrice();

            // Collect shippable items
            if (product.requiresShipping() && product instanceof Shippable) {
                for (int i = 0; i < quantity; i++) {
                    shippableItems.add((Shippable) product);
                }
            }
        }

        // Calculate shipping fees
        double shippingFee = ShippingService.calculateShippingFee(shippableItems);
        double totalAmount = subtotal + shippingFee;

        // Check customer balance
        if (customer.getBalance() < totalAmount) {
            System.out.println("Error: Customer's balance is insufficient");
            return;
        }

        // Process payment
        customer.deductBalance(totalAmount);

        // Update product quantities
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        // Ship items if needed
        if (!shippableItems.isEmpty()) {
            ShippingService.ship(shippableItems);
        }

        // Print checkout receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(
                    item.getQuantity() + "x " + item.getProduct().getName() + " " + (int) item.getTotalPrice());
        }
        System.out.println("--------------------------");
        System.out.println("Subtotal " + (int) subtotal);
        System.out.println("Shipping " + (int) shippingFee);
        System.out.println("Amount " + (int) totalAmount);
        System.out.println("Customer balance after payment: " + customer.getBalance());
        System.out.println("END.");

        // Clear cart after successful checkout
        cart.clear();
    }
}
