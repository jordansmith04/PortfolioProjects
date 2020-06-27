package com.revature.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.models.Futureworkouts;

import com.revature.models.Workouts;

@Repository("FutureworkoutsRepo")
public interface FutureworkoutsRepo {

	public void insertWorkout(Futureworkouts p);

	public List<Futureworkouts> findAllById(int id);

	void deleteFutureworkout(Futureworkouts f);
}
