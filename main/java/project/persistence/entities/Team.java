package project.persistence.entities;

public class Team{
	
	private String teamName;
	private double handicap;
	private Golfer[] players;
	
	public Team (String teamName, double handicap, Golfer[] players){
		this.teamName = teamName;
		this.handicap = handicap;
		this.players = players;
	}
	
	public static void main(String [] args){
		Team team = new Team ("mammaíín", 20.6, null);
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

	public Golfer[] getPlayers() {
		return players;
	}

	public void setPlayers(Golfer[] players) {
		this.players = players;
	}
	
	
	

}
