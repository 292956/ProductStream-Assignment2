package com.assignment2;

import java.util.Optional;

public class Product {

	private int productId;
	private String name;
	private double price;
	private boolean inStock;
	private double discountPercentage;
	private String description;

	public Product(int productId, String name, double price, boolean inStock, double discountPercentage,
			String description) {

		this.productId = productId;
		this.name = name;
		this.price = price;
		this.inStock = inStock;
		this.discountPercentage = discountPercentage;
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public boolean isInStock() {
		return inStock;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public Optional<String> getDescription() {
		return Optional.ofNullable(description);
	}

	public double getFinalPrice() {
		return price - (price * discountPercentage / 100);

	}

}
