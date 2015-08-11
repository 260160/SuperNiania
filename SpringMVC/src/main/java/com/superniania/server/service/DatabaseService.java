package com.superniania.server.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.superniania.server.model.Location;

@Service
@Transactional
public class DatabaseService {
	
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public boolean addAuto(Location location) {
		try {
		     entityManager.persist(location);
		     return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}