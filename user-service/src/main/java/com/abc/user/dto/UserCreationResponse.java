package com.abc.user.dto;

import java.io.Serializable;

public class UserCreationResponse extends CommonUserResponse implements Serializable {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
