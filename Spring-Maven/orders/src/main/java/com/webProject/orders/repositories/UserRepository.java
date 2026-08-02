package com.webProject.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webProject.orders.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
