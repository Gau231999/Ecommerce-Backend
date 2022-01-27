package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.service.CategoryService;

@CrossOrigin("/**")
@RestController
@RequestMapping("/Category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	

	@PostMapping("/Save")
	public Category saveCategory(@RequestBody Category category)
	{
		return categoryService.CategoryPost(category);
	}
	
	@GetMapping("/GetAll")
	public List<Category> getCategory()
	{
		return categoryService.CategoryGetAll();
	}
	
	@GetMapping("/Get/{id}")
	public Category getCategoryById(@PathVariable Integer id)
	{
		return categoryService.CategoryGetById(id);
	}
	
	@GetMapping("/DeleteAll")
	public String deleteAllCategory()
	{
		return categoryService.CategoryDeleteAll();
	}
}
