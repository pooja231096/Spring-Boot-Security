package com.verizon.productcatalog.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.productcatalog.model.Product;
import com.verizon.productcatalog.service.ProductCatalogService;

@RestController
@RequestMapping("/products")
public class ProductCatalogController {
	@Autowired
	private ProductCatalogService productcatlogsevice;

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/all")
	public List<Product> getAllProducts() {
		return productcatlogsevice.getAllProducts();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/add")
	public String addProduct(Product product) {
		productcatlogsevice.add(product);
		return "Product added";

	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/update")
	public String updateProduct(Product product) {
		productcatlogsevice.update(product);
		return "Product updated";

	}
}
