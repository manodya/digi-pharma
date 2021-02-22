package com.abc.delivery.repository;

import com.abc.delivery.entity.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
}
