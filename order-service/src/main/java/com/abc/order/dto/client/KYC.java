package com.abc.order.dto.client;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


public class KYC {
    private Long id;
    private Long userId;
    private String address;
    private String contact;
    private String firstName;
    private String lastName;

    public KYC() {
    }

    public KYC(Long id, Long userId, String address, String contact, String firstName, String lastName) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.contact = contact;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
