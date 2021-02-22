package com.abc.notification.service;

import com.abc.notification.dto.NotificationMessage;
import com.abc.notification.entity.Notification;
import com.abc.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    NotificationRepository notificationRepository;

    public void sendNotification(NotificationMessage notificationMessage){
        notificationRepository.save(new Notification(
                notificationMessage.getUserId(),
                notificationMessage.getToEmail(),
                notificationMessage.getMessageSubject(),
                notificationMessage.getMessageBody(),
                new Date()
        ));
        String from = "digipharmainc@gmail.com";


        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(notificationMessage.getToEmail());
        message.setSubject(notificationMessage.getMessageSubject());
        message.setText(notificationMessage.getMessageBody());
        System.out.println("Email Sent:" + message.toString());

        mailSender.send(message);

    }
}
