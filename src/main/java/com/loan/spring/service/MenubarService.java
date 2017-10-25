package com.loan.spring.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.loan.jpa.data.Menu;
import com.loan.jpa.data.MenuItems;

@Component
public class MenubarService {
	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void registermenuitems(MenuItems menuitems) {
		// Save menuitems
		this.em.persist(menuitems);
	}
	
	
	@Transactional
	public void registermenu(Menu menu) {
		// Save menu
		this.em.persist(menu);
	}

}
