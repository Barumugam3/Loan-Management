package com.loan.prime.faces.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.loan.jpa.data.Employee;
import com.loan.spring.service.LoginService;
import com.loan.util.SessionUtils;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4913397860493275891L;
	@ManagedProperty("#{loginService}")
	private LoginService loginService;
	private Employee login = new Employee();
	public String register1;
	public String signout;
	public String logout;
	private String user;
	private String pass;
	private String role;
	
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public Employee getLogin() {
		return login;
	}

	public void setLogin(Employee login) {
		this.login = login;
	}
	//validate login
	public String register1() {
		String username = user;
		String password = pass;
		login.setUsername(user);
		login.setPassword(pass);
		 loginService.register1(login);
		
		System.out.println("Log Details:"+username+"::"+password+"::"+role);
		boolean valid = validate(this.login.getUsername(), this.login.getPassword(), username, password);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", login.getUsername().trim());
			session.setAttribute("role", login.getUsername().trim());
			return "home";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "index";
		}
	}
	
	public boolean validate(String username, String password, String user, String pass) {
		
	if (username.equals(user.trim()) && password.equals(pass.trim())) {
		return true;
	}else {
		return false;
	}
}
	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
}
