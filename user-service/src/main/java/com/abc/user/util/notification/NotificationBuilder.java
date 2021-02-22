package com.abc.user.util.notification;

import com.abc.user.entity.User;
import org.springframework.context.annotation.Bean;

public class NotificationBuilder {
    public static NotificationMessage getAccountActivationMessage(User user){
        return new NotificationMessage(
                String.valueOf(user.getId()),
                user.getEmail(),
                "Digi Pharma - Activate New Account",
                "Please Activate Your Account, Activation Code:" + user.getActivationCode()
        );
    }
}
