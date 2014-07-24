package com.mc.rad.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mc.rad.model.Customer;
import com.mc.rad.model.CustomerVO;
import com.mc.rad.service.RegisterService;

@Controller
@RequestMapping("/query")
public class QueryController {

	@Resource(name = "registerService")
	private RegisterService registerService;

	@RequestMapping(value = "/lwDetails", method = RequestMethod.GET)
	public String getLastWeekDetailsCount(Model model) {
		model.addAttribute("lwCustomerDetails", lastWeekModelAttribute(model));
		return "pWeekResults";
	}

	
	private CustomerVO lastWeekModelAttribute(Model model) {
		CustomerVO customerVOs = registerService.getLWBDetailsCount();
		model.addAttribute("lwCustomerDetails",customerVOs);
		return customerVOs;
	}


	
	public RegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	
}
