package com.loan.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.loan.jpa.data.Role;

@Component
public class RoleService {
	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void register(Role role) {
		// Save employee
		this.em.persist(role);
	}
	private List<Role> roles;
    
    @SuppressWarnings("unchecked")
	public List<Object> getRoles() {    	

		String hql = "select role from Role";
		Query  query = em.createQuery(hql);
		List<Object> roles = query.getResultList();
	    return roles;
    } 
   
	
}