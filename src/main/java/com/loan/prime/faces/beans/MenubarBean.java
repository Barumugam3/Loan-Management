package com.loan.prime.faces.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.loan.jpa.data.Menu;
import com.loan.jpa.data.MenuItems;
import com.loan.spring.service.MenubarService;

@SuppressWarnings("unused")
@ManagedBean
@SessionScoped
public class MenubarBean {

	@ManagedProperty("#{menubarservice}")
	private MenubarService menubarservice;
	public String getmenubar;
	private Menu menu = new Menu();
	private MenuItems menuitems = new MenuItems();
	private String registermenu;
	private String registermenuitems;
	
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public MenuItems getMenuitems() {
		return menuitems;
	}

	public void setMenuitems(MenuItems menuitems) {
		this.menuitems = menuitems;
	}

	public String getRegistermenu() {
		return registermenu;
	}

	public void setRegistermenu(String registermenu) {
		this.registermenu = registermenu;
	}

	public String getRegistermenuitems() {
		return registermenuitems;
	}

	public void setRegistermenuitems(String registermenuitems) {
		this.registermenuitems = registermenuitems;
	}

	
	
	public MenubarService getMenubarservice() {
		return menubarservice;
	}

	public void setMenubarservice(MenubarService menubarservice) {
		this.menubarservice = menubarservice;
	}
	
	public String registermenuitems() {
		// Calling Business Service
		menubarservice.registermenuitems(menuitems);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("The "+this.menuitems.getLabel()+" is created successfully"));
		return "";
	}
	
	public String registermenu() {
		// Calling Business Service
		menubarservice.registermenu(menu);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("The "+this.menu.getMenuname()+" is created successfully"));
		return "";
	}
	
	public List<String> getmenubar(){
		List<String> menuList = new ArrayList();
		menuList.add("ADMIN");
		menuList.add("EMPLOYEE");
		menuList.add("CUSTOMER");
		return menuList;
		
	}
	
}