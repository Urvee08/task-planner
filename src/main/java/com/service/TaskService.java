package com.service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TaskRepository;
import com.dao.UserRepository;
import com.entity.Task;
import com.enums.TaskStatus;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepo;
	@Autowired
	UserRepository userRepo;
	
	public Task addTask(Task task) {
		task.setStatus(TaskStatus.PENDING);
		return taskRepo.save(task);
	}
//	public ArrayList<Task> getAllUserTasks(UUID user_id){
//		return taskRepo.getById(user_id);
//	}
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
	
	public int deleteTask(UUID task_id) {
		taskRepo.deleteById(task_id);
		return 0;
	}
	
	
}
