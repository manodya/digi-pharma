package com.abc.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@ApiModel
public class OrderCreationRequest {
    @ApiModelProperty(name = "User ID", required = true)
  /*  @NotBlank(message = "UserId is mandatory.")*/
    private String userId;
    @ApiModelProperty(name = "Pharmacy ID", required = true)
   /* @NotBlank(message = "PharmacyId is mandatory.")*/
    private String pharmacyId;

  /*  @ApiModelProperty(name = "Prescription", required = true)
    private MultipartFile prescription;*/

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(String pharmacyId) {
        this.pharmacyId = pharmacyId;
    }
/*
    public MultipartFile getPrescription() {
        return prescription;
    }

    public void setPrescription(MultipartFile prescription) {
        this.prescription = prescription;
    }*/
}
