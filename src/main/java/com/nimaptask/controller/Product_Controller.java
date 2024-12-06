package com.nimaptask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nimaptask.entity.Category;
import com.nimaptask.entity.Product;
import com.nimaptask.repository.CategoryRepository;
import com.nimaptask.repository.ProductRepository;

@RestController
@RequestMapping("api/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/home")
	@ResponseBody
	public String home() {
		return "Hello";
	}

	@PostMapping
	public Product addProduct(@RequestBody Product product) {

		return productRepository.save(product);
	}

	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@DeleteMapping("/{id}")
	public Product deleteProduct(@PathVariable int id) {
		Product product = productRepository.findById(id).get();
		productRepository.delete(product);
		return product;
	}

	@GetMapping("/{id}")
	public Product findProductById(@PathVariable int id) {
		return productRepository.findById(id).get();
	}

	@GetMapping
	public Page<Product> findAllProducts(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size) {
		
		return productRepository.findAll(PageRequest.of(page, size));
	}

}