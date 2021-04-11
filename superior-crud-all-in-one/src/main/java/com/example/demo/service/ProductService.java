package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {
	//create product
	Product createProduct(Product product);
	
	//update product
	Product updateProduct (Product product);
	
	//list of all product
	List<Product> getAllProduct();
	
	//get a product by Id
	Product getProductById(long productId);

	//delete a product
	void deleteProduct(long id);

}
