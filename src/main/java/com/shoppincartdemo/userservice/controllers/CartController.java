package com.shoppincartdemo.userservice.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shoppincartdemo.userservice.models.Cart;
import com.shoppincartdemo.userservice.models.Product;
import com.shoppincartdemo.userservice.models.ProductList;

@RestController
public class CartController {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping("/get-cart-details")
	public Cart getCartDetals() {
		Product[] products = this.restTemplate.getForObject("http://localhost:9000/get-products", Product[].class );
		Cart cart = new Cart();
		cart.setProducts((ProductList) Arrays.asList(products));
		cart.setTotalPrice(1299.00);
		return cart;
	}
}
