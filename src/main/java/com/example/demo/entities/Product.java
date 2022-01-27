package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;



@Entity
@Table(name="ProductTable") 
public class Product {
	@Id
	@GeneratedValue
	private int productId;
	@NotNull
	private int productPrice;
	@NotNull
	private int productDiscount;
	@NotNull
	private String productName;
	@NotNull
	private String productDescription;
	private String productImageDeploymentPath;
	@NotNull
	private String productQuantity;
	
	@ManyToOne
	private Category category;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, int productPrice, int productDiscount, String productName, String productDescription,
			String productImageDeploymentPath, String productQuantity) {
		super();
		this.productId = productId;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productImageDeploymentPath = productImageDeploymentPath;
		this.productQuantity = productQuantity;
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(int productDiscount) {
		this.productDiscount = productDiscount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImageDeploymentPath() {
		return productImageDeploymentPath;
	}

	public void setProductImageDeploymentPath(String productImageDeploymentPath) {
		this.productImageDeploymentPath = productImageDeploymentPath;
	}

	public String getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productPrice=" + productPrice + ", productDiscount="
				+ productDiscount + ", productName=" + productName + ", productDescription=" + productDescription
				+ ", productImageDeploymentPath=" + productImageDeploymentPath + ", productQuantity=" + productQuantity
				+ ", category=" + category + "]";
	}


	
}
