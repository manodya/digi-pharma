package com.abc.user.service;

import com.abc.user.UserServiceApplication;
import com.abc.user.dto.AccountActivationRequest;
import com.abc.user.dto.AccountActivationResponse;
import com.abc.user.dto.UserCreationRequest;
import com.abc.user.dto.UserCreationResponse;
import com.abc.user.entity.User;
import com.abc.user.respository.UserRepository;
import com.abc.user.util.AccountStatus;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserServiceApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
/*@Rollback(value = false)*/
@Transactional
public class UserServiceUnitTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    @Order(1)
    @Rollback(false)
    public void testCreateUser() throws Exception {
        UserCreationRequest userCreationRequest = getUsr();
        UserCreationResponse response = userService.createUser(userCreationRequest);
        TestTransaction.flagForCommit();
        TestTransaction.end();
        assertEquals(userRepository.findById(Long.parseLong(response.getUserId())).get().getEmail(), userCreationRequest.getEmail());
        response = userService.createUser(userCreationRequest);
        assertFalse(response.getStatus());
    }


    @Test
    @Order(2)
    @Rollback(false)
    public void testActivateAccount() throws Exception {
        userService.createUser(getUsr());
        User user = userRepository.findById(Long.valueOf("1")).get();
        AccountActivationRequest accountActivationRequest =
                new AccountActivationRequest("124");
        AccountActivationResponse response = userService.activateAccount("1", accountActivationRequest);
        assertFalse(response.getStatus());
        assertEquals(userRepository.findById(1L).get().getAccountStatus(), AccountStatus.ACTIVATION_FAILED.getStatus());
        accountActivationRequest.setActivationCode(user.getActivationCode());
        response = userService.activateAccount("1", accountActivationRequest);
        assertTrue(response.getStatus());
        assertEquals(userRepository.findById(1L).get().getAccountStatus(), AccountStatus.ACTIVATED_PENDING_KYC.getStatus());
    }

    private UserCreationRequest getUsr() {
        return new UserCreationRequest("test@gmail.com", "password");
    }
}
