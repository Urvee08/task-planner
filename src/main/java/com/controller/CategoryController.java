package com.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Category;
import com.entity.User;
import com.service.CategoryService;

@RestController
@RequestMapping("/todo/categories")
//@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

	@Autowired
	CategoryService catServ;
	
	@GetMapping("/getAllUserCategories")
	public List<Category> getAllUserTasks(@RequestBody User user){
		return catServ.getAllUserCategories(user);
	}
		
	@PostMapping("/addCategory")
	public Category addTask(@RequestBody Category category) {
		return catServ.addCategory(category);
	}
	
	@PutMapping("/editCategory")
	public Category editCategory(@RequestBody Category category) {
		return catServ.editCategory(category);
	}
	
	@DeleteMapping("/deleteCategory/{category_id}")
	public void deleteTask(@PathVariable UUID category_id) {
		 catServ.deleteCategory(category_id);
	}
}
