package com.mc.rad.scheduler;

public enum RESTURLs {
	
	JSON("http://localhost:8080/RegistrationSystem/view/customers.json"),
	
	XML("http://localhost:8080/RegistrationSystem/view/customers.xml");
	
	private String url;
	
	
	private RESTURLs(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
