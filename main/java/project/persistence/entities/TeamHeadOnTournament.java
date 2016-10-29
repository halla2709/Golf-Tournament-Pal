package project.persistence.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TeamHeadOnTournament") 
public class TeamHeadOnTournament extends HeadOnTournament {

	private Team[] teams;
	
	public TeamHeadOnTournament(String course, Date startDate, int numberOfRounds, Golfer[] players, 
			boolean areBrackets, Bracket[] brackets, PlayOffTree playOffs) {
		super(course, startDate, players, areBrackets, brackets, playOffs);
	}
	
	public static void main(String[] args){
		TeamHeadOnTournament teamHeadOnTournament = new TeamHeadOnTournament("Flottasti völlurinn", new Date(), 3,
				null, true, null, null);
		System.out.println(teamHeadOnTournament.getCourse());
	}

	public Team[] getTeams() {
		return teams;
	}

	public void setTeams(Team[] teams) {
		this.teams = teams;
	}
	
	
}
