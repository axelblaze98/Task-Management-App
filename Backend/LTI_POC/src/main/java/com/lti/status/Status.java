package com.lti.status;

public class Status {
	
	private statusType status;
	private String message;
	
	public statusType getStatus() {
		return status;
	}

	public void setStatus(statusType status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public enum statusType{
		SUCCESS,FAILURE;
	} 
}
