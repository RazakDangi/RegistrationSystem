package com.mc.rad.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Customers")
public class CustomerGroup {

	@Override
	public String toString() {
		return "CustomerGroup [customers=" + customers + "]";
	}

	private List<Customer> customers;

	@XmlElement
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	
}
