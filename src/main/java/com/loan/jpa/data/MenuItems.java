package com.loan.jpa.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MenuItems {

	@Id
	@Column(name="MENUITEMSID")
	private long menuitemsid ;
	@Column(name="LABEL")
	private String label;
	@Column(name="URL")
	private String url;
	@Column(name="TOOLTIP")
	private String tooltip;
	@Column(name="PARENT_MENU")
	private String parent_menu; 
	@Column(name="TRANSACTION_ID")
	private String transation_id;
	
	public long getMenuitemsid() {
		return menuitemsid;
	}
	public void setMenuitemsid(long menuitemsid) {
		this.menuitemsid = menuitemsid;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTooltip() {
		return tooltip;
	}
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}
	public String getParent_menu() {
		return parent_menu;
	}
	public void setParent_menu(String parent_menu) {
		this.parent_menu = parent_menu;
	}
	public String getTransation_id() {
		return transation_id;
	}
	public void setTransation_id(String transation_id) {
		this.transation_id = transation_id;
	}	
} 
