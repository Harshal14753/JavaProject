package com.guest.service;

import java.util.List;

import com.guest.entity.FeedbackData;

public interface HomeService {

	public void saveData(FeedbackData data);
	
	public List<FeedbackData> getData();
}
