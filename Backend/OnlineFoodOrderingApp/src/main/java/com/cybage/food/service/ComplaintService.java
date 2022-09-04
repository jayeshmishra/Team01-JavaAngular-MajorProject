package com.cybage.food.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.food.dao.ComplaintRepository;
import com.cybage.food.entity.Complaint;

@Service
public class ComplaintService {
	@Autowired
	ComplaintRepository complaintRepository;

	public List<Complaint> getAllComplaints() {
		return complaintRepository.findAll();
	}

	public Complaint save(Complaint newComplaint) {
		return complaintRepository.save(newComplaint);
	}

	public Complaint findComplaintById(int complaintId) {
		return complaintRepository.findById(complaintId).orElse(null);
	}

	public boolean sendReminder(Complaint complaint) {
		boolean flag = false;
		LocalTime sendReminderLimit = complaint.getComplaintDate().toLocalTime().plusHours(2);
		System.out.println(LocalTime.now().compareTo(sendReminderLimit));
		if (complaint.getComplaintDate().toLocalDate().compareTo(LocalDate.now()) == 0) {
			if (LocalTime.now().compareTo(sendReminderLimit) <= 0) {
				flag = true;
			}
		}
		return flag;
	}
}
