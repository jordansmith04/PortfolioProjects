package com.revature.repository;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.revature.models.Pastworkouts;



	
	@Repository("PastworkoutsRepository") //Don't forget to add your bean to the IOC container!
	public interface PastworkoutsRepo{

		
		public void insertWorkout(Pastworkouts p);
		
		List<Pastworkouts> findPastworkoutById(int userID);
};