package com.example.demo.controller;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.request.AssessmentRequest;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value="register-user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> registerUser(@RequestBody User user)  
	{    
		Integer userid = service.addUser(user);  
		
		JSONObject resp = new JSONObject();
		
		resp.put("userId", userid);
		
		return new ResponseEntity<String>(resp.toString(), HttpStatus.CREATED);
	} 
	
	@RequestMapping(value="self-assessment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> selfAssessment (@RequestBody AssessmentRequest ar){
		
		Integer risk = service.selfAssessment(ar.getSymptoms(), ar.getTravelHistory(), ar.getContactWithCovidPatient());
		JSONObject resp = new JSONObject();
		resp.put("riskPercentage", risk);
		
		return new ResponseEntity<String>(resp.toString(), HttpStatus.OK);
	}
}
