package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.models.Exercises;
import com.revature.service.ExercisesService;


@RestController("exerciseController")
@RequestMapping(path = "/")
public class ExerciseController {
		
		//I need a service dependency.
		private ExercisesService exerService;
		
		@Autowired
		private RestTemplate restTemplate;
		
		@Autowired //Autowired in dependency using constructor injection.
		public ExerciseController(ExercisesService exerService) {
			this.exerService = exerService;
		}

		//The resource that this method returns is mapped to "/home" and accepts the GET method.
		//This method will only return a view if we're using @Controller rather than RestController.
		@GetMapping(path = "/exercises", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public List<Exercises> getAllExercises() {
			List<Exercises> list = exerService.getAllExercises();
			return list;
		}
		
		@PostMapping(path = "/NewExercise")
		public void insertExercise(Exercises e) {
			exerService.insertExercise(e);
		}	
		
		@PostMapping(path = "/exercises")
		public List<Exercises> getAllExercisesbyBody(String bodyarea){
			List<Exercises> list = exerService.getAllExercisesbyBody(bodyarea);
			return list;
		}
		
		
		
}

