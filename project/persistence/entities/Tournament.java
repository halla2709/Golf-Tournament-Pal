package project.persistence.entities;

import java.util.Date;

public class Tournament {
	
	String course;
	//Golfer[] players;
	Date startDate;
	int numberOfRounds;
	
	public Tournament(String course, Date startDate, int numberOfRounds) {
		this.course = course;
		this.startDate = startDate;
		this.numberOfRounds = numberOfRounds;
	}
	
	public static void main(String[] args) {
		Tournament tour = new Tournament("mamma'in", new Date(), 5);
		
		System.out.println(tour.course);
	}
}
