package com.revature.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Exercises;
import com.revature.service.ExercisesService;

@RestController("exercisesController")
@RequestMapping(path="/exercises")
public class ExercisesController {

	private ExercisesService exercisesService;
	
	public ExercisesController(ExercisesService exercisesService) {
		this.exercisesService = exercisesService;
	}
	
//	@RequestMapping(path = "/home", method = RequestMethod.GET)
//	public String goHome() {
//		return "index";
//	}
//	
//	@RequestMapping(path = "/message", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody //This denotes that this method writes directly to the response body.
//	public String getJsonMessage() {
//		return "This is JSON!";
//	}	
//	
	@GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Exercises> findById(@PathVariable int id){
		return this.exercisesService.findById(id);
	};
	
	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public <S extends Exercises> Exercises insertExercise(@RequestBody Exercises p) {
		return this.exercisesService.insertExercise(p);
	};
	
	@GetMapping(path = "/exercises/{exercise}", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public Exercises findByExercise(@PathVariable String exercise) {
		Exercises e = this.exercisesService.findByExercise(exercise);
		return e;
	};
	
	@GetMapping(path= "/bodyarea/{bodyarea}", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Exercises> findAllByBodyarea(@PathVariable String bodyarea){
		return this.exercisesService.findAllByBodyarea(bodyarea);
	};
}
