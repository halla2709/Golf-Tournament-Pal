package project.persistence.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Team") 
public class Team{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String teamName;
	private double handicap;
	
	@ManyToOne()
	@JoinColumn(name="team")
	private Tournament tournament;
	
	@ManyToMany()
    @JoinTable(name="TeamPlayer", joinColumns=@JoinColumn(name="team_id"), inverseJoinColumns=@JoinColumn(name="golfer_id")) 
	private List<Golfer> players;
	
	public Team (String teamName, double handicap, List<Golfer> players, Tournament tournament){
		this.teamName = teamName;
		this.handicap = handicap;
		this.players = players;
		this.tournament = tournament;
	}
	
	public static void main(String [] args){
		Team team = new Team ("mammaíín", 20.6, null, null);
		System.out.println(team.teamName);
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public double getHandicap() {
		return handicap;
	}

	public void setHandicap(double handicap) {
		this.handicap = handicap;
	}

	public List<Golfer> getPlayers() {
		return players;
	}

	public void setPlayers(List<Golfer> players) {
		this.players = players;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	
	
	

}
