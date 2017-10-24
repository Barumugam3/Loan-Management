package com.loan.prime.faces.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.loan.jpa.data.Employee;
import com.loan.spring.service.EmployeeService;

@ManagedBean
@SessionScoped
public class RegisterEmployee {

	@ManagedProperty("#{employeeService}")
	private EmployeeService employeeService;

	private Employee employee = new Employee();
	public String logout;
	public List<Employee> fetchall;
	private List<Employee> selectedemployees;
     
	private Employee selectedemployee;
    
	public void onRowSelect(SelectEvent event) {
	     FacesMessage msg = new FacesMessage("Employee Selected: "+((Employee) event.getObject()).getEmployeeId());
        FacesContext.getCurrentInstance().addMessage("messgae", msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Employee Unselected: "+((Employee) event.getObject()).getEmployeeId());
        FacesContext.getCurrentInstance().addMessage("messgae", msg);
    }
    
    public void onEdit(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Employee Edited"+((Employee) event.getObject()).getEmployeeId());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        
    }  
       
    public void onCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Employee Cancelled");   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        //employee.remove((Employee) event.getObject());
    } 
    
	public Employee getSelectedemployee() {
		return selectedemployee;
	}

	public void setSelectedemployee(Employee selectedemployee) {
		this.selectedemployee = selectedemployee;
	}

	public List<Employee> getSelectedemployees() {
		return selectedemployees;
	}

	public void setSelectedemployees(List<Employee> selectedemployees) {
		this.selectedemployees = selectedemployees;
	}

	public List<Employee> getFetchall() {
		return fetchall;
	}

	public void setFetchall(List<Employee> fetchall) {
		this.fetchall = fetchall;
	}

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
		return "";
	}
	
	public List<Employee> fetchall() {
		// Calling Business Service
		List<Employee> empList = employeeService.fetchAll(employee);
		// Add message
		//FacesContext.getCurrentInstance().addMessage(null, 
			//	new FacesMessage("The Employee "+this.employee.getUsername()+" Is Registered Successfully"));
		return empList;
	}
	
	public void selectedemployee(){
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("The Employee "+this.employee.getUsername()+" Is Registered Successfully"));
	
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
