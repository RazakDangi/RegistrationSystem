package com.mc.rad.controller;


import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.mc.rad.controller.validators.RegisterValidator;
import com.mc.rad.model.Customer;
import com.mc.rad.service.RegisterService;


@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Resource(name="registerService")
	private RegisterService registerService;
	
	private RegisterValidator registerValidator;
	
	
	public RegisterService getRegisterService() {
		return registerService;
	}
	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}
	@Autowired
	public RegisterController(RegisterValidator registerValidator) {
			this.registerValidator = registerValidator;
	}
	@RequestMapping(method = RequestMethod.GET)
	public String handleRegisterRequest(ModelMap model){
		Customer c = new Customer();
		model.addAttribute("customerForm",c);
		return "registerForm";
	}
	
	

	@RequestMapping(method = RequestMethod.POST)
	public String handleRegisterSave(@ModelAttribute("customerForm") Customer c,BindingResult bindingResult,SessionStatus status,Model model){
		System.out.println("success");
	
		registerValidator.validate(c, bindingResult);
		 
		if (bindingResult.hasErrors()) {
				return "registerForm";
		} else {
			status.setComplete();
			c.setCreatedOn(new Date());
			registerService.addCustomer(c);
			
			return "redirect:index.jsp";
		}
		
		
	}
}
