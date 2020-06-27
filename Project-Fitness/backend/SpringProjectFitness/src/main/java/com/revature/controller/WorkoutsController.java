package com.revature.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Workouts;
import com.revature.service.WorkoutsService;

@RestController("workoutsController")
@RequestMapping(path="/workouts")
public class WorkoutsController {
	
	private WorkoutsService workoutsService;
	
	public WorkoutsController(WorkoutsService workoutsService) {
		this.workoutsService = workoutsService;
	}
	
	@GetMapping(path = "/{exercisenumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Workouts> findAllByExercisenumber(@PathVariable int exercisenumber){
		return this.workoutsService.findAllByExercisenumber(exercisenumber);
	};
	
}
