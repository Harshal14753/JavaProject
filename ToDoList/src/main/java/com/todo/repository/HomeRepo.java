package com.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.entity.Task;

public interface HomeRepo extends JpaRepository<Task, Integer> {

}
