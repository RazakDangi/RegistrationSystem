package com.mc.rad.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mc.rad.model.Customer;
import com.mc.rad.model.CustomerGroup;
import com.mc.rad.service.RegisterService;

@Controller
@RequestMapping("/view")
public class ViewController {

	@Resource(name = "registerService")
	private RegisterService registerService;
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET,produces={"application/json"})
	@ResponseStatus(value=HttpStatus.ACCEPTED)  
	public @ResponseBody
	List<Customer> getJsonView() {
		List<Customer> cList = registerService.getLWDetails();
		return cList;

	}
	@RequestMapping(value = "/customers", method = RequestMethod.GET,produces={"application/xml"})
	@ResponseStatus(value=HttpStatus.ACCEPTED)  
	public @ResponseBody
	CustomerGroup getXMLView() {
		CustomerGroup customerGroup = new CustomerGroup();
		customerGroup.setCustomers(registerService.getLWDetails());
		
		return customerGroup;

	}
	@RequestMapping(value ="/customers" ,method =RequestMethod.GET)
	public String getHTMLView(Model model)
	{
		model.addAttribute("cList",registerService.getLWDetails());
		
		return "view";
		
	}
	
}
