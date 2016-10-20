package project.persistence.entities;

import java.util.Date;

public class TeamHeadOnTournament extends HeadOnTournament {

	Team[] teams;
	
	public TeamHeadOnTournament(String course, Date startDate, int numberOfRounds, Golfer[] players) {
		super(course, startDate, numberOfRounds, players);
	}

	public Team[] getTeams() {
		return teams;
	}

	public void setTeams(Team[] teams) {
		this.teams = teams;
	}
	
	
}