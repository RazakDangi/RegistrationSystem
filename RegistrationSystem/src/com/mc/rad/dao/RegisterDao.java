package com.mc.rad.dao;

import java.util.List;

import com.mc.rad.model.Customer;
import com.mc.rad.model.CustomerVO;

public interface RegisterDao {
	
	public void saveCustomer(Customer customer);

	public CustomerVO getLWDetailsCount();

	public List<Customer> getLWDetails();


}
