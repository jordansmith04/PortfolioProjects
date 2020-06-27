package com.revature.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "pastworkouts")
public class Pastworkouts {

	@Id
	@Column
	int userID;
	
	@Column
	String exercise;
	
	@Column
	int reps;
	
	@Column
	Date datecompleted;
	
	
	public Pastworkouts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pastworkouts(int userID, String exercise, int reps, Date datecompleted) {
		super();
		this.userID = userID;
		this.exercise = exercise;
		this.reps = reps;
		this.datecompleted = datecompleted;
	}
	@Override
	public String toString() {
		return "Pastworkouts [userID=" + userID + ", exercise=" + exercise + ", reps=" + reps + ", datecompleted="
				+ datecompleted + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datecompleted == null) ? 0 : datecompleted.hashCode());
		result = prime * result + ((exercise == null) ? 0 : exercise.hashCode());
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
		Pastworkouts other = (Pastworkouts) obj;
		if (datecompleted == null) {
			if (other.datecompleted != null)
				return false;
		} else if (!datecompleted.equals(other.datecompleted))
			return false;
		if (exercise == null) {
			if (other.exercise != null)
				return false;
		} else if (!exercise.equals(other.exercise))
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
	public Date getDatecompleted() {
		return datecompleted;
	}
	public void setDatecompleted(Date datecompleted) {
		this.datecompleted = datecompleted;
	}
	
	
	
}
