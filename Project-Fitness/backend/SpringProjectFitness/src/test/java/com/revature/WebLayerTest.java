package com.revature;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.UserinfoController;

import com.revature.service.UserinfoService;
@ExtendWith(SpringExtension.class)
@WebMvcTest(UserinfoController.class)
public class WebLayerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private UserinfoService service;
	@Test
	  void whenValidInput_thenReturns200() throws Exception {
	    mockMvc.perform(null);
	  }
}