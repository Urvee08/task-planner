package com.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SubTaskRepository;
import com.entity.SubTask;
import com.entity.Task;
import com.enums.TaskStatus;

@Service
public class SubTaskService {
	@Autowired
	SubTaskRepository subtaskRepo;
	
	public SubTask addSubTask(SubTask subtask) {
		subtask.setStatus(TaskStatus.PENDING);
		return subtaskRepo.save(subtask);
	}
	
	public List<SubTask> getAllSubTasks(Task task){
		return subtaskRepo.findByTask(task);
	}
	
	
	public SubTask editSubTask(SubTask subtask) {
		return subtaskRepo.findById(subtask.getSubtask_id()).map(t->{
			t.setTitle(subtask.getTitle());
			t.setStatus(subtask.getStatus());
			return subtaskRepo.save(t);
		}) .orElseGet(()->{
			return subtaskRepo.save(subtask);
		});
	}
	
	public void deleteSubTask(UUID subtask_id) {
		subtaskRepo.deleteById(subtask_id);
	}
}
