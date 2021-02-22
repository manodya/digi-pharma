package com.abc.delivery;

import com.abc.delivery.dto.DeliveryRequestMessage;
import com.abc.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableDiscoveryClient
@EnableFeignClients
@EnableBinding(Sink.class)
public class DeliveryServiceApplication {

    @Autowired
    DeliveryService deliveryService;

    public static void main(String[] args) {
        SpringApplication.run(DeliveryServiceApplication.class);
    }

    @StreamListener(target = Sink.INPUT)
    public void processNotificationMsg(DeliveryRequestMessage deliveryRequest){
        System.out.println("Delivery Msg received:" + deliveryRequest.toString());
        deliveryService.initiateDelivery(deliveryRequest);
    }
}
