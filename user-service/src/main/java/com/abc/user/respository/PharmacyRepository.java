package com.abc.user.respository;

import com.abc.user.entity.Pharmacy;
import org.springframework.data.repository.CrudRepository;

public interface PharmacyRepository extends CrudRepository<Pharmacy, Long> {
}
