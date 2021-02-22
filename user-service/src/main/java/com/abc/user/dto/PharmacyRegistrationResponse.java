package com.abc.user.dto;

import java.io.Serializable;

public class PharmacyRegistrationResponse extends CommonUserResponse implements Serializable {
    private String registrationId;

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
}
