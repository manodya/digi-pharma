package com.abc.user.respository;

import com.abc.user.entity.KYC;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KYCRepository  extends CrudRepository<KYC, Long> {
    @Query("SELECT k FROM KYC k  WHERE k.userId= :userId")
    KYC findByUserId(@Param("userId") Long userId);

}
