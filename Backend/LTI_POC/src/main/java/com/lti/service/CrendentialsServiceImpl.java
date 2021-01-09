package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.CredentialDto;
import com.lti.exception.ServiceException;
import com.lti.pojo.Credential;
import com.lti.repository.CredentialRepository;
@Service
public class CrendentialsServiceImpl implements CredentialsService{
	
	@Autowired
	CredentialRepository credRepoObj;
	
	Credential admin = new Credential();
	
	@Override
	public String login(CredentialDto userInfo) {
		// TODO Auto-generated method stub
		if(!credRepoObj.getAdminUsername(userInfo.getUsername())) {
			throw new ServiceException("Username Does't Exist");
		}
		
		admin = credRepoObj.getAdmin(userInfo.getUsername());
		
		if(!admin.getPassword().equals(userInfo.getPassword())) {
			throw new ServiceException("Incorrect Password");
		}
		else return admin.getFullName();
	}

	@Override
	public void register(Credential userInfo) {
		// TODO Auto-generated method stub
		if(credRepoObj.getAdminUsername(userInfo.getUsername())) {
			throw new ServiceException("Username Aready Exists");
		}
		
		credRepoObj.register(userInfo);
	}

}
