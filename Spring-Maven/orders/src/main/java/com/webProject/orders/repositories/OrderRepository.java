package com.webProject.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webProject.orders.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
