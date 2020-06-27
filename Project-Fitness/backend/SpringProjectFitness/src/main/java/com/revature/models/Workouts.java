package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "workouts")
public class Workouts {
	@Id //denotes that this column is the primary key for this table.
	@Column
	int exercisenumber;
	
	@Column
	String bodyarea;
	
	@Column
	String exercise;
	
	@Column
	int reps;
	
	@Column
	int totalcalories;
	
	
	public Workouts() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Workouts(int exercisenumber, String bodyarea, String exercise, int reps, int totalcalories) {
		super();
		this.exercisenumber = exercisenumber;
		this.bodyarea = bodyarea;
		this.exercise = exercise;
		this.reps = reps;
		this.totalcalories = totalcalories;
	}


	@Override
	public String toString() {
		return "Workouts [exercisenumber=" + exercisenumber + ", bodyarea=" + bodyarea + ", exercise=" + exercise
				+ ", reps=" + reps + ", totalcalories=" + totalcalories + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bodyarea == null) ? 0 : bodyarea.hashCode());
		result = prime * result + ((exercise == null) ? 0 : exercise.hashCode());
		result = prime * result + exercisenumber;
		result = prime * result + reps;
		result = prime * result + totalcalories;
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
		Workouts other = (Workouts) obj;
		if (bodyarea == null) {
			if (other.bodyarea != null)
				return false;
		} else if (!bodyarea.equals(other.bodyarea))
			return false;
		if (exercise == null) {
			if (other.exercise != null)
				return false;
		} else if (!exercise.equals(other.exercise))
			return false;
		if (exercisenumber != other.exercisenumber)
			return false;
		if (reps != other.reps)
			return false;
		if (totalcalories != other.totalcalories)
			return false;
		return true;
	}


	public int getExercisenumber() {
		return exercisenumber;
	}


	public void setExercisenumber(int exercisenumber) {
		this.exercisenumber = exercisenumber;
	}


	public String getBodyarea() {
		return bodyarea;
	}


	public void setBodyarea(String bodyarea) {
		this.bodyarea = bodyarea;
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


	public int getTotalcalories() {
		return totalcalories;
	}


	public void setTotalcalories(int totalcalories) {
		this.totalcalories = totalcalories;
	}


	
}
