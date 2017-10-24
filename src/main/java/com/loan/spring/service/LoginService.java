package com.loan.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.loan.jpa.data.Employee;
import com.loan.util.FeatchEntity;
import com.loan.util.HibernateUtil;

@SuppressWarnings("unused")
@Component
public class LoginService {
	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public void  register1(Employee emp) {
		String hql = "Select username, password, role from Employee e where e.username = '" + emp.getUsername() + "'";
		Query  query = em.createQuery(hql);
		List<Object[]> empList = query.getResultList();
		
		for (Object[] info : empList) {
			System.out.println("Username = " + (String)info[0]
				+ "Password = " +  (String)info[1] +" Role="+ (String)info[2]);
			emp.setUsername((String)info[0]);
			emp.setPassword((String)info[1]);
			emp.setRole((String)info[2]);

		}
	}

}

