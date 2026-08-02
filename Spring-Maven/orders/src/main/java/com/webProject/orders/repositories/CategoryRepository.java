package com.webProject.orders.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webProject.orders.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
