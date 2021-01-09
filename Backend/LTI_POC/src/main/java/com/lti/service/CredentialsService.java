package com.lti.service;

import com.lti.dto.CredentialDto;
import com.lti.pojo.Credential;

public interface CredentialsService {
	
	public String login(CredentialDto userInfo);
	public void register(Credential userInfo);
}
