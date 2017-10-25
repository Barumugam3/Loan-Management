package com.loan.jpa.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {

	@Id
	@Column(name="MENUID")
	private long menuid;
	@Column(name="MENUNAME")
	private String menuname;
	
	public long getMenuid() {
		return menuid;
	}
	public void setMenuid(long menuid) {
		this.menuid = menuid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
} 
