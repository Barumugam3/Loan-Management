package com.loan.prime.faces.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
	
	public String register() {
		String newRole = role.getRole();
		List<Object> allRoles = roleService.getRoles();
		boolean previousCheck = false;
		for (int i = 0; i < allRoles.size(); i++) {
			String tempRole = allRoles.get(i) != null ? (String) allRoles
					.get(i) : "";
			if (tempRole.equalsIgnoreCase(newRole)) {
				previousCheck = true;
			}
		}

		if (!previousCheck) {
			role.setRolestatus("ACTIVE");
			roleService.register(role);
			// Add message
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage("The Admin : " + this.role.getRole()
							+ " role added Successfully"));

		}else{
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage("This role already registered : " + this.role.getRole()));

		}
		return "";
	}
	
	 public List<String> completeRoles(String query) {
		 List<Object> allRoles = roleService.getRoles();
		 List<String> filteredRoles = new ArrayList<String>();
	         
		 for (int i = 0; i < allRoles.size(); i++) {
			 
			 System.out.println("Role_::_"+i+":"+allRoles.get(i));
			 if(allRoles.get(i)!=null&&allRoles.get(i).toString().toLowerCase().startsWith(query)) {
				filteredRoles.add(allRoles.get(i) != null?(String)allRoles.get(i):"");
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
