package com.abc.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel
public class UserCreationRequest implements Serializable {
    @ApiModelProperty(name = "Customer Email", required = true)
    @NotBlank(message = "Email is mandatory.")
    private String email;
    @ApiModelProperty(name = "Password", required = true)
    @NotBlank(message = "Password is mandatory.")
    private String password;

    public UserCreationRequest() {
    }

    public UserCreationRequest(@NotBlank(message = "Email is mandatory.") String email, @NotBlank(message = "Password is mandatory.") String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
