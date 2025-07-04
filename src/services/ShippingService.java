package services;

import interfaces.Shippable;
import java.util.List;

// Shipping Service
public class ShippingService {
    private static final double SHIPPING_RATE_PER_KG = 30.0; // 30 per kg

    public static void ship(List<Shippable> items) {
        if (items.isEmpty()) return;

        System.out.println("** Shipment notice **");
        double totalWeight = 0;

        for (Shippable item : items) {
            System.out.println("1x " + item.getName() + " " + (item.getWeight() * 1000) + "g");
            totalWeight += item.getWeight();
        }

        System.out.println("Total package weight " + totalWeight + "kg");
    }

    public static double calculateShippingFee(List<Shippable> items) {
        double totalWeight = items.stream().mapToDouble(Shippable::getWeight).sum();
        return totalWeight * SHIPPING_RATE_PER_KG;
    }
}
