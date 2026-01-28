package com.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
	public User findByUsername(String username);
}
