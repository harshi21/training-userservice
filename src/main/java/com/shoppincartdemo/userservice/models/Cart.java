package com.shoppincartdemo.userservice.models;

import java.util.List;

public class Cart {

	private ProductList products;
	public ProductList getProducts() {
		return products;
	}
	public void setProducts(ProductList products) {
		this.products = products;
	}
	private Double totalPrice;
	
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
