package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CredentialDto;
import com.lti.exception.ServiceException;
import com.lti.pojo.Credential;
import com.lti.service.CredentialsService;
import com.lti.status.LoginStatus;
import com.lti.status.Status;
import com.lti.status.Status.statusType;

@RestController
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.POST})
public class CredentialController {
	
	@Autowired
	private CredentialsService credServiceObj;
	
	private Status status = new Status();
	
	
	@PostMapping(path="register")
	public Status register(@RequestBody Credential userInfo) {
		try{
			credServiceObj.register(userInfo);
			status.setStatus(statusType.SUCCESS);
			status.setMessage("Admin Registration Successful");
			return status;
		}
		catch(ServiceException err) {
			status.setStatus(statusType.FAILURE);
			status.setMessage(err.getMessage());
			return status;
		}
	}
	
	@PostMapping(path="login")
	public LoginStatus login(@RequestBody CredentialDto userInfo) {
		LoginStatus status = new LoginStatus();
		try {
			status.setName(credServiceObj.login(userInfo));
			status.setStatus(statusType.SUCCESS);
			status.setMessage("Login Successful");
			return status;
		}
		catch (ServiceException e) {
			status.setStatus(statusType.FAILURE);
			status.setMessage(e.getMessage());
			return status;
		}
	}
}