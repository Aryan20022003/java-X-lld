package com.learn.lld.designPrincipal.level1.payment;

public class Card {
    private String cardNumber, holderName;
    private int cvv;

    public Card(String cardNumber, String holderName, int cvv) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.cvv = cvv;
    }

    private Card() {
        // disabled intensionally we need to have card instance with due
        // details
    }

    protected int getCvv() {
        return cvv;
    }

    protected String getCardNumber() {
        return cardNumber;
    }

    protected String getCardHolderName() {
        return holderName;
    }

}
