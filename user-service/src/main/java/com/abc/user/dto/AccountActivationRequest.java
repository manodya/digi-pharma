package com.abc.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel
public class AccountActivationRequest implements Serializable {

    private static final long serialVersionUID = 129348338L;
    @ApiModelProperty(name = "Activation Code", required = true)
    @NotBlank(message = "Activation Code is mandatory.")
    private String activationCode;

    public AccountActivationRequest(@NotBlank(message = "Activation Code is mandatory.") String activationCode) {
        this.activationCode = activationCode;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }
}
