package com.mc.rad.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:WebContent/WEB-INF/dispatcher-servlet.xml","file:WebContent/WEB-INF/applicationContext-dao.xml"})
public class QueryControllerIntTest {
	
	private static final String URI = "/query/{action}";

	@Autowired
	WebApplicationContext wac;
	
	MockMvc mockMvc;
	
	@Before
	public void setUp(){
		
		mockMvc=webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testQueryLastWeekResults() throws Exception{
		
		this.mockMvc.perform(get("/query/lwDetails")).andDo(print())
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("/WEB-INF/pages/pWeekResults.jsp"));
	}
	
	@Test
	public void testJsonViewResult() throws Exception {
		
		this.mockMvc.perform(get("/view/customers.json").accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.[0].name").value("cc04"))
		.andExpect(jsonPath("$.[0].country").value("India"));
	}
	
	@Test
	public void testXMLViewResult() throws Exception {
		
		this.mockMvc.perform(get("/view/customers.xml").accept(MediaType.APPLICATION_XML))
		.andDo(print())
		.andExpect(content().contentType(MediaType.APPLICATION_XML));
		
	}
	@Test
	public void testHTMLViewResult() throws Exception {
		
		this.mockMvc.perform(get("/view/customers.html"))
		.andDo(print());
		
		
	}



}
