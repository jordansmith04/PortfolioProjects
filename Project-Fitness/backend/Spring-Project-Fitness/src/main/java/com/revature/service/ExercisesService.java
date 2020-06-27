package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Exercises;
import com.revature.repository.ExercisesRepo;

@Service("ExerciseService")
public class ExercisesService {

		@Autowired //Wire your polkamanRepository bean in using this annotation!
		private ExercisesRepo exerRepository;
		
		public List<Exercises> getAllExercises(){
			return this.exerRepository.getAllExercises();
		}
		
		public void insertExercise(Exercises p) {
			this.exerRepository.insertExercise(p);
		}
		
		public Exercises getExercisesById(int id){
			return this.exerRepository.getExercisesById(id);
		}

		public List<Exercises> getAllExercisesbyBody(String bodyarea) {
			return this.exerRepository.getAllExercisesbyBody(bodyarea);
			
		}
}
