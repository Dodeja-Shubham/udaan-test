package com.example.demo.request;

import java.util.List;

public class AssessmentRequest {
	private Integer userId;
	private List<String> symptoms;
	private Boolean travelHistory;
	private Boolean contactWithCovidPatient;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<String> getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(List<String> symptoms) {
		this.symptoms = symptoms;
	}
	public Boolean getTravelHistory() {
		return travelHistory;
	}
	public void setTravelHistory(Boolean travelHistory) {
		this.travelHistory = travelHistory;
	}
	public Boolean getContactWithCovidPatient() {
		return contactWithCovidPatient;
	}
	public void setContactWithCovidPatient(Boolean contactWithCovidPatient) {
		this.contactWithCovidPatient = contactWithCovidPatient;
	}
	
	

}
