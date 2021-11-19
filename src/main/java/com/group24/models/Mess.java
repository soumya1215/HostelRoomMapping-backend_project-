package com.group24.models;

import javax.persistence.*;

@Entity
@Table(name="canteen_details")
public class Mess {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


	@Column(name="day")
	private String day;
	
	@Column(name="beakfast")
	private String breakfast;
	
    @Column(name="lunch")
	private String lunch;
	
	@Column(name="snack")
	private String snack;

	@Column(name="dinner")
	private String dinner;
	
	
	
	public Mess() {
		 	
	}



	public Mess(String day, String breakfast, String lunch, String snack, String dinner) {
		super();
		this.day = day;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.snack = snack;
		this.dinner = dinner;
	}


	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getDay() {
		return day;
	}



	public void setDay(String day) {
		this.day = day;
	}



	public String getBreakfast() {
		return breakfast;
	}



	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}



	public String getLunch() {
		return lunch;
	}



	public void setLunch(String lunch) {
		this.lunch = lunch;
	}



	public String getSnack() {
		return snack;
	}



	public void setSnack(String snack) {
		this.snack = snack;
	}


	public String getDinner() {return dinner;}


	public void setDinner(String dinner) {this.dinner = dinner;}
}