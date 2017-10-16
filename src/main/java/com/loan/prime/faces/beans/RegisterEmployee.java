package com.loan.prime.faces.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.loan.jpa.data.Employee;
import com.loan.spring.service.EmployeeService;

@ManagedBean
@SessionScoped
public class RegisterEmployee {

	@ManagedProperty("#{employeeService}")
	private EmployeeService employeeService;

	private Employee employee = new Employee();
	public String logout;
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String register() {
		// Calling Business Service
		employeeService.register(employee);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("The Employee "+this.employee.getUsername()+" Is Registered Successfully"));
		return FacesContext.getCurrentInstance().getMessages().toString();
	}
	
	//logout event, invalidate session
		public String logout() {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			externalContext.invalidateSession();
			//HttpSession session = SessionUtils.getSession();
		//	session.invalidate();
			return "index";
		}
	

}
