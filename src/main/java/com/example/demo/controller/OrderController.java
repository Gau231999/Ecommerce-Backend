package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Orders;
import com.example.demo.entities.Product;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.service.OrderService;

@CrossOrigin("/**")
@RestController
@RequestMapping("/Order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/Save")
	public Orders saveOrder(@RequestBody Orders order) throws IOException
	{
		return orderService.OrderPost(order);
	}
	
	@GetMapping("/GetAll")
	public List<Orders> getOrders()
	{
		return orderService.OrderGetAll();
	}
	
	@GetMapping("/GetById/{orderId}")
	public Orders getOrder(@PathVariable Integer orderId)
	{
		return orderService.OrderGetById(orderId);
	}
	
	@GetMapping("/DeleteAll")
	public String deleteAll()
	{
		return orderService.OrderDeleteAll();
	}
}
