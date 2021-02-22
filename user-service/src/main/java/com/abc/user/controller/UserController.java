package com.abc.user.controller;


import com.abc.user.dto.*;
import com.abc.user.entity.KYC;
import com.abc.user.entity.Pharmacy;
import com.abc.user.entity.User;
import com.abc.user.service.UserService;
/*import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;*/
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

   // private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping("/users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = UserCreationResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ApiOperation(value = "Create new User.")
    public ResponseEntity<UserCreationResponse> createUser(@Valid @RequestBody UserCreationRequest userCreationRequest) {
        try {
            return new ResponseEntity<UserCreationResponse>(userService.createUser(userCreationRequest), HttpStatus.OK);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users/{id}/activation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = AccountActivationResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ApiOperation(value = "Activate Account.")
    public ResponseEntity<AccountActivationResponse> activateAccount(@Valid @PathVariable("id") String userId, @RequestBody AccountActivationRequest accountActivationRequest) {
        try {
            return new ResponseEntity<AccountActivationResponse>(userService.activateAccount(userId, accountActivationRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users/{id}/kyc")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = AccountActivationResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ApiOperation(value = "Update user KYC.")
    public ResponseEntity<KYCUpdateResponse> updateKYC(@Valid @PathVariable("id") String userId, @RequestBody KYCUpdateRequest kycUpdateRequest) {
        try {
            return new ResponseEntity<KYCUpdateResponse>(userService.updateKYC(userId, kycUpdateRequest), HttpStatus.OK);
        } catch (Exception exception) {
         //   logger.error("Error found: {}", exception);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/pharmacies")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = AccountActivationResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ApiOperation(value = "Register Pharmacy")
    public ResponseEntity<PharmacyRegistrationResponse> registerPharmacy(@Valid @RequestBody PharmacyRegistrationRequest pharmacyRegistrationRequest) {
        try {
            return new ResponseEntity<PharmacyRegistrationResponse>(userService.registerPharmacy(pharmacyRegistrationRequest), HttpStatus.OK);
        } catch (Exception exception) {
         //   logger.error("Error found: {}", exception);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/pharmacies/{pharmacyId}/user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = AccountActivationResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ApiOperation(value = "Register Pharmacy User")
    public ResponseEntity<PharmacyUserCreationResponse> registerPharmacyUser(@PathVariable("pharmacyId") String pharmacyId, @Valid @RequestBody PharmacyUserCreationRequest pharmacyRegistrationRequest) {
        try {
            return new ResponseEntity<PharmacyUserCreationResponse>(userService.registerPharmacyUser(pharmacyId, pharmacyRegistrationRequest), HttpStatus.OK);
        } catch (Exception exception) {
         //   logger.error("Error found: {}", exception);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable("id") String userId) {
        return userService.getUserDetails(userId);
    }

    @GetMapping("/pharmacies/{id}")
    public Pharmacy findPharmacy(@PathVariable("id") String pharmacyId) {
        return userService.getPharmacyDetails(pharmacyId);
    }

    @GetMapping("/users/{id}/kyc")
    public KYC getUserKYC(@Valid @PathVariable("id") String userId) {
        return userService.getUserKYC(userId);
    }

    @GetMapping("/users/email/{email}")
    public User getUserByUserId(@Valid @PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }


}
