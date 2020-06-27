package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Futureworkouts;
import com.revature.util.HibernateConfiguration;

public class FutureworkoutsRepoImpl implements FutureworkoutsRepo{

	@Override
	public void insertWorkout(Futureworkouts p) {
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
	public List<Futureworkouts> findAllById(int id) {
		List<Futureworkouts> Ex = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			Ex = s.createQuery("FROM futureworkouts where id= :id", Futureworkouts.class).getResultList();
			s.setProperty("id", id);
			tx.commit();
		}catch(HibernateException ex) {
			tx.rollback();
			ex.printStackTrace();
		}finally {
			s.close();
		}
		
		return Ex;
	}
	
	@Override
	public void deleteFutureworkout(Futureworkouts f) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			s.createQuery("delete from futureworkouts where futuredate = :id", Futureworkouts.class);
			s.setProperty("id", f.getFuturedate());
			tx.commit();
		}catch(HibernateException ex) {
			tx.rollback();
			ex.printStackTrace();
		}finally {
			s.close();
		}
	}
}
