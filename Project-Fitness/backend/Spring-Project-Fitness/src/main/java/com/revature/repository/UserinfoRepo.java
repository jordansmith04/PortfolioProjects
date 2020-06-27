package com.revature.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Userinfo;

@Repository("UserinfoRepo")
public interface UserinfoRepo{

		public Userinfo findUserByUsername(String username);
		
		public Userinfo insertUser(Userinfo p);

		public Userinfo updateUser(Userinfo p);
		
	}

	
