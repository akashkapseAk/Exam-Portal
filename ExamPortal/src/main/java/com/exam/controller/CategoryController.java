package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.category.Category;
import com.exam.service.CategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	@CrossOrigin("*")
	public ResponseEntity<?> addCategory(@RequestBody Category category)
	{
		Category addCategory = this.categoryService.addCategory(category);
		return ResponseEntity.ok(addCategory);
		
	}
	
	
	//get category
	@GetMapping("/{categoryId}")
	public Category geCategory(@PathVariable ("categoryId") int categoryId)
	{
		
		return this.categoryService.getCategory(categoryId);
		
	}
	//get all catory
	@GetMapping("/")
	public ResponseEntity<?> getCategories()
	{
		return ResponseEntity.ok(this.categoryService.getCategories());
		
	}
	//update 
	@PutMapping("/")
	public Category updateCat(@RequestBody Category category)
	{
		return this.categoryService.updateCategory(category);
		
	}
}
