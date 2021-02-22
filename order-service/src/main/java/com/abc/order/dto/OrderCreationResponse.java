package com.abc.order.dto;

public class OrderCreationResponse  extends CommonOrderResponse{

    private static final long serialVersionUID = 129348958L;
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
