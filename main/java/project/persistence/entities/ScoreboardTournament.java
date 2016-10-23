package project.persistence.entities;

import java.util.Date;

public class ScoreboardTournament extends Tournament {
	
	private int[][] scores;
	
	public ScoreboardTournament(String course, Date startDate, int numberOfRounds, Golfer[] players, int[][] scores){
		super(course, startDate, numberOfRounds, players);
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

}
