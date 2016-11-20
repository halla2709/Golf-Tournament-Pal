package project.persistence.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TeamScoreboardTournament") 
@DiscriminatorValue("Team")
public class TeamScoreboardTournament extends ScoreboardTournament{

	@OneToMany(cascade = CascadeType.ALL)
	private List<Team> team;
	
	public TeamScoreboardTournament(String course, String name, Date startDate, int numberOfRounds, List<Golfer> players, List<Scorecard> scorecards,
			int[][] scores, Team[] team){
		super(course, name,  startDate, numberOfRounds, players, scorecards, scores);
	}
	


	public static void main(String[] args){
		TeamScoreboardTournament teamScoreboardTournament = new TeamScoreboardTournament("kalli", "vuuu", new Date(), 6,
				null, null, null, null);
		System.out.println(teamScoreboardTournament.getCourse());
	}

	public List<Team> getTeam() {
		return team;
	}

	public void setTeam(List<Team> team) {
		this.team = team;
	}

}
