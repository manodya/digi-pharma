package com.abc.delivery.util;

import com.abc.delivery.dto.DeliveryRequestMessage;
import com.abc.delivery.entity.Delivery;

import java.util.Date;

public class DeliveryBuilder {
    public static Delivery getDeliveryEntity(DeliveryRequestMessage requestMessage){
        return new Delivery(
                requestMessage.getOrderId(),
                requestMessage.getCustomerName(),
                requestMessage.getDeliveryLocation(),
                requestMessage.getCustomerContact(),
                requestMessage.getPharmacyName(),
                requestMessage.getPharmacyContact(),
                requestMessage.getPharmacyLocation(),
                DeliveryStatus.STARTED.getStatus(),
                new Date(),
                new Date()
        );
    }
}
