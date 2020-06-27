package com.revature.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Pastworkouts;
import com.revature.service.PastworkoutsService;

@RestController("pastworkoutsController")
@RequestMapping(path="/past")
@CrossOrigin(origins = "http://localhost:4200")
public class PastworkoutsController {

	private PastworkoutsService pastworkoutsService;
	
	public PastworkoutsController(PastworkoutsService pastworkoutsService) {
		this.pastworkoutsService = pastworkoutsService;
	}
	
	@PostMapping(path="/NewPast", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public <S extends Pastworkouts> void insertPastworkout(@RequestBody Pastworkouts p) {
		this.pastworkoutsService.insertPastworkout(p);
	};
	
	@GetMapping(path="/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Pastworkouts> getPastworkouts(@PathVariable String username){
		return this.pastworkoutsService.getPastworkouts(username);
	};
}