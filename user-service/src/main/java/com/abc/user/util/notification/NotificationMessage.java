package com.abc.user.util.notification;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;


public class NotificationMessage implements Serializable {
    private String userId;
    private String toEmail;
    private String messageSubject;
    private String messageBody;

    public NotificationMessage() {
    }

    public NotificationMessage(String userId, String toEmail,String messageSubject, String messageBody) {
        this.userId = userId;
        this.toEmail = toEmail;
        this.messageSubject = messageSubject;
        this.messageBody = messageBody;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getMessageSubject() {
        return messageSubject;
    }

    public void setMessageSubject(String messageSubject) {
        this.messageSubject = messageSubject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
