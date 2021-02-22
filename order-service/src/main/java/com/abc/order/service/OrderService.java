package com.abc.order.service;

import com.abc.order.dto.*;
import com.abc.order.dto.client.KYC;
import com.abc.order.dto.client.Pharmacy;
import com.abc.order.dto.client.User;
import com.abc.order.entity.FileEntity;
import com.abc.order.entity.Order;
import com.abc.order.repository.FileEntityRepository;
import com.abc.order.repository.OrderRepository;
import com.abc.order.service.client.UserServiceClient;
import com.abc.order.util.OrderResponseMessageConstants;
import com.abc.order.util.OrderStatus;
import com.abc.order.util.OrderValidationUtils;
import com.abc.order.util.delivery.DeliveryObjectBuilder;
import com.abc.order.util.delivery.DeliverySource;
import com.abc.order.util.notification.NotificationBuilder;
import com.abc.order.util.notification.NotificationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    FileEntityRepository fileEntityRepository;

    @Autowired
    UserServiceClient userServiceClient;

    @Autowired
    NotificationSource notificationSource;

    @Autowired
    DeliverySource deliverySource;

    public OrderCreationResponse createOrder(String userId, String pharmacyId, MultipartFile prescription) throws Exception {
        OrderCreationResponse orderCreationResponse = new OrderCreationResponse();
        if (OrderValidationUtils.isFileAcceptable(prescription.getSize())) {
            Order order = new Order(
                    userId,
                    pharmacyId,
                    new Date(),
                    new Date(),
                    OrderStatus.SUBMITTED.getStatus(),
                    "New Order Created."
            );
            Order savedOrder = orderRepository.save(order);
            /*  MultipartFile prescription = orderCreationRequest.getPrescription();*/
            FileEntity file = new FileEntity(
                    String.valueOf(savedOrder.getId()),
                    StringUtils.cleanPath(prescription.getOriginalFilename()),
                    prescription.getContentType(),
                    prescription.getBytes()
            );
            fileEntityRepository.save(file);
            orderCreationResponse.setOrderId(String.valueOf(savedOrder.getId()));

            //Sending Notification
            Pharmacy pharmacy = userServiceClient.getPharmacyDetails(pharmacyId);
            User user = userServiceClient.getUserDetails(userId);
            notificationSource.notifications().send(MessageBuilder.
                    withPayload(NotificationBuilder.getOrderSubmittedMessage(savedOrder, user, pharmacy)).build());

        } else {
            orderCreationResponse.setStatus(false);
            orderCreationResponse.setFailReasons(Arrays.asList(new String[]{OrderResponseMessageConstants.LOW_QUALITY_PRESCRIPTION}));
        }
        return orderCreationResponse;
    }

    public CancelOrderResponse cancelOrder(String orderId, CancelOrderRequest cancelOrderRequest) {
        orderRepository.modifyOrderStatus(Long.valueOf(orderId),
                OrderStatus.CANCELLED.getStatus(),
                new Date(),
                cancelOrderRequest.getRemarks());
        return new CancelOrderResponse();
    }

    public List<Order> getOrders(String pharmacyId, String orderStatus) {
        return orderRepository.findByPharmacyIdAndStatus(pharmacyId, orderStatus);
    }


    public ModifyOrderStatusResponse acknowledgeOrder(String orderId, ModifyOrderStatusRequest modifyOrderStatusRequest) {
        orderRepository.modifyOrderStatus(Long.valueOf(orderId),
                OrderStatus.ACKNOWLEDGED.getStatus(),
                new Date(),
                modifyOrderStatusRequest.getRemarks());
        Order order = orderRepository.findById(Long.parseLong(orderId)).get();
        User user = userServiceClient.getUserDetails(order.getUserId());
        notificationSource.notifications().send(MessageBuilder.
                withPayload(NotificationBuilder.getOrderAcknowledgedMessage(order, user)).build());

        return new ModifyOrderStatusResponse();
    }

    public ModifyOrderStatusResponse rejectOrder(String orderId, ModifyOrderStatusRequest modifyOrderStatusRequest) {
        orderRepository.modifyOrderStatus(Long.valueOf(orderId),
                OrderStatus.REJECTED.getStatus(),
                new Date(),
                modifyOrderStatusRequest.getRemarks());
        Order order = orderRepository.findById(Long.parseLong(orderId)).get();
        User user = userServiceClient.getUserDetails(order.getUserId());
        notificationSource.notifications().send(MessageBuilder.
                withPayload(NotificationBuilder.getOrderRejectedMessage(order, user)).build());

        return new ModifyOrderStatusResponse();
    }

    public ModifyOrderStatusResponse makeReadyForDelivery(String orderId, ModifyOrderStatusRequest modifyOrderStatusRequest) {
        orderRepository.modifyOrderStatus(Long.valueOf(orderId),
                OrderStatus.READY_FOR_DELIVERY.getStatus(),
                new Date(),
                modifyOrderStatusRequest.getRemarks());
        Order order = orderRepository.findById(Long.parseLong(orderId)).get();
        User user = userServiceClient.getUserDetails(order.getUserId());
        Pharmacy pharmacy = userServiceClient.getPharmacyDetails(order.getPharmacyId());
        KYC kyc = userServiceClient.getKYCDetails(order.getUserId());

        deliverySource.deliveries().send(MessageBuilder.withPayload(DeliveryObjectBuilder.getDeliveryRequest(
                user,
                pharmacy,
                order,
                kyc
        )).build());

        notificationSource.notifications().send(MessageBuilder.
                withPayload(NotificationBuilder.getReadyForDeliveryMessage(order, user)).build());

        return new ModifyOrderStatusResponse();
    }
}
