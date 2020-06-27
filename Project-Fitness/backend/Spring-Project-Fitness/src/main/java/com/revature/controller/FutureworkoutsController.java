package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Futureworkouts;
import com.revature.service.FutureworkoutsService;

@RestController("FutureController")
@RequestMapping(path = "/Future")
public class FutureworkoutsController {

	private FutureworkoutsService fService;
	
	@Autowired
	public void FutureController(FutureworkoutsService fService){
		this.fService = fService;
		
	}
	
	@PostMapping(path = "/NewFuture")
	public void insertFutureworkout(Futureworkouts p) {
		this.fService.insertFutureworkout(p);
	}
	
	@GetMapping(path= "/GetFuture/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Futureworkouts> getFutureworkoutsById(@PathVariable int id){
		return this.fService.getFutureworkoutsById(id);
	}
	
}
