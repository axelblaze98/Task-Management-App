package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.pojo.Credential;

@Repository
public class CredentialRepositoryImpl implements CredentialRepository {
	
	@PersistenceContext
	EntityManager emObj;
	
	@Transactional
	@Override
	public void register(Credential userInfo) {
		// TODO Auto-generated method stub
		emObj.persist(userInfo);
	}

	@Override
	public boolean getAdminUsername(String username) {
		// TODO Auto-generated method stub
		if(getAdmin(username)!=null) {
			return true;
		}
		else return false;
	}
	
	@Override
	public Credential getAdmin(String username) {
		return emObj.find(Credential.class, username);
	}

}
