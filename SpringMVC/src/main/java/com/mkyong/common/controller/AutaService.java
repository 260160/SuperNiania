package com.mkyong.common.controller;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AutaService {
	
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void addAuto(int id , String marka) {
		Auta auta = new Auta();
		auta.setId(id);
		auta.setMarka(marka);
		entityManager.persist(auta);
	}
	
	public List<Auta> findAuto(String marka) {
		Query query = entityManager.createQuery("Select a from "+ Auta.class.getName() + " a");
				//+ " a where a.marka=?1")
		//.setParameter(1, marka);

	List<Auta> auta = query.getResultList();
	System.out.println("^^^^^^^^^^");

	for(Auta a :auta) {
		System.out.println("Wypisuje "+a.getId()); 	
	  }
	return auta;
	}
}