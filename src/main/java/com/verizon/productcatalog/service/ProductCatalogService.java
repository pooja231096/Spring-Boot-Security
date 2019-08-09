package com.verizon.productcatalog.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.verizon.productcatalog.model.Product;

@Service
public class ProductCatalogService {
	private List<Product> products = new ArrayList<Product>();

	@PostConstruct
	public void setup() {
		products.add(new Product(1, "Smart phone", 9999.99, 10));
		products.add(new Product(2, "Power Bank", 999.99, 5));
		products.add(new Product(3, "Headset", 1500.00, 1));
	}

	public List<Product> getAllProducts() {
		return products;
	}

	public void add(Product product) {
		products.add(product);
	}

	public void update(final Product product) {
		Product existingprod = products.stream().filter(prod -> prod.getId() == product.getId()).findAny().orElse(null);
		if (existingprod != null) {
			existingprod.setName(product.getName());
			existingprod.setPrice(product.getPrice());
			existingprod.setQuantity(product.getQuantity());
		} else
			throw new RuntimeException("id doesnot exist");

	}
}