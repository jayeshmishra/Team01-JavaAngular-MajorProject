package com.cybage.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.food.entity.Feedback;
import com.cybage.food.service.FeedbackServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/foodapp/feedbackService")
public class FeedbackController {

	@Autowired
	private FeedbackServiceImpl feedbackService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Feedback>> getAllFeedback() {
		List<Feedback> feedback = feedbackService.getAllFeedback();
		return new ResponseEntity<List<Feedback>>(feedback, HttpStatus.OK);

	}

	@DeleteMapping("/{feedbackId}")
	public ResponseEntity<String> deleteByFeedbackId(@PathVariable int feedbackId) {
		feedbackService.deleteById(feedbackId);
		return new ResponseEntity<String>("record deleted", HttpStatus.OK);

	}

	@PostMapping("/addFeedback")
	public ResponseEntity<String> addFeedback(@RequestBody Feedback feedback) {
		feedbackService.addFeedbackComment(feedback);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
}
