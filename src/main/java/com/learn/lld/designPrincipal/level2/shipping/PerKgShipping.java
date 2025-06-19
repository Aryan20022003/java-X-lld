package com.learn.lld.designPrincipal.level2.shipping;

import java.util.Map;

import com.learn.lld.designPrincipal.level1.Product;

public class PerKgShipping implements ShippingInterface {
    private Map<Product, Integer> productCart;
    private double costPerKg;

    public PerKgShipping(Map<Product, Integer> productCart, double costPerKg) {
        this.productCart = productCart;
        this.costPerKg = costPerKg;
    }

    @Override
    public double shippingCost() {
        double totalWeight = 0;
        for (Map.Entry<Product, Integer> entry : productCart.entrySet()) {
            totalWeight += entry.getKey().getProductWeight() * entry.getValue();
        }
        return totalWeight * costPerKg;
    }

}
