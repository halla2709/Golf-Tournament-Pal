package project.persistence.entities;

public class ScoreboardTournament {

	int[][] scores;
	
	public ScoreboardTournament(int[][] scores){
		this.scores = scores;
	}
	
	public static void main (String[] args){
		ScoreboardTournament scoreboardTournament = new ScoreboardTournament(null);
		System.out.println(scoreboardTournament.scores);
	}
}
