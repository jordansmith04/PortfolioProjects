package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Exercises;

@Repository("exercisesRepository") //Don't forget to add your bean to the IOC container!
public interface ExercisesRepository extends JpaRepository<Exercises, Integer>{

	List<Exercises> findById(int id);
	<S extends Exercises> S save(Exercises p);
	Exercises findByExercise(String exercise);
	List<Exercises> findAllByBodyarea(String bodyarea);
	
}