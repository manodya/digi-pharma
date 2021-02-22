package com.abc.delivery.service;

import com.abc.delivery.dto.DeliveryRequestMessage;
import com.abc.delivery.repository.DeliveryRepository;
import com.abc.delivery.util.DeliveryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    public void initiateDelivery(DeliveryRequestMessage deliveryRequest){
            deliveryRepository.save(DeliveryBuilder.getDeliveryEntity(deliveryRequest));
    }
}
