package com.abc.order.repository;

import com.abc.order.entity.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface OrderRepository  extends CrudRepository<Order, Long> {

    @Modifying(clearAutomatically = false)
    @Query("UPDATE Order o SET o.status =:status, o.lastModifiedTime =:lastModifiedTime, o.remarks =:remarks  WHERE o.id =:id")
    int modifyOrderStatus(@Param("id") long id, @Param("status") String status,
                    @Param("lastModifiedTime")Date lastModifiedTime,
                    @Param("remarks") String remarks);

    List<Order> findByIdAndStatus(long id, String status);

    List<Order> findByPharmacyIdAndStatus(String id, String status);

}
