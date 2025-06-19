package com.learn.lld.designPrincipal.level1.checkout;

public class CheckoutResponse {
    private final boolean success;
    private final String message;
    private final double finalAmount;
    private final String transactionId;

    public CheckoutResponse(boolean success, String message, double finalAmount, String transactionId) {
        this.success = success;
        this.message = message;
        this.finalAmount = finalAmount;
        this.transactionId = transactionId;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
