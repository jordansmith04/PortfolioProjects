package com.revature.repository;

import java.util.List;


import org.springframework.stereotype.Repository;


import com.revature.models.Exercises;

@Repository("ExercisesRepo")
public interface ExercisesRepo{
	
	public List<Exercises> getAllExercises();
	
	public void insertExercise(Exercises p);
	
	public Exercises getExercisesById(int id);

	List<Exercises> getAllExercisesbyBody(String bodyarea);
}


