package com.learn.lld.designPrincipal.level2.orderStatus;

public class OrderManager {
    private OrderStatus currentStatus;
    private String transactionId;

    public OrderManager() {
        transactionId = null;
        currentStatus = OrderStatus.NA;
    }

    public boolean updateOrderStatus() {
        // some update strategy like from state A can move to state B only or so.
        return true;
    }

    public boolean cancelOrder() {

        // special methods because lot of things need to trigger with this like refund ,
        // checking it's cancellable order or not and so on .
        return true;
    }

    public boolean startShipment(String transactionId) {
        // Similar to chancel lot of things need to some here like cancel might be
        // complete wrong is there is better pl please tell.
        if (currentStatus != OrderStatus.NA || transactionId != null) {
            // shipping is already at some other state other than null state .
            return false;
        }
        this.currentStatus = OrderStatus.PENDING;
        this.transactionId = transactionId;
        return true;
    }

}
