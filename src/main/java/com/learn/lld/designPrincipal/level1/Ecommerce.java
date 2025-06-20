package com.learn.lld.designPrincipal.level1;

import java.util.UUID;

import com.learn.lld.designPrincipal.level1.Cost.DiscountType;
import com.learn.lld.designPrincipal.level1.Cost.Discounting;
import com.learn.lld.designPrincipal.level1.Cost.Pricing;
import com.learn.lld.designPrincipal.level1.checkout.CheckoutResponse;
import com.learn.lld.designPrincipal.level1.payment.Card;
import com.learn.lld.designPrincipal.level1.payment.CardPayment;
import com.learn.lld.designPrincipal.level1.payment.PaymentInterface;
import com.learn.lld.designPrincipal.level2.notification.EmailNotification;
import com.learn.lld.designPrincipal.level2.notification.NotificationInterface;
import com.learn.lld.designPrincipal.level2.orderStatus.OrderManager;

public class Ecommerce {
    private final Cart shoppingCart;
    private final OrderManager orderManagementService;

    public Ecommerce() {
        shoppingCart = new Cart();
        orderManagementService = new OrderManager();

    }

    public boolean addProduct(Product product, int quantity) {
        validateProductAndQuantity(product, quantity);
        return shoppingCart.addProduct(product, quantity);
    }

    public boolean removeProduct(Product product, int quantity) {
        validateProductAndQuantity(product, quantity);
        return shoppingCart.removeProduct(product, quantity);
    }

    public double getPriceBeforeDiscount() {
        return Pricing.calculatePricingBeforeDiscount(shoppingCart.getProductCart());
    }

    public double applyFixedDiscount(double discount) {
        if (discount < 0) {
            throw new IllegalArgumentException("Discount amount cannot be negative");
        }
        return Discounting.fixedDiscount(discount, getPriceBeforeDiscount());
    }

    public double applyPercentageDiscount(int percentage) {
        return Discounting.percentageDiscount(percentage, getPriceBeforeDiscount());
    }

    public CheckoutResponse finalCheckoutWithCard(DiscountType type, double discount, Card paymentCard) {
        // default to 10 if no cost per kg is given . And My understanding main
        // E-commerce class should not be
        // concern with cost per Kg while initialization
        return finalCheckoutWithCard(type, discount, paymentCard, 10);
    }

    public CheckoutResponse finalCheckoutWithCard(DiscountType type, double discount, Card paymentCard,
            double costPerKg) {
        if (paymentCard == null) {
            throw new IllegalArgumentException("Payment card cannot be null");
        }
        if (costPerKg <= 0) {
            throw new IllegalArgumentException("Shipping cost cannot be less than positive value");
        }
        if (shoppingCart.getProductCart().isEmpty()) {
            throw new IllegalArgumentException("Cannot checkout with empty cart");
        }

        try {
            double priceToCheckoutWith = calculateFinalPrice(type, discount);
            PaymentInterface pay = new CardPayment(paymentCard);
            String paymentResult = pay.processPayment(priceToCheckoutWith);
            String transactionId = generateTransactionId();

            boolean status = orderManagementService.startShipment(transactionId);
            if (status == false) {
                throw new Exception("Error is shipping service");
            }
            CheckoutResponse outResponse = new CheckoutResponse(
                    true,
                    paymentResult,
                    priceToCheckoutWith,
                    transactionId);
            NotificationInterface ENotification = new EmailNotification("abc@gmail.com", "cdf@gmail.com");
            ENotification.sendNotification("Thanks you for ordering Your transactionId" + transactionId);
            return outResponse;

        } catch (Exception e) {
            return new CheckoutResponse(
                    false,
                    "Payment processing failed: " + e.getMessage(),
                    0.0,
                    null);
        }
    }

    private void validateProductAndQuantity(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
    }

    private double calculateFinalPrice(DiscountType type, double discount) {
        if (type == DiscountType.FIXED) {
            return applyFixedDiscount(discount);
        } else if (type == DiscountType.PERCENTAGE) {
            return applyPercentageDiscount((int) discount);
        }
        throw new IllegalArgumentException("Invalid discount type");
    }

    private String generateTransactionId() {
        return UUID.randomUUID().toString();
    }
}
