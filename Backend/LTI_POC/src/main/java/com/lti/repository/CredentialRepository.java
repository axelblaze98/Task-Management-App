package com.lti.repository;

import com.lti.pojo.Credential;

public interface CredentialRepository {

	void register(Credential userInfo);
	boolean getAdminUsername(String username);
	Credential getAdmin(String username);

}
