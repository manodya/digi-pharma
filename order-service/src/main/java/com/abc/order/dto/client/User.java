package com.abc.order.dto.client;

import javax.persistence.*;


public class User {
    private Long id;
    private String email;
    private String password;
    private String accountStatus;
    private String activationCode;

    public User() {
    }

    public User(String email, String password, String activationCode, String accountStatus) {
        this.email = email;
        this.password = password;
        this.activationCode = activationCode;
        this.accountStatus = accountStatus;
    }



    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public String getActivationCode() {
        return activationCode;
    }


}
