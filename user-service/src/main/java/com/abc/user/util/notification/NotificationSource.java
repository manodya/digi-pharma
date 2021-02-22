package com.abc.user.util.notification;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface NotificationSource {
    @Output("notificationChannel")
    MessageChannel notifications();
}
