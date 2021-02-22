package com.abc.delivery.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "delivery_tbl")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "delivery_location")
    private String deliveryLocation;
    @Column(name = "customer_contact")
    private String customerContact;
    @Column(name = "pharmacy_name")
    private String pharmacyName;
    @Column(name = "pharmacy_contact")
    private String pharmacyContact;
    @Column(name = "pharmacy_location")
    private String pharmacyLocation;
    @Column(name = "status")
    private String deliveryStatus;
    @Column(name = "created_time_stamp")
    @Temporal(TemporalType.TIMESTAMP)
    Date createdTimeStamp;
    @Column(name = "last_updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    Date lastUpdatedTime;


    public Delivery() {
    }

    public Delivery(String orderId, String customerName, String deliveryLocation, String customerContact, String pharmacyName, String pharmacyContact, String pharmacyLocation, String deliveryStatus, Date createdTimeStamp, Date lastUpdatedTime) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.deliveryLocation = deliveryLocation;
        this.customerContact = customerContact;
        this.pharmacyName = pharmacyName;
        this.pharmacyContact = pharmacyContact;
        this.pharmacyLocation = pharmacyLocation;
        this.deliveryStatus = deliveryStatus;
        this.createdTimeStamp = createdTimeStamp;
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Date createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }
}
