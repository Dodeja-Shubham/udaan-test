package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.model.User;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Integer registerAdmin(Admin admin) {
		return adminRepository.save(admin).getAdminId();
	}
	
	public Boolean updateCovidResult(Integer userId, String status) {
		try {
		User user = userRepository.getById(userId);
		user.setStatus(status);
		
		return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
