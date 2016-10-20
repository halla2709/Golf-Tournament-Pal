package project.persistence.entities;

public class ScoreboardCreator {

	Golfer[] players;
	
	public ScoreboardCreator(Golfer[] players){
		this.players = players;
	}
	
	public static void main (String[] args){
		ScoreboardCreator scoreboardCreator = new ScoreboardCreator(null);
		System.out.println(scoreboardCreator.players);
	}
}
