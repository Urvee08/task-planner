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

import com.entity.SubTask;
import com.entity.Task;
import com.service.SubTaskService;

@RestController
@RequestMapping("/todo/tasks/subtasks")
//@CrossOrigin(origins = "http://localhost:3000")
public class SubTaskController {
	
	@Autowired
	SubTaskService subtaskServ;
	
	@GetMapping("/getAllSubTasks")
	public List<SubTask> getAllSubTasks(@RequestBody Task task){
		return subtaskServ.getAllSubTasks(task);
	}
	
	@PostMapping("/addSubTask")
	public SubTask addTask(@RequestBody SubTask subtask) {
		return subtaskServ.addSubTask(subtask);
	}
	
	@PutMapping("/editSubTask")
	public SubTask editTask(@RequestBody SubTask subtask) {
		return subtaskServ.editSubTask(subtask);
	}
	
	@DeleteMapping("/deleteSubTask/{subtask_id}")
	public void deleteTask(@PathVariable UUID subtask_id) {
		 subtaskServ.deleteSubTask(subtask_id);
	}
}
