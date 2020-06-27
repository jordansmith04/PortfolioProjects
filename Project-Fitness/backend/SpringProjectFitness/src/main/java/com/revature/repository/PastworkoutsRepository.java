package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Pastworkouts;
import com.revature.models.Userinfo;

@Repository("pastworkoutsRepository")
public interface PastworkoutsRepository  extends JpaRepository<Pastworkouts, Integer>{

<S extends Pastworkouts> S save(Pastworkouts p);
	
	List<Pastworkouts> findAllByUsername(String username);
}
