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
	@Column (name="STATUS")
	private String status;
	@Column (name="TRANSACTION_ID")
	private int transaction_Id;	
	
	public Role(long roleId, String role, String description, String status) {
        this.roleId = roleId;
        this.role = role;
        this.description = description;
        this.status = status;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTransaction_Id() {
		return transaction_Id;
	}
	public void setTransaction_Id(int transaction_Id) {
		this.transaction_Id = transaction_Id;
	}
	
	

}
