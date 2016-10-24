package project.controller;

import project.persistence.entities.Golfer;

public class ScoreboardCreator {

	private Golfer[] players;
	private int numberOfRounds;
	
	public ScoreboardCreator(Golfer[] players, int numberOfRounds){
		this.players = players;
		this.numberOfRounds = numberOfRounds;
	}
	
	public static void main(String[] args){
		ScoreboardCreator scoreboardCreator = new ScoreboardCreator(null, 3);
		System.out.println(scoreboardCreator.numberOfRounds);
	}

	public Golfer[] getPlayers() {
		return players;
	}

	public void setPlayers(Golfer[] players) {
		this.players = players;
	}

	public int getNumberOfRounds() {
		return numberOfRounds;
	}

	public void setNumberOfRounds(int numberOfRounds) {
		this.numberOfRounds = numberOfRounds;
	}
}
