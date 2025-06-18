package com.learn.lld.designPrincipal.level1.payment;

import java.math.BigDecimal;

public class CardPayment implements PaymentInterface {
    private final Card cardDetail;

    public CardPayment(Card cardDetail) {
        this.cardDetail = cardDetail;
    }

    @Override
    public String processPayment(BigDecimal amount) {
        return "Card Process done of amount" + amount;
    }
}