package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Pastworkouts;
import com.revature.service.PastworkoutsService;

@RestController("PastworkoutsController")
@RequestMapping(path = "/Past")
public class PastworkoutsController {
	
	
	private PastworkoutsService pService;
	
	@Autowired
	public PastworkoutsController(PastworkoutsService pService) {
		this.pService = pService;
	}
	
	@PostMapping(path = "/NewPast")
	public void insertPastworkout(Pastworkouts p) {
		this.pService.insertPastworkout(p);
	}
	
	@GetMapping (path = "/GetPast/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public List<Pastworkouts> getPastworkoutsById(@PathVariable int id){
		return this.pService.getPastworkoutsById(id);
	}
	
	
	
}
