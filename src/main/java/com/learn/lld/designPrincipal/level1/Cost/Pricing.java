package com.learn.lld.designPrincipal.level1.Cost;

import java.util.Map;

import com.learn.lld.designPrincipal.level1.Product;

public class Pricing {
    public static double calculatePricingBeforeDiscount(Map<Product, Integer> card) {
        double priceBeforeDiscount = 0;
        for (Map.Entry<Product, Integer> kv : card.entrySet()) {
            priceBeforeDiscount += (kv.getKey().getPrice() * kv.getValue());
        }
        return priceBeforeDiscount;

    }
}
