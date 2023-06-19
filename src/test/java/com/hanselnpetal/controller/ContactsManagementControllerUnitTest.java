package com.hanselnpetal.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.hanselnpetal.domain.CustomerContact;
import com.hanselnpetal.service.ContactsManagementService;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactsManagementController.class)
public class ContactsManagementControllerUnitTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ContactsManagementService contactsManagementService;
	
	@InjectMocks
	private ContactsManagementController contactsManagementController;
	
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);	
	}
	
	@Autowired
	Gson gson;
	
	@Test
	public void testAddContactHappyPath() throws Exception {
		// setup mock Contact returned the mock service component
		CustomerContact mockCustomerContact = new CustomerContact();
		mockCustomerContact.setFirstName("Fred");
		
		when(contactsManagementService.add(any(CustomerContact.class)))
			.thenReturn(mockCustomerContact);
		
		// simulate the form bean that would POST from the web page
		CustomerContact aContact = new CustomerContact();
		aContact.setFirstName("Fred");
		aContact.setEmail("fredj@gmail.com");
		
		// simulate the form submit (POST)
		mockMvc
			.perform(post("/addContact").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(aContact)))
			.andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testAddContactBizServiceRuleNotSatisfied() throws Exception {
		
		// setup a mock response of NULL object returned from the mock service component
		when(contactsManagementService.add(any(CustomerContact.class)))
			.thenReturn(null);
		
		// simulate the form bean that would POST from the web page
		CustomerContact aContact = new CustomerContact();
		aContact.setLastName("Johnson");
			
		// simulate the form submit (POST)
		mockMvc
			.perform(post("/addContact").contentType(MediaType.APPLICATION_JSON).content(gson.toJson(aContact)))
			.andExpect(status().is(400))
			.andReturn();
	}
	
	@Test
	public void testAddContactOccasionHappyPath() throws Exception {
		// implement this
	}
}
