package com.assignment2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CartProcessor {

	public static void main(String[] args) {
		List<Product> products = Arrays.asList(new Product(101, "laptop", 50000, true, 10, "Gaming Laptop"),
				new Product(102, "Mouse", 800, true, 5, null),
				new Product(103, "Keyboard", 1500, false, 15, "Mechanical Keyboard"),
				new Product(104, "Monitor", 12000, true, 20, null));

		// 1 . Remove out of stock products

		List<Product> availableProducts = products.stream().filter(Product::isInStock).collect(Collectors.toList());

		System.out.println("Available products");
		availableProducts.forEach(p -> System.out.println(p.getName()));

		// 2. Apply discount on product
		System.out.println("\nproducts with Discounted Price");
		availableProducts.forEach(p -> System.out.println(p.getName() + " " + p.getFinalPrice()));

		// 3. Calculate total cart amount
		System.out.println("\nCalculate total cart amount");
		double totalAmount = availableProducts.stream().mapToDouble(Product::getFinalPrice).sum();
		System.out.println("Total Amount" + totalAmount);

		// 4.Most Expensive Product
		System.out.println("\nMost Expensive product");
		Product expensive = availableProducts.stream().max(Comparator.comparing(Product::getPrice)).orElse(null);
		System.out.println("Most Expensive" + expensive.getName());
		
		//Sort by price
		availableProducts.stream().sorted(Comparator.comparing(Product::getPrice))
		.forEach(p -> System.out.println(p.getName()+" "+p.getPrice()));
		
		//optional description
		
		availableProducts.forEach(p -> System.out.println(p.getName()+" "+p.getDescription().orElse("No Description available")));
		

	}

}
