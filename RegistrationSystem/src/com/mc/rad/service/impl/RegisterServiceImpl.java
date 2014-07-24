package com.mc.rad.service.impl;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.rad.dao.RegisterDao;
import com.mc.rad.model.Customer;
import com.mc.rad.model.CustomerVO;
import com.mc.rad.service.RegisterService;
import com.mc.rad.util.DateUtils;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	RegisterDao registerDao;
	
	@Override
	public void addCustomer(Customer customer) {
		registerDao.saveCustomer(customer);
		
	}

	@Override
	public CustomerVO getLWBDetailsCount() {
	
		return registerDao.getLWDetailsCount();
	}

	@Override
	public List<Customer> getLWDetails() {
		
		return registerDao.getLWDetails();
	}

}
