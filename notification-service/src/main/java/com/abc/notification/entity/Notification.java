package com.abc.notification.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notification_tbl")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private String userId;
    @Column
    private String toEmail;
    @Column(name = "msg_subject")
    private String messageSubject;
    @Column(name = "msg_body")
    private String messageBody;
    @Column(name = "time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    Date timeStamp;

    public Notification() {
    }

    public Notification(String userId, String toEmail, String messageSubject, String messageBody, Date timeStamp) {
        this.userId = userId;
        this.toEmail = toEmail;
        this.messageSubject = messageSubject;
        this.messageBody = messageBody;
        this.timeStamp = timeStamp;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
