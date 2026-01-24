package com.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.SubTask;

public interface SubTaskRepository extends JpaRepository<SubTask, UUID> {

}
