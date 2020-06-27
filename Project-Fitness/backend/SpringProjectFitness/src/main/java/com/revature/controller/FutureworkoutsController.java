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

import com.google.gson.Gson;
import com.revature.models.Futureworkouts;
import com.revature.service.FutureworkoutsService;

@RestController("futureworkoutsController")
@RequestMapping(path="/future")
public class FutureworkoutsController {

	private FutureworkoutsService futureworkoutsService;
	
	public FutureworkoutsController(FutureworkoutsService futureworkoutsService) {
		this.futureworkoutsService = futureworkoutsService;
	}
	
	
	@PostMapping(path="/NewFuture", consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public <S extends Futureworkouts> void insertFuture(@RequestBody Futureworkouts p) {
		this.futureworkoutsService.insertFuture(p);
	};
	
	@GetMapping(path="/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Futureworkouts> findAllByUsername(@PathVariable String username){
		List<Futureworkouts> list = this.futureworkoutsService.findAllByUsername(username);
		return list;
	};
}
