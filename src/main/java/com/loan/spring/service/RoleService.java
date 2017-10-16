package com.loan.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
    @javax.annotation.PostConstruct
    public void init() {
    	roles = new ArrayList<Role>();
    	roles.add(new Role(0, "Admin", "Admin Role desc","ACTIVE"));
    	roles.add(new Role(0, "Employee", "Employee Role desc","ACTIVE"));
    	roles.add(new Role(0, "Customer", "Customer Role desc","ACTIVE"));
    	roles.add(new Role(0, "SuperAdmin", "SuperAdmin Role desc","ACTIVE"));;
    }
    
    public List<Role> getRoles() {
        return roles;
    } 
   
	
}