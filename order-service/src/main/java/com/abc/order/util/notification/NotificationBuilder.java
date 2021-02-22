package com.abc.order.util.notification;

import com.abc.order.dto.client.Pharmacy;
import com.abc.order.dto.client.User;
import com.abc.order.entity.Order;


public class NotificationBuilder {
    public static NotificationMessage getOrderSubmittedMessage(Order order, User user, Pharmacy pharmacy) {
        return new NotificationMessage(
                order.getUserId(),
                user.getEmail(),
                "Digi Pharma - New Order",
                "Your New Order to," + pharmacy.getName() + " , is submitted, Order Number:" + order.getId() +
                        " ,For Inquiries ,Please Contact " + pharmacy.getContact()
        );
    }

    public static NotificationMessage getOrderAcknowledgedMessage(Order order, User user) {
        return new NotificationMessage(
                order.getUserId(),
                user.getEmail(),
                "Digi Pharma - New Order",
                "Your Order , order Id :" + order.getId() + " , is Accepted and started Processing."
        );
    }

    public static NotificationMessage getOrderRejectedMessage(Order order, User user) {
        return new NotificationMessage(
                order.getUserId(),
                user.getEmail(),
                "Digi Pharma - New Order",
                "Your Order , order Id :" + order.getId() + " , is Rejected . Remarks:" + order.getRemarks()
        );
    }

    public static NotificationMessage getReadyForDeliveryMessage(Order order, User user) {
        return new NotificationMessage(
                order.getUserId(),
                user.getEmail(),
                "Digi Pharma - New Order",
                "Your Order , order Id :" + order.getId() + " , is Ready for the delivery . "
        );
    }
}
