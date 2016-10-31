package project.persistence.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
 
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Tournament {
	
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
	private String course;
	
	@ManyToMany()
	@JoinTable(name="TournamentPlayers", joinColumns=@JoinColumn(name="tournament_id"), inverseJoinColumns=@JoinColumn(name="golfer_id")) 
	private List<Golfer> players;
	private Date startDate;
	
	public Tournament(String course, Date startDate, List<Golfer> players) {
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



	public List<Golfer> getPlayers() {
		return players;
	}



	public void setPlayers(List<Golfer> players) {
		this.players = players;
	}



	public Date getStartDate() {
		return startDate;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


}
