package com.abc.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel
public class KYCUpdateRequest implements Serializable {
    private static final long serialVersionUID = 129345938L;

    @ApiModelProperty(name = "Address", required = true)
    @NotBlank(message = "Address is mandatory.")
    private String address;

    @ApiModelProperty(name = "Contact No", required = true)
    @NotBlank(message = "Contact No is mandatory.")
    private String contactNo;

    @ApiModelProperty(name = "First Name", required = true)
    @NotBlank(message = "First Name is mandatory.")
    private String firstName;

    @ApiModelProperty(name = "Last Name", required = true)
    @NotBlank(message = "Last Name is mandatory.")
    private String lastName;

    public String getAddress() {
        return address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
