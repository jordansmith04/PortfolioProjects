package com.revature.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Userinfo;
import com.revature.service.UserinfoService;

@RestController("userinfoController")
@RequestMapping(path="/user")
public class UserinfoController {

	private UserinfoService userinfoService;
	
	public UserinfoController(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}
	
	@GetMapping(path="/{username}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Userinfo> findByUsername(@PathVariable String username) {
		return new ResponseEntity<>(this.userinfoService.findByUsername(username), HttpStatus.OK);
	};
	
	@PostMapping(path="/NewUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public void insertUser(@RequestBody Userinfo p) {
		this.userinfoService.insertUser(p);
	};
}
