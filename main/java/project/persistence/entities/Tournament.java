package project.persistence.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Tournament {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String course;
	private Golfer[] players;
	private Date startDate;
	
	public Tournament(String course, Date startDate, Golfer[] players) {
		this.course = course;
		this.startDate = startDate;
		this.players = players;
	}
	
	
	
	public static void main(String[] args) {
		Tournament tour = new Tournament("mamma'in", new Date(), null);
		
		System.out.println(tour.getCourse());
	}



	public String getCourse() {
		return course;
	}



	public void setCourse(String course) {
		this.course = course;
	}



	public Golfer[] getPlayers() {
		return players;
	}



	public void setPlayers(Golfer[] players) {
		this.players = players;
	}



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


}
