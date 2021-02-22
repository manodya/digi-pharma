package com.abc.order.util.delivery;

import com.abc.order.dto.client.KYC;
import com.abc.order.dto.client.Pharmacy;
import com.abc.order.dto.client.User;
import com.abc.order.entity.Order;

public class DeliveryObjectBuilder {

    public static DeliveryRequestMessage getDeliveryRequest(User user, Pharmacy pharmacy, Order order, KYC kyc){
      return new DeliveryRequestMessage( String.valueOf(order.getId()),
        kyc.getFirstName() + " " + kyc.getLastName(),
        kyc.getAddress(),
        kyc.getContact(),
        pharmacy.getName(),
        pharmacy.getContact(),
        pharmacy.getLocation());
    }
}
