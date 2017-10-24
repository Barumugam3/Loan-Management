package com.loan.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
public class HibernateUtil {
	@PersistenceContext
	private static final EntityManagerFactory emFactory;
	static {
		   emFactory = Persistence.createEntityManagerFactory("com.loan");
	}
	public static CriteriaBuilder getCriteriaBuilder(){
		CriteriaBuilder builder = emFactory.getCriteriaBuilder();
		return  builder;
	}
	public static EntityManager getEntityManager(){
		return emFactory.createEntityManager();
	}
} 
