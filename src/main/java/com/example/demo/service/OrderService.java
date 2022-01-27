package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.entities.Orders;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.repository.UserRepository;

@Service
public class OrderService {
	@Autowired
	private OrdersRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Orders OrderPost(Orders order)
	{
		return orderRepository.save(order);
	}
	
	public List<Orders> OrderGetAll()
	{
		return  orderRepository.findAll();
	}
	
	public Orders OrderGetById(Integer id)
	{
		return  orderRepository.findById(id).orElse(null);
	}
	
	public String OrderDeleteAll()
	{
		orderRepository.deleteAll();
		return "All Data Has Been Deleted";
	}
}
