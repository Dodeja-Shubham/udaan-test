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

import com.example.demo.model.Admin;
import com.example.demo.request.UpdateCovidResultRequest;
import com.example.demo.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService service;

	@RequestMapping(value = "register-admin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
		Integer adminId = service.registerAdmin(admin);

		JSONObject resp = new JSONObject();

		resp.put("adminId", adminId);

		return new ResponseEntity<String>(resp.toString(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "update-covid-result", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCovidResult(@RequestBody UpdateCovidResultRequest request) {
		
		Boolean updated = service.updateCovidResult(Integer.parseInt(request.getUserId()), request.getResult());

		JSONObject resp = new JSONObject();

		resp.put("updated", updated);
		
		return new ResponseEntity<String>(resp.toString(), HttpStatus.OK);
	}
}
