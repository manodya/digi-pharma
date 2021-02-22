package com.abc.user.dto;

import java.io.Serializable;

public class UserCreationResponse extends CommonUserResponse implements Serializable {
    private static final long serialVersionUID = 129348638L;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
