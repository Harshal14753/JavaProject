package com.todo.service;

import java.util.List;

import com.todo.entity.Task;

public interface HomeService {
	
	public boolean addTask(String description);
	
	public List<Task> getAllTask();

	public void deleteTask(int id);
	
}
