package com.abc.user.service;

import com.abc.user.dto.*;
import com.abc.user.entity.KYC;
import com.abc.user.entity.Pharmacy;
import com.abc.user.entity.PharmacyUser;
import com.abc.user.entity.User;
import com.abc.user.respository.KYCRepository;
import com.abc.user.respository.PharmacyRepository;
import com.abc.user.respository.PharmacyUserRepository;
import com.abc.user.respository.UserRepository;
import com.abc.user.util.AccountStatus;
import com.abc.user.util.AccountVerificationUtils;
import com.abc.user.util.UserResponseMessageConstants;
import com.abc.user.util.notification.NotificationBuilder;
import com.abc.user.util.notification.NotificationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    KYCRepository kycRepository;

    @Autowired
    PharmacyRepository pharmacyRepository;

    @Autowired
    PharmacyUserRepository pharmacyUserRepository;

    @Autowired
    NotificationSource notificationSource;


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * @param userCreationRequest
     * @return
     * @throws Exception
     */
    public UserCreationResponse createUser(UserCreationRequest userCreationRequest) throws Exception {

        UserCreationResponse userCreationResponse = new UserCreationResponse();
        if (userRepository.existsByEmail(userCreationRequest.getEmail())) {
            userCreationResponse.setStatus(false);
            userCreationResponse.setFailReasons(Arrays.asList(UserResponseMessageConstants.USER_ALREADY_EXISTS));
        } else {
            User user = new User(userCreationRequest.getEmail()
                    , bCryptPasswordEncoder.encode(userCreationRequest.getPassword())
                    , AccountVerificationUtils.generateActivationCode()
                    , AccountStatus.OPEN_PENDING_ACTIVATION.getStatus());
            User savedUser = userRepository.save(user);

            /*--Send Notification on User Creation--*/
            notificationSource.notifications().send(MessageBuilder.withPayload(NotificationBuilder.getAccountActivationMessage(savedUser)).build());
            userCreationResponse.setUserId(String.valueOf(savedUser.getId()));
        }
        return userCreationResponse;
    }

    /**
     * @param userId
     * @param accountActivationRequest
     * @return
     * @throws Exception
     */
    public AccountActivationResponse activateAccount(String userId, AccountActivationRequest accountActivationRequest) throws Exception {
        AccountActivationResponse accountActivationResponse = new AccountActivationResponse();
        if (userRepository.existsById(Long.valueOf(userId))) {
            Optional<User> user = userRepository.findById(Long.valueOf(userId));
            if (user.get().getActivationCode().equalsIgnoreCase(accountActivationRequest.getActivationCode())) {
                User updatedUser = user.get();
                updatedUser.setAccountStatus(AccountStatus.ACTIVATED_PENDING_KYC.getStatus());
                userRepository.save(updatedUser);
                accountActivationResponse.setActivationRemark(UserResponseMessageConstants.ACCOUNT_ACTIVATED_PENDING_KYC);

            } else {
                User updatedUser = user.get();
                updatedUser.setAccountStatus(AccountStatus.ACTIVATION_FAILED.getStatus());
                userRepository.save(updatedUser);
                accountActivationResponse.setStatus(false);
                accountActivationResponse.setFailReasons(Arrays.asList(UserResponseMessageConstants.INVALID_ACTIVATION_CODE));
            }

        } else {
            accountActivationResponse.setStatus(false);
            accountActivationResponse.setFailReasons(Arrays.asList(UserResponseMessageConstants.USER_DOES_NOT_EXIST));

        }
        return accountActivationResponse;
    }

    /**
     * @param userId
     * @param kycUpdateRequest
     * @return
     * @throws Exception
     */
    public KYCUpdateResponse updateKYC(String userId, KYCUpdateRequest kycUpdateRequest) throws Exception {
        KYCUpdateResponse kycUpdateResponse = new KYCUpdateResponse();
        KYC kyc = new KYC(Long.valueOf(userId),
                kycUpdateRequest.getAddress(),
                kycUpdateRequest.getContactNo(),
                kycUpdateRequest.getFirstName(),
                kycUpdateRequest.getLastName()

        );
        kycRepository.save(kyc);
        userRepository.updateUserAccountStatus(Long.valueOf(userId), AccountStatus.ACTIVATED.getStatus());
        return kycUpdateResponse;

    }

    public PharmacyRegistrationResponse registerPharmacy(PharmacyRegistrationRequest pharmacyRegistrationRequest) throws Exception {
        PharmacyRegistrationResponse pharmacyRegistrationResponse = new PharmacyRegistrationResponse();
        Pharmacy pharmacy = new Pharmacy(
                pharmacyRegistrationRequest.getName(),
                pharmacyRegistrationRequest.getLocation(),
                pharmacyRegistrationRequest.getIsoCertificationID(),
                pharmacyRegistrationRequest.getContact()
        );
        Pharmacy registeredPharmacy = pharmacyRepository.save(pharmacy);
        pharmacyRegistrationResponse.setRegistrationId(String.valueOf(registeredPharmacy.getId()));
        return pharmacyRegistrationResponse;
    }

    /**
     * @param pharmacyId
     * @param pharmacyUserCreationRequest
     * @return
     * @throws Exception
     */
    public PharmacyUserCreationResponse registerPharmacyUser(String pharmacyId, PharmacyUserCreationRequest pharmacyUserCreationRequest) throws Exception {
        PharmacyUserCreationResponse pharmacyUserCreationResponse = new PharmacyUserCreationResponse();
        PharmacyUser pharmacyUser = new PharmacyUser(
                Long.valueOf(pharmacyId),
                pharmacyUserCreationRequest.getUserName(),
                bCryptPasswordEncoder.encode(pharmacyUserCreationRequest.getPassword())
        );
        PharmacyUser savedPharmacyUser = pharmacyUserRepository.save(pharmacyUser);
        pharmacyUserCreationResponse.setUserId(String.valueOf(savedPharmacyUser.getId()));
        return pharmacyUserCreationResponse;
    }

    /**
     * @param pharmacyId
     * @return
     */
    public Pharmacy getPharmacyDetails(String pharmacyId) {
        return pharmacyRepository.findById(Long.valueOf(pharmacyId)).get();
    }

    /**
     * @param userId
     * @return
     */
    public User getUserDetails(String userId) {
        return userRepository.findById(Long.valueOf(userId)).get();
    }

    /**
     * @param userId
     * @return
     */
    public KYC getUserKYC(String userId) {
        return kycRepository.findByUserId(Long.parseLong(userId));
    }


    public User getUserByEmail(String userId) {
        return userRepository.findByEmail(userId);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
