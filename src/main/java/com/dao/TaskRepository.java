package com.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Category;
import com.entity.Task;
import com.entity.User;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>{
	
	public List<Task> findByUser(User user);
	
	public List<Task> findByCategory(Category category);
}
