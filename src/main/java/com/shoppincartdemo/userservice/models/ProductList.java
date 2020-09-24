package com.shoppincartdemo.userservice.models;

import java.io.Serializable;
import java.util.List;

public class ProductList implements Serializable{

	private List<Product> productList;

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
