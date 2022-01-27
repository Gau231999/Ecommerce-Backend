package com.example.demo.controller;

import java.awt.image.BufferedImage;
import java.io.File;import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.validation.Valid;

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

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

@CrossOrigin("/**")
@RestController
@RequestMapping("/Product")
public class ProductCategory {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/Save")
	public Product saveProduct(@RequestBody Product product) throws IOException
	{
		System.out.println(product.toString());
		return productService.ProductPost(product);
	}
	
	@GetMapping("/GetAll")
	public List<Product> getProducts() throws IOException
	{
		return productService.ProductGetAll();
	}
	
	@GetMapping("/GetById/{productId}")
	public Product getProduct(@PathVariable Integer productId)
	{
		return productService.ProductGetById(productId);
	}
	
	@GetMapping("/GetByCategoryId/{categoryId}")
	public List<Product> getProductByCategory(@PathVariable Integer categoryId)
	{
		Category category = categoryService.CategoryGetById(categoryId);
		return productService.ProductGetByCategory(category);
	}
	
	@GetMapping("/DeleteAll")
	public String deleteAll()
	{
		return productService.ProductDeleteAll();
	}
}
