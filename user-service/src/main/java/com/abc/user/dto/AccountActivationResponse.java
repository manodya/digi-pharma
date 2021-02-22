package com.abc.user.dto;

import java.io.Serializable;

public class AccountActivationResponse extends CommonUserResponse implements Serializable {
    private static final long serialVersionUID = 129348438L;

    private String activationRemark;

    public String getActivationRemark() {
        return activationRemark;
    }

    public void setActivationRemark(String activationRemark) {
        this.activationRemark = activationRemark;
    }
}
