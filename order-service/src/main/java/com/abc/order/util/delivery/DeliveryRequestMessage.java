package com.abc.order.util.delivery;

import java.io.Serializable;

public class DeliveryRequestMessage implements Serializable {
    String orderId;
    String customerName;
    String deliveryLocation;
    String customerContact;
    String pharmacyName;
    String pharmacyContact;
    String pharmacyLocation;

    public DeliveryRequestMessage() {
    }

    public DeliveryRequestMessage(String orderId, String customerName, String deliveryLocation, String customerContact, String pharmacyName, String pharmacyContact, String pharmacyLocation) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.deliveryLocation = deliveryLocation;
        this.customerContact = customerContact;
        this.pharmacyName = pharmacyName;
        this.pharmacyContact = pharmacyContact;
        this.pharmacyLocation = pharmacyLocation;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getPharmacyContact() {
        return pharmacyContact;
    }

    public void setPharmacyContact(String pharmacyContact) {
        this.pharmacyContact = pharmacyContact;
    }

    public String getPharmacyLocation() {
        return pharmacyLocation;
    }

    public void setPharmacyLocation(String pharmacyLocation) {
        this.pharmacyLocation = pharmacyLocation;
    }
}
