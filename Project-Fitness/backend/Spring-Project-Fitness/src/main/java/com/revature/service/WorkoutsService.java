package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Workouts;
import com.revature.repository.WorkoutsRepo;


@Service
public class WorkoutsService {

	@Autowired //Wire your polkamanRepository bean in using this annotation!
	private WorkoutsRepo wRepository;
	
	
	public void insertWorkout(Workouts p) {
		this.wRepository.insertWorkout(p);
	}
	
	public List<Workouts> getWorkoutsById(int id){
		return this.wRepository.findWorkoutById(id);
	}
	
	public List<Workouts> getAllWorkouts(){
		return this.wRepository.getAllWorkouts();
	}

}
