package com.mc.rad.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import com.mc.rad.model.Customer;
/**
 * Intigration test using spring test mvc.
 * @author m1017056
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:WebContent/WEB-INF/dispatcher-servlet.xml","file:WebContent/WEB-INF/applicationContext-dao.xml"})
public class RegisterControllerIntigrationTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp(){
		//add when mocking is used.
		/*MockitoAnnotations.initMocks(this);*/
		this.mockMvc = webAppContextSetup(this.webApplicationContext).build();
		/*Customer customer = Mockito.mock(Customer.class);
		Mockito.when(customer.getCountry()).thenReturn("India");*/
		
	}
	
	@Test
	public void testRegisterRequest() throws Exception{
		mockMvc.perform(get("/register")).andExpect(status().isOk()).andExpect(model().attributeExists("customerForm"));
	}
	
	@Test
	public void testRegisterSaveWithEroors() throws Exception{
		mockMvc.perform(post("/register")).andExpect(status().isOk())
			.andExpect(model().hasErrors())
			;
		
	}
	@Test
	public void testRegisterSaveCorrect() throws Exception{
		mockMvc.perform(post("/register")
				.param("name", UUID.randomUUID().toString().substring(4, 8))
				.param("state", "Karnatka")
				.param("gender", "M")
				.param("country", "India")
				.param("occupation", "S/w ENG"))
		.andDo(print())
		.andExpect(redirectedUrl("index.jsp"))
		.andExpect(model().hasNoErrors());
				
	}


}
