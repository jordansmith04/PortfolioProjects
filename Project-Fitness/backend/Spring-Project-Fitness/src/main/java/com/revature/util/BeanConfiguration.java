package com.revature.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.service.ExercisesService;
import com.revature.service.FutureworkoutsService;
import com.revature.service.PastworkoutsService;
import com.revature.service.UserinfoService;


	@Configuration
	public class BeanConfiguration {

		@Bean(value = "ExercisesService") //This method returns a bean!
		public ExercisesService getExercisesService() {
			return new ExercisesService();
		}
		
		@Bean(value = "FutureworkoutsService") //This method returns a bean!
		public FutureworkoutsService getFutureworkoutsService() {
			return new FutureworkoutsService();
		}
		
		@Bean(value = "PastworkoutsService") //This method returns a bean!
		public PastworkoutsService getPastworkoutsService() {
			return new PastworkoutsService();
		}
		
		@Bean(value = "UserinfoService") //This method returns a bean!
		public UserinfoService getUserinfoService() {
			return new UserinfoService();
		}
}
