package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Exercises;
import com.revature.repository.ExercisesRepository;

@Service("exercisesService")
public class ExercisesService {

	@Autowired
	private ExercisesRepository exercisesRepository;
	
	public List<Exercises> findById(int id){
		return this.exercisesRepository.findById(id);
	};
	
	public <S extends Exercises> S insertExercise(Exercises p) {
		return this.exercisesRepository.save(p);
	};
	
	public Exercises findByExercise(String exercise) {
		return this.exercisesRepository.findByExercise(exercise);
	};
	
	public List<Exercises> findAllByBodyarea(String bodyarea){
		return this.exercisesRepository.findAllByBodyarea(bodyarea);
	};
	
}
