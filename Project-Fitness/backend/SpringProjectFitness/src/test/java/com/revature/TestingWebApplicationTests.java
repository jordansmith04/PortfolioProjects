package com.revature;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.controller.ExercisesController;
import com.revature.controller.FutureworkoutsController;


@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplicationTests {
	
	@Autowired
	private FutureworkoutsController Fcontroller;

	@Autowired
	private ExercisesController controller;

	@Test
	public void contexLoadss() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void contexLoads() throws Exception{
		assertThat(Fcontroller).isNotNull();
	}
	
}