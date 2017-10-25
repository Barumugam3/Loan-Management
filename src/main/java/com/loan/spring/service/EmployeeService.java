package com.loan.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
	
	@Transactional
	public List<Employee> fetchAll(Employee emp){
		 CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		   CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		   Root<Employee> from = criteriaQuery.from(Employee.class);
		   
		   CriteriaQuery<Object> select = criteriaQuery.select(from);
		   TypedQuery<Object> typedQuery = em.createQuery(select);
		   List<Object> resultlist = typedQuery.getResultList();
		   List<Employee> empList = new ArrayList<Employee>();
		   for(Object o:resultlist) {
			      Employee e = (Employee)o;
			      empList.add(e);
			      System.out.println("EID : " + e.getFirstName() + " Ename : " + e.getLastName());
			   }
		return empList;
	}
	
	@Transactional
	public Employee fetchById(long empid){
		 CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		   CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
		   Root<Employee> from = criteriaQuery.from(Employee.class);
		   criteriaQuery.where(from.get("employeeid").in(empid));
		   CriteriaQuery<Object> select = criteriaQuery.select(from);
		   TypedQuery<Object> typedQuery = em.createQuery(select);
		   Object resultlist = typedQuery.getSingleResult();
		   Employee e = (Employee) resultlist;
		   return e;
		   


	}

}
