package com.abc.notification;

import com.abc.notification.dto.NotificationMessage;
import com.abc.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@SpringBootApplication
@EnableDiscoveryClient
public class NotificationServiceApplication {

    @Autowired
    NotificationService notificationService;

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }


    @StreamListener(target = Sink.INPUT)
    public void processNotificationMsg(NotificationMessage notification){
        System.out.println("Notification Msg received:" + notification.toString());
        notificationService.sendNotification(notification);
    }
}
