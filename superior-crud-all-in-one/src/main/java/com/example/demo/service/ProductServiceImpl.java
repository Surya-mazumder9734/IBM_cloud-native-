package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	//create product
	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	//update product
	@Override
	public Product updateProduct(Product product) {
		Optional<Product> productDb=this.productRepository.findById(product.getId());
		
		if(productDb.isPresent()) {
			Product productUpdate=productDb.get();
			productUpdate.setId(product.getId());
			productUpdate.setName(product.getName());
			productUpdate.setDescription(product.getDescription());
			productRepository.save(productUpdate);
			return productUpdate;

		}else {
			throw new ResourceNotFoundException("Record not found with id: "+product.getId());
		}
	}

	@Override
	public List<Product> getAllProduct() {
		return this.productRepository.findAll();
	}

	@Override
	public Product getProductById(long productId) {
		Optional<Product> productDb=this.productRepository.findById(productId);
		if(productDb.isPresent()) {
			return productDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id: "+productId);

		}
	}

	@Override
	public void deleteProduct(long id) {
		Optional<Product> productDb=this.productRepository.findById(id);
		if(productDb.isPresent()) {
			this.productRepository.delete(productDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id: "+id);

		}		
	}

}
