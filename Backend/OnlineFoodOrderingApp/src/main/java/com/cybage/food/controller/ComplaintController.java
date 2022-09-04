package com.cybage.food.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.food.entity.Complaint;
import com.cybage.food.entity.UserOrder;
import com.cybage.food.service.ComplaintService;
import com.cybage.food.service.UserOrderService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/foodapp/complaint")
public class ComplaintController {

	@Autowired
	ComplaintService complaintService;

	@Autowired
	UserOrderService userOrderService;

	@GetMapping("/getAllComplaintsOfUser/{userId}")
	public ResponseEntity<?> getAllUserComplaints(@PathVariable int userId) {
		List<Complaint> complaints = complaintService.getAllComplaints();
		List<Complaint> userComplaint = new ArrayList<>();
		for (Complaint c : complaints) {
			if (c.getUserOrder().getUser().getUserId() == userId)
				userComplaint.add(c);
		}
		return new ResponseEntity<>(userComplaint, HttpStatus.OK);
	}

	@PostMapping("/addComplaint/{orderId}")
	public ResponseEntity<?> addComplaint(@RequestBody String complaintMessage, @PathVariable int orderId) {
		UserOrder userOrder = userOrderService.findUserOrderByOrderId(orderId);
		String[] messageArray = complaintMessage.split("[+ =]");
		String complaint = "";
		for (String string : messageArray) {
			complaint = complaint + " " + string;
		}
		Complaint newComplaint = new Complaint();
		newComplaint.setUserOrder(userOrder);
		newComplaint.setComplaintMessage(complaint);
		newComplaint.setComplaintStatus("pending");
		newComplaint.setComplaintDate(LocalDateTime.now());
		complaintService.save(newComplaint);
		return new ResponseEntity<>("Added new Complaint", HttpStatus.OK);
	}

	@GetMapping("/getAllComplaintOfRestaurant/{restaurantId}")
	public ResponseEntity<?> getAllRestaurantComplaint(@PathVariable int restaurantId) {
		List<Complaint> complaints = complaintService.getAllComplaints();
		List<Complaint> restaurantComplaint = new ArrayList<>();
		for (Complaint c : complaints) {
			if (c.getUserOrder().getRestaurant().getRestaurantId() == restaurantId)
				restaurantComplaint.add(c);
		}
		return new ResponseEntity<>(restaurantComplaint, HttpStatus.OK);
	}

	@PutMapping("/changeComplaintStatus/{complaintId}")
	public ResponseEntity<?> changeComplaintStatus(@PathVariable int complaintId) {
		Complaint complaint = complaintService.findComplaintById(complaintId);
		complaint.setComplaintStatus("Solved");
		complaintService.save(complaint);
		return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
	}

	@PostMapping("/send-reminder")
	public ResponseEntity<?> sendReminder(@RequestBody Complaint complaint) {
		if (complaintService.sendReminder(complaint)) {
			System.out.println("inside controller");
			// emailService.sendOTP(complaint.getUserOrder().getRestaurant().getRestaurantEmail());
		}
		return new ResponseEntity<>(complaintService.sendReminder(complaint), HttpStatus.OK);
	}
}
