package com.revature.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table( name = "futureworkouts")
public class Futureworkouts {
	
	@Id
	@Column
	int userID;
	
	@Column
	String exercise;
	
	@Column
	int reps;
	
	@Column
	Date futuredate;
	
	
	public Futureworkouts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Futureworkouts(int userID, String exercise, int reps, Date futuredate) {
		super();
		this.userID = userID;
		this.exercise = exercise;
		this.reps = reps;
		this.futuredate = futuredate;
	}
	@Override
	public String toString() {
		return "Futureworkouts [userID=" + userID + ", exercise=" + exercise + ", reps=" + reps + ", futuredate="
				+ futuredate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exercise == null) ? 0 : exercise.hashCode());
		result = prime * result + ((futuredate == null) ? 0 : futuredate.hashCode());
		result = prime * result + reps;
		result = prime * result + userID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Futureworkouts other = (Futureworkouts) obj;
		if (exercise == null) {
			if (other.exercise != null)
				return false;
		} else if (!exercise.equals(other.exercise))
			return false;
		if (futuredate == null) {
			if (other.futuredate != null)
				return false;
		} else if (!futuredate.equals(other.futuredate))
			return false;
		if (reps != other.reps)
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getExercise() {
		return exercise;
	}
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}
	public int getReps() {
		return reps;
	}
	public void setReps(int reps) {
		this.reps = reps;
	}
	public Date getFuturedate() {
		return futuredate;
	}
	public void setFuturedate(Date futuredate) {
		this.futuredate = futuredate;
	}
	
	
	
}
