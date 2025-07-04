import models.*;
import services.ECommerceSystem;


public class Main {
    public static void main(String[] args) {

        long futureDate = System.currentTimeMillis() + 86400000;

        Cheese cheese = new Cheese("Cheese", 100, 10, futureDate, 0.5);
        Biscuits biscuits = new Biscuits("Biscuits", 50, 5, futureDate, 0.7);
        TV tv = new TV("TV", 10000, 3, 20.0);
        Mobile mobile = new Mobile("Mobile", 15000, 8, 0.3);
        ScratchCard scratchCard = new ScratchCard("Scratch Card", 100, 100);
        Customer customer = new Customer("Ahmed Nasr", 20000.0);


        ShoppingCart cart = new ShoppingCart();


        System.out.println("--- Test Case 1: Successful Checkout ---");
        try {
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(scratchCard, 1);
            cart.add(mobile, 1);

            ECommerceSystem.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        System.out.println("\n --- Test case 2: empty cart ---");
        ECommerceSystem.checkout(customer, cart);

        System.out.println("\n --- Test case 3: Insufficient balance --");
        try {
            cart.add(tv, 3);
            ECommerceSystem.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        System.out.println("\n --- test case 4: Out of stock ---");
        cart.clear();
        try {
            cart.add(cheese, 20);
            ECommerceSystem.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Test Case 5: Expired Product ---");
        cart.clear();
        Cheese expiredCheese = new Cheese("Expired Cheese", 100, 5,
                System.currentTimeMillis() - 1000, 0.2);
        try {
            cart.add(expiredCheese, 1);
            ECommerceSystem.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- Test Case 6: Non-shippable Items Only ---");
        cart.clear();
        Customer richCustomer = new Customer("Rich Customer", 5000.0);
        try {
            cart.add(scratchCard, 3);
            ECommerceSystem.checkout(richCustomer, cart);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}