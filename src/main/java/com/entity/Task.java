package com.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.enums.Priority;
import com.enums.TaskStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="Task")
public class Task {
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	@Column(name="task_id")
	private UUID task_id;
	
	@Column(name="title")
	private String title;
	
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	
	@Enumerated(EnumType.STRING)
	private Priority priority;

	@Column(name="created_at")
	private LocalDate created_at;
	
	@Column(name="due_date")
	private LocalDate due_date;
	
	@ManyToOne @JoinColumn(name="category_id")
	private Category category;
	
	@ManyToOne @JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
	private List<SubTask> subtasks;

	public Task() {
		super();
	}

	public Task(UUID task_id, String title, TaskStatus status, Priority priority, LocalDate created_at,
			LocalDate due_date, Category category) {
		super();
		this.task_id = task_id;
		this.title = title;
		this.status = status;
		this.priority = priority;
		this.created_at = created_at;
		this.due_date = due_date;
		this.category = category;
	}

	public UUID getTask_id() {
		return task_id;
	}

	public void setTask_id(UUID task_id) {
		this.task_id = task_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public LocalDate getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}

	public LocalDate getDue_date() {
		return due_date;
	}

	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<SubTask> getSubtasks() {
		return subtasks;
	}

	public void setSubtasks(List<SubTask> subtasks) {
		this.subtasks = subtasks;
	}

	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", title=" + title + ", status=" + status + ", priority=" + priority
				+ ", created_at=" + created_at + ", due_date=" + due_date + ", category=" + category + ", subtasks="
				+ subtasks + "]";
	}
	
	
}
