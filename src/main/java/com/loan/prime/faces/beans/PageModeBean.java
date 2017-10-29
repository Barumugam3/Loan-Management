package com.loan.prime.faces.beans;

public class PageModeBean {
	
	
	private int mode;
	private String navigatePage1;
	
	public String navigatePage1(String page, String mode){
		
		if(page.equalsIgnoreCase("employee")){
			page = "./employee.xhtml?page="+mode;
		}
		
		return page;
		
	}

	public String getNavigatePage1() {
		return navigatePage1;
	}

	public void setNavigatePage1(String navigatePage1) {
		this.navigatePage1 = navigatePage1;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}
	
	

}
