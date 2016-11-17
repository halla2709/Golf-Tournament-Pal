package project.persistence.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Inheritance(strategy=InheritanceType.JOINED)
public class Tournament {
	
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
	private String course;
	private String name;
	
	@ManyToMany()
	@JoinTable(name="TournamentPlayers", joinColumns=@JoinColumn(name="tournament_id"), inverseJoinColumns=@JoinColumn(name="golfer_id")) 
	private List<Golfer> players;
	
	private Date startDate;
	
	public Tournament(String course, String name, Date startDate, List<Golfer> players) {
		this.course = course;
		this.startDate = startDate;
		this.players = players;
		this.name = name;
	}
	
	
	
	public Tournament() {
		super();
	}



	public static void main(String[] args) {
		Tournament tour = new Tournament("mamma'in", "vuuu",  new Date(), null);
		
		System.out.println(tour.getCourse());
	}


	public void addPlayer(Golfer golfer) {
		if(players == null) players = new ArrayList<Golfer>();
		players.add(golfer);
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCourse() {
		return course;
	}



	public void setCourse(String course) {
		System.out.println("Setting course " + course);
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



	public void setStartDate(String startDate) {
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    Date result = null;
		try {
			result = df.parse(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("Setting startDate " + startDate.toString());
		this.startDate = result;
	}

	public Long getid() {
		return id;
	}

}
