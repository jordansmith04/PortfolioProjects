package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Workouts;
import com.revature.util.HibernateConfiguration;

public class WorkoutsRepoImpl implements WorkoutsRepo {

	@Override
	public void insertWorkout(Workouts p) {
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
	public List<Workouts> findWorkoutById(int userID) {
		List<Workouts> Ex = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			Ex = s.createQuery("FROM pastworkouts where userid= :id group by workoutNumber", Workouts.class).getResultList();
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

	@Override
	public List<Workouts> getAllWorkouts() {
		List<Workouts> Ex = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			Ex = s.createQuery("FROM workouts", Workouts.class).getResultList();
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
