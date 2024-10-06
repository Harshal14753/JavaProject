package com.guest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guest.entity.FeedbackData;
import com.guest.repository.HomeRepo;

@Service
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HomeRepo homeRepo;

	@Override
	public void saveData(FeedbackData data) {
		homeRepo.save(data);
	}

	@Override
	public List<FeedbackData> getData() {
		List<FeedbackData> data = homeRepo.findAll();
		return data;
	}

}
