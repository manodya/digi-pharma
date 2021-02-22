package com.abc.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel
public class PharmacyUserCreationRequest implements Serializable {
    @ApiModelProperty(name = "User Name", required = true)
    @NotBlank(message = "User Name is mandatory.")
    private String userName;
    @ApiModelProperty(name = "Password", required = true)
    @NotBlank(message = "Password is mandatory.")
    private String password;

    public PharmacyUserCreationRequest() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
