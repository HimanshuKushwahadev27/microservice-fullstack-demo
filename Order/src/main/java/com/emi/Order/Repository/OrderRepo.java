package com.emi.order.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.emi.order.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
