package com.loan.jpa.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Employee {
	@Id
	@Column(name="EMPLOYEEID")
	private long employeeId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="BIRTHDATE")
	@Temporal(TemporalType.DATE)
	private Date birthDATE;
	@Column(name="EMP_HIRE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date employeeHireDate;
	@Column(name="USERNAME")
	private String username;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="ROLE")
	private String role;
	
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getBirthDATE() {
		return birthDATE;
		
	}

	public void setBirthDATE(Date birthDATE) {
		this.birthDATE = birthDATE;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	
	public Date getEmployeeHireDate() {
		return employeeHireDate;
	}

	public void setEmployeeHireDate(Date employeeHireDate) {
		this.employeeHireDate = employeeHireDate;
	}
}
