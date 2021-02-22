package com.abc.order.service.client;

import com.abc.order.dto.client.KYC;
import com.abc.order.dto.client.Pharmacy;
import com.abc.order.dto.client.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service")
public interface UserServiceClient {

    @GetMapping(value = "/pharmacies/{pharmacyId}")
    public Pharmacy getPharmacyDetails( @PathVariable("pharmacyId") String pharmacyId);

    @GetMapping(value = "/users/{userId}")
    public User getUserDetails( @PathVariable("userId") String userId);

    @GetMapping(value = "/users/{userId}/kyc")
    public KYC getKYCDetails(@PathVariable("userId") String userId);
}
