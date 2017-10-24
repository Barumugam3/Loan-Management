package com.loan.util;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.loan.jpa.data.Employee;
public class FeatchEntity {
	public Employee getUserDetails(String conditin, String value, String columns) {
		CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
		EntityManager em = HibernateUtil.getEntityManager();
		CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
		Root<Employee> studentRoot = criteriaQuery.from(Employee.class);
		criteriaQuery.select(studentRoot);
		criteriaQuery.where(builder.equal(studentRoot.get(conditin), value));
		Employee employee = em.createQuery(criteriaQuery).getSingleResult();
		return employee;
	}
} 
