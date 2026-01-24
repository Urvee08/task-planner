package com.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Task;
import com.service.TaskService;

@RestController
@RequestMapping("/todo/tasks")
//@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

	@Autowired
	TaskService taskServ;
	
	@PostMapping("/addTask")
	public Task addTask(@RequestBody Task task) {
		return taskServ.addTask(task);
	}
	
	@PutMapping("/editTask")
	public Task editTask(@RequestBody Task task) {
		return taskServ.editTask(task);
	}
	
	@DeleteMapping("/deleteTask/{task_id}")
	public int deleteTask(@PathVariable UUID task_id) {
		return taskServ.deleteTask(task_id);
	}
}
