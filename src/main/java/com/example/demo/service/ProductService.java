package com.example.demo.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.function.Supplier;

import javax.management.RuntimeErrorException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResource;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;

import javassist.NotFoundException;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryService categoryService;
	
	public Product ProductPost(Product product) throws IOException
	{
		return productRepository.save(product);
	}
	
	public List<Product> ProductGetAll()
	{
		return productRepository.findAll();
	}
	
	public Product ProductGetById(Integer id) 
	{
		return productRepository.findById(id).get();
	}
	
	public List<Product> ProductGetByCategory(Category category)
	{
		return productRepository.findByCategory(category);
	}
	
	public String ProductDeleteAll()
	{
		productRepository.deleteAll();
		return "All Data Has Been Deleted";
	}
}