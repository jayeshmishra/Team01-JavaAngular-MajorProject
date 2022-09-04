package com.cybage.food.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.food.entity.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{

}
