package com.abc.order.controller;

import com.abc.order.dto.*;
import com.abc.order.entity.Order;
import com.abc.order.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/orders", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Success", response = OrderCreationResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ApiOperation(value = "Create new Order.")
    public ResponseEntity<OrderCreationResponse> createOrder( @RequestPart("userId") String userId,
                                                    @RequestPart("pharmacyId") String pharmacyId, @RequestPart("prescription") MultipartFile prescription){
        try {
            return  new ResponseEntity<OrderCreationResponse>(orderService.createOrder(userId,pharmacyId, prescription), HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/orders/{orderId}/cancel")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Success", response = OrderCreationResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ApiOperation(value = "Cancel Order.")
    public ResponseEntity<CancelOrderResponse> cancelOrder(@PathVariable("orderId") String orderId, @RequestBody
    CancelOrderRequest cancelOrderRequest){
        try {
            return  new ResponseEntity<CancelOrderResponse>(orderService.cancelOrder(orderId,cancelOrderRequest), HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/orders/pharmacy/{pharmacyId}/{status}")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Success", response = OrderCreationResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ApiOperation(value = "Get Orders Based on Status. Pending Orders Status - Submitted")
    public ResponseEntity<List<Order>> getOrders(@PathVariable("pharmacyId") String pharmacyId, @PathVariable("status") String status){
        try {
            return  new ResponseEntity<List<Order>>(orderService.getOrders(pharmacyId, status), HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/orders/{orderId}/acknowledge")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Success", response = OrderCreationResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ApiOperation(value = "Acknowledge Order.")
    public ResponseEntity<ModifyOrderStatusResponse> acknowledgeOrder(@PathVariable("orderId") String orderId, @RequestBody
            ModifyOrderStatusRequest modifyOrderStatusRequest){
        try {
            return  new ResponseEntity<ModifyOrderStatusResponse>(orderService.acknowledgeOrder(orderId,modifyOrderStatusRequest), HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/orders/{orderId}/reject")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Success", response = OrderCreationResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ApiOperation(value = "Reject Order.")
    public ResponseEntity<ModifyOrderStatusResponse> rejectOrder(@PathVariable("orderId") String orderId, @RequestBody
            ModifyOrderStatusRequest modifyOrderStatusRequest){
        try {
            return  new ResponseEntity<ModifyOrderStatusResponse>(orderService.rejectOrder(orderId,modifyOrderStatusRequest), HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/orders/{orderId}/delivery")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Success", response = OrderCreationResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ApiOperation(value = "Make Order Ready for the delivery.")
    public ResponseEntity<ModifyOrderStatusResponse> readyOrderForDelivery(@PathVariable("orderId") String orderId, @RequestBody
            ModifyOrderStatusRequest modifyOrderStatusRequest){
        try {
            return  new ResponseEntity<ModifyOrderStatusResponse>(orderService.makeReadyForDelivery(orderId,modifyOrderStatusRequest), HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





}
