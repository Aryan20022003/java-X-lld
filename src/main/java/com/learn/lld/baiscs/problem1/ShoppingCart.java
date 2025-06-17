package com.learn.lld.baiscs.problem1;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> card = new HashMap<>();

    public void addProduct(Product pb) {
        addProduct(pb, 1);
    }

    public void addProduct(Product pb, int quantity) {
        card.put(pb, card.getOrDefault(pb, 0) + quantity);
    }

    public String removeProduct(Product pb) {
        return removeProduct(pb, 1);
    }

    public String removeProduct(Product pb, int quantity) {
        if (card.get(pb) != null && (card.get(pb) >= quantity)) {
            card.put(pb, card.get(pb) - quantity);
            if (card.get(pb) == 0) {
                card.remove(pb);
            }
            return quantity + " of " + pb.getName() + "is been removed";
        }
        return "No product found";
    }

    public double totalPrice() {
        double price = 0;
        for (Map.Entry<Product, Integer> entry : card.entrySet()) {
            price += entry.getKey().getPrice() * entry.getValue();
        }
        return price;
    }

    public void displayProduct() {
        System.out.println("Product in Card are");
        System.out.println("Total Product in card " + card.size());
        for (Map.Entry<Product, Integer> entry : card.entrySet()) {
            System.out.println(entry.getKey().getName() + "Quantity :" + entry.getValue());
        }
    }

}
