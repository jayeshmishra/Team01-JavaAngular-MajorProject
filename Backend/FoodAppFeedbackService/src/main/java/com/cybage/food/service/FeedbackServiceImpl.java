package com.cybage.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.food.dao.FeedbackRepository;
import com.cybage.food.entity.Feedback;

@Service
public class FeedbackServiceImpl{
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	public List<Feedback> getAllFeedback() {
		return feedbackRepository.findAll();
	}
	public void deleteById(int feedbackId) {
		
		feedbackRepository.deleteById(feedbackId);
	}
	public Feedback addFeedbackComment(Feedback feedback) {
		// TODO Auto-generated method stub
		return feedbackRepository.save(feedback) ;
	}

//	@Override
//	public List<Feedback> findFeedbackByUser(User user) {
//
//		return feedbackDao.findByUser(user);
//	}
//
//	@Override
//	public Feedback addComment(Feedback feedback) {
//	
//		return feedbackDao.save(feedback);
//	}
//
//	@Override
//	public void deleteFeedback(int feedbackId) {
//
//		feedbackDao.deleteById(feedbackId);
//
//	}
//
//	@Override
//	public List<Feedback> findAll() {
//		return feedbackDao.findAll();
//	}

}
