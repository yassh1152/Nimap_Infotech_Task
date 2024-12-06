package com.nimaptask.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/home")
	@ResponseBody
	public String home() {
		return "Hello";
	}
	
	@GetMapping
	public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
       
		return categoryRepository.findAll(PageRequest.of(page, size));
    }
	

	@PostMapping
	public Category addCategory(@RequestBody Category category) {
		category.setProducts(new ArrayList<Product>());
		return categoryRepository.save(category);
	}

	@PutMapping
	public Category updateCategory(@RequestBody Category category) {
		return categoryRepository.save(category);
	}

	@DeleteMapping("/{id}")
	public Category deleteCategory(@PathVariable int id) {
		Category category = categoryRepository.findById(id).get();
		categoryRepository.delete(category);
		return category;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> findCategoryById(@PathVariable int id) {
	
		Category category=categoryRepository.findById(id).get();
		 
		return new ResponseEntity<Category>(category,HttpStatus.OK);
	}
	

}
