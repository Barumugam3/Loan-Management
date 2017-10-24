package com.loan.prime.faces.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.loan.spring.service.MenubarService;

@SuppressWarnings("unused")
@ManagedBean
@SessionScoped
public class MenubarBean {

	@ManagedProperty("#{menubarservice}")
	private MenubarService menubarservice;
	public String getmenubar;

	public MenubarService getMenubarservice() {
		return menubarservice;
	}

	public void setMenubarservice(MenubarService menubarservice) {
		this.menubarservice = menubarservice;
	}
	
	public List<String> getmenubar(){
		List<String> menuList = new ArrayList();
		menuList.add("ADMIN");
		menuList.add("EMPLOYEE");
		menuList.add("CUSTOMER");
		return menuList;
		
	}
	
}