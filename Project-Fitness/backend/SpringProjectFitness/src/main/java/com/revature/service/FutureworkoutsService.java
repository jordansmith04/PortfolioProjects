package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Futureworkouts;
import com.revature.repository.FutureworkoutsRepository;

@Service("futureworkoutsService")
public class FutureworkoutsService {

	@Autowired
	private FutureworkoutsRepository futureworkoutsRepository;
	
	public <S extends Futureworkouts> S insertFuture(Futureworkouts p) {
		return this.futureworkoutsRepository.save(p);
	};
	
	public List<Futureworkouts> findAllByUsername(String username){
		return this.futureworkoutsRepository.findAllByUsername(username);
	};
}
