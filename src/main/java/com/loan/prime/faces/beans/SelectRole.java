package com.loan.prime.faces.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.loan.jpa.data.Role;
import com.loan.spring.service.RoleService;

@ManagedBean
@SessionScoped
public class SelectRole {
	
	@ManagedProperty("#{roleService}")
	private RoleService roleService;
	
	private Role role = new Role();
	private String roleName;
	
	private List<Role> completeRoles;
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
		
	public List<Role> getCompleteRoles() {
		return completeRoles;
	}

	public void setCompleteRoles(List<Role> completeRoles) {
		this.completeRoles = completeRoles;
	}
	 public List<String> completeRoles(String query) {
		 List<Role> allRoles = roleService.getRoles();
		 List<String> filteredRoles = new ArrayList<String>();
	         
		 for (int i = 0; i < allRoles.size(); i++) {
			 Role role = allRoles.get(i);
			 if(role.getRole().toLowerCase().startsWith(query)) {
				 filteredRoles.add(role.getRole());
			 }
		 }
	         
	        return filteredRoles;
	    }
	 
		public List<String> completeText(String query) {
			List<String> results = new ArrayList<String>();
			for(int i = 0; i < 10; i++) {
				results.add(query + i);
		     	}
		         
		      return results;
		    }
	

}
