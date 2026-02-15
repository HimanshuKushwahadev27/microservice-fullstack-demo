package com.emi.Order.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.emi.Order.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
