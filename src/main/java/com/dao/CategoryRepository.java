package com.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Category;
import com.entity.Task;
import com.entity.User;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID>{

	List<Category> findByUser(User user);

}
