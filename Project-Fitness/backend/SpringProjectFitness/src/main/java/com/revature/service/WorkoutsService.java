package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Workouts;
import com.revature.repository.WorkoutsRepository;

@Service("workoutsService")
public class WorkoutsService {

	@Autowired
	private WorkoutsRepository workoutsRepository;
	
	public List<Workouts> findAllByExercisenumber(int exercisenumber){
		return this.workoutsRepository.findAllByExercisenumber(exercisenumber);
	};
}
