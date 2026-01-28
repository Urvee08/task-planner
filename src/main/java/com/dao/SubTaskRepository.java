package com.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.SubTask;
import com.entity.Task;

@Repository
public interface SubTaskRepository extends JpaRepository<SubTask, UUID> {

	List<SubTask> findByTask(Task task);

}
