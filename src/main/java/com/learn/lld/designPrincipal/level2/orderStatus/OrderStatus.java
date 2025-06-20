package com.learn.lld.designPrincipal.level2.orderStatus;

public enum OrderStatus {
    NA,//representing state when things are in card not but no payment yet so shipment status
    PENDING,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELLED
}
