package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Exercises;
import com.revature.util.HibernateConfiguration;

public class ExercisesRepoImpl implements ExercisesRepo{

	@Override
	public Exercises getExercisesById(int id) {
		Exercises e = new Exercises();
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			e = s.createQuery("FROM exercises WHERE exerciseNumber = :exerciseNumber", Exercises.class).getSingleResult();
			s.setProperty("exerciseNumber", id);
			tx.commit();
		}catch(HibernateException ex) {
			tx.rollback();
			ex.printStackTrace();
		}finally {
			s.close();
		}
		
		return e;
	}

	@Override
	public void insertExercise(Exercises p) {
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
	public List<Exercises> getAllExercises(){
		List<Exercises> Ex = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			Ex = s.createQuery("FROM exercises", Exercises.class).getResultList();
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
	public List<Exercises> getAllExercisesbyBody(String bodyarea){
		List<Exercises> Ex = new ArrayList<>();
		Session s = null;
		Transaction tx = null;
	try {
		s = HibernateConfiguration.getSession();
		tx = s.beginTransaction();
		Ex = s.createQuery("FROM exercises where :bodyarea", Exercises.class).setParameter("bodyarea", bodyarea).getResultList();
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
