package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Pastworkouts;
import com.revature.repository.PastworkoutsRepo;


	@Service("PastworkoutsService")
	public class PastworkoutsService {

		@Autowired //Wire your polkamanRepository bean in using this annotation!
		private PastworkoutsRepo pastworkoutsRepository;
		
		
		public void insertPastworkout(Pastworkouts p) {
			this.pastworkoutsRepository.insertWorkout(p);
		}
		
		public List<Pastworkouts> getPastworkoutsById(int id){
			return this.pastworkoutsRepository.findPastworkoutById(id);
		}
	
}
