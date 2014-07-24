package com.mc.rad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mc.rad.model.Customer;
import com.mc.rad.model.CustomerVO;


public interface RegisterService {
	
	public void addCustomer(Customer customer);

	public CustomerVO getLWBDetailsCount();

	public List<Customer> getLWDetails();

}
