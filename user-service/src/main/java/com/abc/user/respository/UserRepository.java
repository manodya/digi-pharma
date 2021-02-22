package com.abc.user.respository;

import com.abc.user.entity.KYC;
import com.abc.user.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByEmail(String email);

    @Modifying(clearAutomatically = false)
    @Query("UPDATE User u SET u.accountStatus = :accountStatus WHERE u.id = :id")
    int updateUserAccountStatus(@Param("id") long id, @Param("accountStatus") String accountStatus);


    @Query("SELECT u FROM User u  WHERE u.email= :email")
    User findByEmail(@Param("email") String email);
}
