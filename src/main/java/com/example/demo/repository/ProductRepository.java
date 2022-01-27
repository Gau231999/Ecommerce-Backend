package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;

public interface ProductRepository extends JpaRepository<Product,Integer> {
	List<Product> findByCategory(Category category);
}
