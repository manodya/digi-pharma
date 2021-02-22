package com.abc.order.util;

public enum OrderStatus {
    SUBMITTED("Submitted"),
    REJECTED("Rejected"),
    CANCELLED("Cancelled"),
    ACKNOWLEDGED("Acknowledged"),
    READY_FOR_DELIVERY("Ready For Delivery"),
    DELIVERED("Delivered");

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
