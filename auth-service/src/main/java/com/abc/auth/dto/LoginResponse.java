package com.abc.auth.dto;

import java.io.Serializable;

public class LoginResponse implements Serializable {
    private final String jwtToken;

    public LoginResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }
}
