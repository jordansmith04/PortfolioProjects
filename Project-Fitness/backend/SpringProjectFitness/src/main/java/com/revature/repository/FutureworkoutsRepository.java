package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Futureworkouts;

@Repository("futureworkoutsRepository")
public interface FutureworkoutsRepository  extends JpaRepository<Futureworkouts, Integer>{

	
	<S extends Futureworkouts> S save(Futureworkouts p);
	
	List<Futureworkouts> findAllByUsername(String username);
}
