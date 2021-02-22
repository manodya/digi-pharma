package com.abc.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@ApiModel
public class OrderCreationRequest {
    private static final long serialVersionUID = 179348938L;
    @ApiModelProperty(name = "User ID", required = true)
    private String userId;
    @ApiModelProperty(name = "Pharmacy ID", required = true)
    private String pharmacyId;


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
