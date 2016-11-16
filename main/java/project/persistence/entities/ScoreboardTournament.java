package project.persistence.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ScoreboardTournament") 
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TeamTournament")
public class ScoreboardTournament extends Tournament {

	@Transient()
	private int[][] scores;
	
	private int numberOfRounds;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Scorecard> scorecards;
	
	public ScoreboardTournament(String course, String name, Date startDate, int numberOfRounds, List<Golfer> players, int[][] scores){
		super(course, name, startDate, players);
		this.setNumberOfRounds(numberOfRounds);
	}
	
	public ScoreboardTournament(String course, String name, Date startDate, List<Golfer> players) {
		super(course, name, startDate, players);
	}
	
	public ScoreboardTournament() { 
		this.setPlayers(new ArrayList<Golfer>());
		scores = null;
	}

	public static void main(String[] args){
		ScoreboardTournament scoreboardTournament = new ScoreboardTournament("vннн", "vuuuu", new Date(), 5, null, null);
		System.out.println(scoreboardTournament.getCourse());
	}

	public int[][] getScores() {
		return scores;
	}

	public void setScores(int[][] scores) {
		this.scores = scores;
	}

	public int getNumberOfRounds() {
		return numberOfRounds;
	}

	public void setNumberOfRounds(int numberOfRounds) {
		System.out.println("Setting numberOfRounds " + numberOfRounds);
		this.numberOfRounds = numberOfRounds;
	}

}
