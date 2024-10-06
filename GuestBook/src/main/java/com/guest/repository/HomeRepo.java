package com.guest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guest.entity.FeedbackData;

public interface HomeRepo extends JpaRepository<FeedbackData, Integer> {

}
