package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.revature.models.Pastworkouts;
import com.revature.util.HibernateConfiguration;


public class PastworkoutsRepoImpl implements PastworkoutsRepo{

	@Override
	public void insertWorkout(Pastworkouts p) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			s.save(p);
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		
	}

	@Override
	public List<Pastworkouts> findPastworkoutById(int userID) {
		List<Pastworkouts> Ex = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			Ex = s.createQuery("FROM pastworkouts where userid= :id order by date asc", Pastworkouts.class).getResultList();
			s.setProperty("id", userID);
			tx.commit();
		}catch(HibernateException ex) {
			tx.rollback();
			ex.printStackTrace();
		}finally {
			s.close();
		}
		
		return Ex;
	}
	

	
	
}
