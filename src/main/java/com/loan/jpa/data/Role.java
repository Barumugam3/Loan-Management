package com.loan.jpa.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
	
	 public Role() {}	 
	
	@Id
	@Column (name="ROLEID")
	private long roleId;
	@Column (name="ROLE")
	private String role;
	@Column (name="DESCRIPTION")
	private String description;
	@Column (name="ROLESTATUS")
	private String rolestatus;
	@Column (name="TRANSACTION_ID")
	private int transaction_Id;	
	
	public Role(String role) {
        this.role = role;
    }
	
	public Role(long roleId, String role, String description, String rolestatus) {
        this.roleId = roleId;
        this.role = role;
        this.description = description;
        this.rolestatus = rolestatus;
    }
	
	
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRolestatus() {
		return rolestatus;
	}
	public void setRolestatus(String rolestatus) {
		this.rolestatus = rolestatus;
	}
	public int getTransaction_Id() {
		return transaction_Id;
	}
	public void setTransaction_Id(int transaction_Id) {
		this.transaction_Id = transaction_Id;
	}
	
	

}
