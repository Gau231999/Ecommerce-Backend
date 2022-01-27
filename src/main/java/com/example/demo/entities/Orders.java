package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;


@Entity
@Table(name="OrdersTable") 
public class Orders {
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private int orderId;
	
	@NotNull
	@ManyToMany
	private List<Product> product = new ArrayList<>();
	
	@NotNull
	@ManyToOne
	private User user;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(int orderId, List<Product> product, User user) {
		super();
		this.orderId = orderId;
		this.product = product;
		this.user = user;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", product=" + product + ", user=" + user + "]";
	}
	
	
}
