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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="Category")
public class Category {
	
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	@Column(name="category_id")
	private UUID category_id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne @JoinColumn(name="user_id") //foreign key
	private User user;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Task> tasks;

	public Category() {
		super();
	}

	public Category(UUID category_id, String name, User user) {
		super();
		this.category_id = category_id;
		this.name = name;
		this.user = user;
	}

	public UUID getCategory_id() {
		return category_id;
	}

	public void setCategory_id(UUID category_id) {
		this.category_id = category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", name=" + name + ", user=" + user + ", tasks=" + tasks + "]";
	}
	
	
}
