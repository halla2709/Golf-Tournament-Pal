package project.persistence.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "ScoreboardTournament") 
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TeamTournament")
public class ScoreboardTournament extends Tournament {

	private int[][] scores;
	private int numberOfRounds;
	
	public ScoreboardTournament(String course, Date startDate, int numberOfRounds, List<Golfer> players, int[][] scores){
		super(course, startDate, players);
		this.setNumberOfRounds(numberOfRounds);
	}
	
	
	
	public ScoreboardTournament(String course, Date startDate, List<Golfer> players) {
		super(course, startDate, players);
	}



	public static void main(String[] args){
		ScoreboardTournament scoreboardTournament = new ScoreboardTournament("vннн", new Date(), 5, null, null);
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
		this.numberOfRounds = numberOfRounds;
	}

}
