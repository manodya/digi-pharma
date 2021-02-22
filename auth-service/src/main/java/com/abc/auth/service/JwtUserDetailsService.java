package com.abc.auth.service;

import com.abc.auth.dto.client.User;
import com.abc.auth.service.client.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UserServiceClient userServiceClient;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        try{
            User user = userServiceClient.getUserByUserId(userName);
                return  new  org.springframework.security.core.userdetails.User(user.getEmail(),
                        user.getPassword(), new ArrayList<>());
        }catch (Exception e) {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }
    }
}
