package com.loan.prime.faces.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class TabView {

	private String pageView;

	public TabView(){		
	}
	public void pageView(){
		String strParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("navpage");
		System.out.println(strParam);
		this.pageView = strParam;
	}
	public String getPageView() {
		return pageView;
	}

	public void setPageView(String pageView) {
		this.pageView = pageView;
	}
	
	

}
