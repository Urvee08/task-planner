package com.entity;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.enums.TaskStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="SubTask")
public class SubTask {
	
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	@Column(name="subtask_id")
	private UUID subtask_id;
	
	@Column(name="title")
	private String title;
	
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	
	@ManyToOne @JoinColumn(name="task_id")
	private Task task;

	public SubTask() {
		super();
	}

	public SubTask(UUID subtask_id, String title, TaskStatus status, Task task) {
		super();
		this.subtask_id = subtask_id;
		this.title = title;
		this.status = status;
		this.task = task;
	}

	public UUID getSubtask_id() {
		return subtask_id;
	}

	public void setSubtask_id(UUID subtask_id) {
		this.subtask_id = subtask_id;
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

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "SubTask [subtask_id=" + subtask_id + ", title=" + title + ", status=" + status + ", task=" + task + "]";
	}
	
	
	
}
