package com.webProject.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webProject.orders.entities.OrderItem;
import com.webProject.orders.entities.PK.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
	
}
