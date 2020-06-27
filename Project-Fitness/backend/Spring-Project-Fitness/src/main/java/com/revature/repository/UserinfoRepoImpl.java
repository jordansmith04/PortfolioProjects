package com.revature.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.revature.models.Userinfo;
import com.revature.util.HibernateConfiguration;

public class UserinfoRepoImpl implements UserinfoRepo{

	@Override
	public Userinfo findUserByUsername(String username) {
		Userinfo user = new Userinfo();
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			user = s.createQuery("FROM Userinfo WHERE user.username = :username", Userinfo.class).getSingleResult();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return user;
	}

	@Override

	public Userinfo insertUser(Userinfo p){
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
		
		return p;
	}

	@Override
	public Userinfo updateUser(Userinfo p) {
		Userinfo u = new Userinfo();
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateConfiguration.getSession();
			tx = s.beginTransaction();
			u = s.createQuery("update userinfo set username = :username, pass = :pass, age = :age, height = :height, weight = :weight WHERE userid = :userid", Userinfo.class).getSingleResult();
			s.setProperty("id", p.getUserID());
			s.setProperty("username", p.getUsername());
			s.setProperty("pass", p.getPass());
			s.setProperty("age", p.getAge());
			s.setProperty("height", p.getHeight());
			s.setProperty("weight", p.getWeight());
			tx.commit();
		}catch(HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			s.close();
		}
		
		return u;
	}

	
	
}
