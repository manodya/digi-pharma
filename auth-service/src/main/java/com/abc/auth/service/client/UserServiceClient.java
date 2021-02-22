package com.abc.auth.service.client;


import com.abc.auth.dto.client.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserServiceClient {

    @GetMapping(value = "/users/email/{email}")
    public User getUserByUserId(@PathVariable("email") String email);
}
