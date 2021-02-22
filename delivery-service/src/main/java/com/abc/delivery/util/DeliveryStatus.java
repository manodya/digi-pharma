package com.abc.delivery.util;

public enum DeliveryStatus {
    STARTED("Started"),
    DELIVERED("Delivered");

    private final String status;

    DeliveryStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
