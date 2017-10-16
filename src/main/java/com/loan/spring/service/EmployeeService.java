package com.loan.spring.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.loan.jpa.data.Employee;

@Component
public class EmployeeService {
	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void register(Employee emp) {
		// Save employee
		this.em.persist(emp);
	}
	
	@Transactional
	public void register1(Employee emp) {
		//emp.setUsername("Admin");
		//emp.setPassword("Admin123");
		//return (Employee) em.createQuery("SELECT username,password,role FROM EMPLOYEE where username="+username).getResultList();
	this.em.createQuery("SELECT username,password,role FROM EMPLOYEE where username="+emp.getUsername()).getSingleResult();
	}

}
