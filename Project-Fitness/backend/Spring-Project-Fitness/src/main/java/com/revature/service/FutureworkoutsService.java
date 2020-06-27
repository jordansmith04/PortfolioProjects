package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Futureworkouts;
import com.revature.repository.FutureworkoutsRepo;

@Service("FutureworkoutsService")
public class FutureworkoutsService {

	@Autowired //Wire your polkamanRepository bean in using this annotation!
	private FutureworkoutsRepo futworkoutsRepository;
	
	public void insertFutureworkout(Futureworkouts p) {
		this.futworkoutsRepository.insertWorkout(p);
	}
	
	public List<Futureworkouts> getFutureworkoutsById(int id){
		return this.futworkoutsRepository.findAllById(id);
	}
}
