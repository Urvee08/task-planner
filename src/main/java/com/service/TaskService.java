package com.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TaskRepository;
import com.entity.Category;
import com.entity.Task;
import com.entity.User;
import com.enums.TaskStatus;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepo;
	
	public Task addTask(Task task) {
		task.setStatus(TaskStatus.PENDING);
		return taskRepo.save(task);
	}
	
	public List<Task> getAllUserTasks(User user){
		return taskRepo.findByUser(user);
	}
	
	public List<Task> getTaskByCategory(Category category){
		return taskRepo.findByCategory(category);
	}
	
	public Task editTask(Task task) {
		return taskRepo.findById(task.getTask_id()).map(t->{
			t.setTitle(task.getTitle());
			t.setDue_date(task.getDue_date());
			t.setPriority(task.getPriority());
			t.setStatus(task.getStatus());
			return taskRepo.save(t);
		}) .orElseGet(()->{
			return taskRepo.save(task);
		});
	}
	
	public void deleteTask(UUID task_id) {
		taskRepo.deleteById(task_id);
	}
	
	
}
