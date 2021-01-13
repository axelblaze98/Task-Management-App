package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.lti.dto.UpdateProjectDto;
import com.lti.exception.ServiceException;
import com.lti.pojo.Projects;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
	
	@PersistenceContext 
	private EntityManager emObj;
	
	Projects project = new Projects();
	
	@Transactional
	@Override
	public void addProject(Projects projectInfo) {
		// TODO Auto-generated method stub
		emObj.persist(projectInfo);
	}

	@Override
	public Projects getProjectById(int projectId) {
		// TODO Auto-generated method stub
		if(emObj.find(Projects.class, projectId)==null) {
			throw new ServiceException("Project Doesn't Exist");
		}
		return emObj.find(Projects.class, projectId);
	}
	
	@Transactional
	@Override
	public void updateProjectStatus(int projectId) {
		// TODO Auto-generated method stub
		project=getProjectById(projectId);
		
		project.setStatus("INACTIVE");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Projects> getAllProjects() {
		// TODO Auto-generated method stub
		return emObj.createNamedQuery("getAllProjects").getResultList();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub

		return (Long)emObj.createNamedQuery("isProjectEmpty").getSingleResult()==0 ? true : false;
	}

	@Override
	public int getProjectId() {
		// TODO Auto-generated method stub
		return (Integer)emObj.createNamedQuery("getProjectId").getSingleResult();
	}

	@Override
	@Transactional
	public void updateDetails(UpdateProjectDto projectInfo,Integer projectId) {
		// TODO Auto-generated method stub
		project=getProjectById(projectId);
		
		project.setApplicationName(projectInfo.getApplicationName());
		project.setClient(projectInfo.getClientName());
		project.setProjectName(projectInfo.getProjectName());
		
	}
}
