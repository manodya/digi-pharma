package com.abc.order.util.delivery;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface DeliverySource {
    @Output("deliveryChannel")
    MessageChannel deliveries();
}
