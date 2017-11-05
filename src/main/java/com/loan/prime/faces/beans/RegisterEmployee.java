package com.loan.prime.faces.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.loan.jpa.data.Address;
import com.loan.jpa.data.Employee;
import com.loan.spring.service.EmployeeService;
import com.loan.util.PageMode;

@ManagedBean
@SessionScoped
public class RegisterEmployee {

	@ManagedProperty("#{employeeService}")
	private EmployeeService employeeService;

	private Employee employee;
	private Address address;
	public String logout;
	private int mode;
	public List<Employee> fetchall;
	private List<Employee> selectedemployees;     
	private Employee selectedemployee;
 
	PageModeBean pageMode = new PageModeBean();
	private String updateemployee;
	
	public String getUpdateemployee() {
		return updateemployee;
	}


	public void setUpdateemployee(String updateemployee) {
		this.updateemployee = updateemployee;
	}


	@PostConstruct
	public void init() {
		employee = new Employee();
		 address = new Address();
	}
	
    
	public String navigatePage1(String page, String mode){	
		return pageMode.navigatePage1(page,mode);
		
	}
		
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	
	public void onRowSelect(SelectEvent event) {
		long empid = ((Employee) event.getObject()).getEmployeeId();
		employee = ((Employee) event.getObject());
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Selected employee "+this.employee.getFirstName()+"  and Id:"+empid));
		setMode(1);
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

	public String selectedemployee(Employee e) { 
		long empid = e.getEmployeeId();
		selectedemployee = e;
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Selected employee "+this.selectedemployee.getFirstName()+"  and Id:"+empid));
		return navigatePage1("employee","1");
	}
 
	
	public String register() {
		// Calling Business Service
			employee.setAddress(address);
			employeeService.register(employee);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("The Employee "+this.employee.getUsername()+" Is Registered Successfully"));
		return navigatePage1("employee","1");
	}
	
	public String edit() {
		// Calling Business Service
			employee = selectedemployee;
			pageMode.setMode(PageMode.Edit);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("The Employee "+this.employee.getUsername()+" Is Edited Successfully"));
		return navigatePage1("employee","3");
	}
	
	public String updateemployee() {
		// Calling Business Service
			employee.setAddress(address);
			employeeService.update(employee);
			pageMode.setMode(PageMode.Browse);
		// Add message
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("The Employee "+this.employee.getUsername()+" Is Updated Successfully"));
		return navigatePage1("employee","1");
	}
	
	
	public List<Employee> fetchall() {
		// Calling Business Service
		List<Employee> empList = employeeService.fetchAll(employee);
		pageMode.setMode(PageMode.Search);
		// Add message
		//FacesContext.getCurrentInstance().addMessage(null, 
			//	new FacesMessage("The Employee "+this.employee.getUsername()+" Is Registered Successfully"));
		return empList;
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
