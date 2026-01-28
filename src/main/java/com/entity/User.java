package com.entity;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="users", 
	uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
    }
)
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	@Column(name="user_id")
	private UUID user_id;
	
	@Column(name="username", nullable=false, unique=true)
	private String username;
	
	@Column(name="email",nullable=false, unique=true)
	private String email;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Task> tasks;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Category> categories;

	public User() {
		super();
	}

	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public UUID getUser_id() {
		return user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", email=" + email +
				", password=" + password   +  "]";
	}

	
	
	
}
