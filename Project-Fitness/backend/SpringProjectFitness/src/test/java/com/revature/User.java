package com.revature;
import static org.mockito.Mockito.mockitoSession;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import com.revature.models.Exercises;
import com.revature.models.Futureworkouts;
import com.revature.models.Pastworkouts;
import com.revature.models.Userinfo;
import com.revature.models.Workouts;
import com.revature.repository.ExercisesRepository;
import com.revature.repository.FutureworkoutsRepository;
import com.revature.repository.PastworkoutsRepository;
import com.revature.repository.UserinfoRepository;
import com.revature.repository.WorkoutsRepository;
import com.revature.service.ExercisesService;
import com.revature.service.PastworkoutsService;
import com.revature.service.UserinfoService;


@TestInstance(Lifecycle.PER_CLASS)
public class User {

	@Mock    UserinfoRepository r;
	@Mock    ExercisesRepository er;
	@Mock    PastworkoutsRepository pr;
	@Mock    FutureworkoutsRepository fr;
	@Mock    WorkoutsRepository wr;
	@Mock    Userinfo ur;
	@Mock    Pastworkouts p;
	@Mock    Futureworkouts f;
	@Mock    Exercises e;
	@Mock    Workouts w;
	@InjectMocks UserinfoService us;
	@InjectMocks PastworkoutsService ps;
	@InjectMocks ExercisesService es;
	@BeforeAll
	public void setUp() {
		
		us = new UserinfoService();
		ps = new PastworkoutsService();
		
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testUserByUsername() {
		Userinfo mockUser = new Userinfo("kgsmith","ayakitt",23,55,200);
		
		Mockito.when(r.findByUsername("kgsmith")).thenReturn(mockUser);
		Assertions.assertEquals("kgsmith", mockUser.getUsername());
	}
	
	@Test
	public void testPastByUsername() {
		List<Pastworkouts> mockwork = Arrays.asList(
				new Pastworkouts (1,"kgsmith","push-ups",5));
		Mockito.when(pr.findAllByUsername("kgsmith")).thenReturn(mockwork);
		Assertions.assertEquals("kgsmith", mockwork.get(0).getUsername());
		System.out.println(mockwork);
	}
	@Test
	public void testFutureByUsername() {
		List<Futureworkouts> mockwork = Arrays.asList(
				new Futureworkouts (1,"kgmith","push-ups",5));
		Mockito.when(fr.findAllByUsername("kgsmith")).thenReturn(mockwork);
		Assertions.assertEquals("kgsmith", mockwork.get(0).getUsername());
		System.out.println(mockwork);
	}
	@Test
	public void testAllbyBodyarea() {
		List<Exercises> mockbody = Arrays.asList(
				new Exercises (1, "chest and arms", "push-ups",4),
				new Exercises (2, "legs","squats",10),
				new Exercises (3, "chest and arms", "Decline pushup", 20)
				);
		Mockito.when(er.findAllByBodyarea("chest and arms")).thenReturn(mockbody);
		Assertions.assertEquals("chest and arms", mockbody.get(0).getBodyarea());
		System.out.println(mockbody);
	}
	
	@Test
	public void testGetbyExercises() {
		Exercises mockex = new Exercises(1,"asdfa","asdfa",3);
		
		Mockito.when(er.findByExercise("asdfa")).thenReturn(mockex);
		Assertions.assertEquals("asdfa",mockex.getExercise());
	}
	
	@Test
	public void TestGetExById() {
		List<Exercises>mockex = Arrays.asList(
		 new Exercises(1,"asfa","asdfa", 2));
		
		Mockito.when(er.findById(1)).thenReturn(mockex);
		Assertions.assertEquals(1, mockex.get(0).getExerciseNumber());
	}
	@Test
	public void Testgetworkout() {
		List<Workouts> mockwork = Arrays.asList( 
				new Workouts (1,"chest","push", 2, 50)
				);
		Mockito.when(wr.findAllByExercisenumber(1)).thenReturn(mockwork);
		Assertions.assertEquals(1, mockwork.get(0).getExercisenumber());
	}
	
	@BeforeEach()
	public void delet() {
		
	}
	
	@AfterEach()
	public void reset() {
		
	}
}
