package com.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Category;
import com.entity.Task;
import com.entity.User;
import com.service.TaskService;

@RestController
@RequestMapping("/todo/tasks")
//@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

	@Autowired
	TaskService taskServ;
	
	@GetMapping("/getAllUserTasks")
	public List<Task> getAllUserTasks(@RequestBody User user){
		return taskServ.getAllUserTasks(user);
	}
	
	@GetMapping("/getTaskByCategory/{category}")
	public List<Task> getTaskByCategory(@RequestBody Category category){
		return taskServ.getTaskByCategory(category);
	}
	
	
	@PostMapping("/addTask")
	public Task addTask(@RequestBody Task task) {
		return taskServ.addTask(task);
	}
	
	@PutMapping("/editTask")
	public Task editTask(@RequestBody Task task) {
		return taskServ.editTask(task);
	}
	
	@DeleteMapping("/deleteTask/{task_id}")
	public void deleteTask(@PathVariable UUID task_id) {
		 taskServ.deleteTask(task_id);
	}
}
