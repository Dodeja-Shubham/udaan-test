package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public Integer addUser (User user) {
		return userRepository.save(user).getUserId();
	}
	
	public Integer selfAssessment(List<String> symptoms, Boolean travelHistory
			, Boolean contactWithCovidPatient) {
		
		int count = symptoms.size();
		
		if(count == 1 && (travelHistory || contactWithCovidPatient)) return 50;
		if(count == 2 && (travelHistory || contactWithCovidPatient)) return 75;
		if(count > 2 && (travelHistory || contactWithCovidPatient)) return 95;
		return 5;
		
	}
}
