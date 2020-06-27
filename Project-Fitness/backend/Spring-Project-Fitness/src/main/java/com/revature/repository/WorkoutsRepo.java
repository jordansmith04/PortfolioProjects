package com.revature.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.models.Workouts;

@Repository("WorkoutsRepository")
public interface WorkoutsRepo {
		
		public void insertWorkout(Workouts p);
		
		List<Workouts> findWorkoutById(int userID);

		public List<Workouts> getAllWorkouts();
}
