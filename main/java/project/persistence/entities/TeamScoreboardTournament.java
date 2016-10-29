package project.persistence.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TeamScoreboardTournament") 
public class TeamScoreboardTournament extends ScoreboardTournament{

	private Team[] team;
	
	public TeamScoreboardTournament(String course, Date startDate, int numberOfRounds, Golfer[] players, 
			int[][] scores, Team[] team){
		super(course, startDate, numberOfRounds, players, scores);
	}
	
	public static void main(String[] args){
		TeamScoreboardTournament teamScoreboardTournament = new TeamScoreboardTournament("kalli", new Date(), 6,
				null, null, null);
		System.out.println(teamScoreboardTournament.getCourse());
	}

	public Team[] getTeam() {
		return team;
	}

	public void setTeam(Team[] team) {
		this.team = team;
	}

}
