package com.abc.user.controller;

import com.abc.user.UserServiceApplication;
import com.abc.user.dto.UserCreationRequest;
import com.abc.user.dto.UserCreationResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserControllerIntegrationTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testUserCreation() {
        UserCreationRequest userCreationRequest = new UserCreationRequest(
                "test@gmail.com", "password");
        HttpEntity<UserCreationRequest> entity = new HttpEntity<UserCreationRequest>(userCreationRequest, headers);

        ResponseEntity<UserCreationResponse> response = restTemplate.exchange(
                "http://localhost:" + port + "/users",
                HttpMethod.POST, entity, UserCreationResponse.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);

    }
}
