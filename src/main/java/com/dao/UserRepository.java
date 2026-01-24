package com.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.User;

public interface UserRepository extends JpaRepository<User, UUID>{

}
