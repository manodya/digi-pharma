package com.abc.user.respository;

import com.abc.user.entity.PharmacyUser;
import org.springframework.data.repository.CrudRepository;

public interface PharmacyUserRepository extends CrudRepository<PharmacyUser, Long> {
}
