package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.revature.models.Userinfo;

@Repository("userinfoRepository")
public interface UserinfoRepository extends JpaRepository<Userinfo, Integer>{

	Userinfo findByUsername(String username);
	<S extends Userinfo> S save(Userinfo S);
	
}
