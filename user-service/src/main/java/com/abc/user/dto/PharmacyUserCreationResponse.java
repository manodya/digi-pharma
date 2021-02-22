package com.abc.user.dto;

import java.io.Serializable;

public class PharmacyUserCreationResponse extends CommonUserResponse implements Serializable {
    private static final long serialVersionUID = 129346938L;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
