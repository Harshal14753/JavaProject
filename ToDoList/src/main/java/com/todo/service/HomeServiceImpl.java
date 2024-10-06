package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entity.Task;
import com.todo.repository.HomeRepo;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HomeRepo homeRepo;

	@Override
	public boolean addTask(String description) {
		Task newTask = new Task();
		newTask.setDesc(description);
		Task save = homeRepo.save(newTask);
		
		if (save != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Task> getAllTask() {
		List<Task> allTask = homeRepo.findAll();
		return allTask;
	}

	@Override
	public void deleteTask(int id) {
		homeRepo.deleteById(id);
	}

}
