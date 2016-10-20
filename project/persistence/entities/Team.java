package project.persistence.entities;

public class Team{
	
	String teamName;
	double handicap;
	Golfer[] players;
	
	public Team (String teamName, double handicap, Golfer[] players){
		this.teamName = teamName;
		this.handicap = handicap;
		this.players = players;
	}
	
	public static void main(String [] args){
		Team team = new Team ("mammaíín", 20.6, null);
		System.out.println(team.teamName);
	}
	
	
	

}
