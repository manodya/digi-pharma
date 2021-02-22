package com.abc.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel
public class PharmacyRegistrationRequest implements Serializable {

    @ApiModelProperty(name = "Business Name", required = true)
    @NotBlank(message = "Name is mandatory.")
    private String name;
    @ApiModelProperty(name = "Business Location", required = true)
    @NotBlank(message = "Location is mandatory.")
    private String location;
    @ApiModelProperty(name = "ISO Certification ID", required = true)
    @NotBlank(message = "ISO Certification is mandatory.")
    private String isoCertificationID;
    @ApiModelProperty(name = "Contact Information", required = true)
    @NotBlank(message = "Contact information is mandatory.")
    private String contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIsoCertificationID() {
        return isoCertificationID;
    }

    public void setIsoCertificationID(String isoCertificationID) {
        this.isoCertificationID = isoCertificationID;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
