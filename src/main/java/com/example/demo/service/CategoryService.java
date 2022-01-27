package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category CategoryPost(Category category)
	{
		return categoryRepository.save(category);
	}
	
	public List<Category> CategoryGetAll()
	{
		return  categoryRepository.findAll();
	}
	
	public Category CategoryGetById(Integer id)
	{
		return  categoryRepository.findById(id).orElse(null);
	}
	
	public String CategoryDeleteAll()
	{
		categoryRepository.deleteAll();
		return "All Data Has Been Deleted";
	}
}
