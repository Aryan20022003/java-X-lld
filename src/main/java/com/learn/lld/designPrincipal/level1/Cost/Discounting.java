package com.learn.lld.designPrincipal.level1.Cost;

public class Discounting {
    public static double fixedDiscount(double discount, double amountBeforeDiscount) {
        return Math.max(0, amountBeforeDiscount - discount);
    }

    public static double percentageDiscount(int discountPercentage, double amountBeforeDiscount) {
        if (discountPercentage > 100 || discountPercentage < 0) {
            throw new IllegalArgumentException("discountPer should be between 0 and 100");
        }
        return Math.max(0, amountBeforeDiscount * (1 - (discountPercentage / 100.0)));
    }
}
