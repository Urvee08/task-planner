package com.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CategoryRepository;
import com.entity.Category;
import com.entity.User;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository catRepo;
	
	public Category addCategory(Category category) {
		return catRepo.save(category);
	}
	
	public List<Category> getAllUserCategories(User user){
		return catRepo.findByUser(user);
	}
	
	
	public Category editCategory(Category category) {
		return catRepo.findById(category.getCategory_id()).map(c->{
			c.setName(category.getName());
			return catRepo.save(c);
		}) .orElseGet(()->{
			return catRepo.save(category);
		});
	}
	
	public void deleteCategory(UUID category_id) {
		catRepo.deleteById(category_id);
	}
}
