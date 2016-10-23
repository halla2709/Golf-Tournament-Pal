package project.persistence.entities;

public class Scorecard {
	
	private Golfer[] player;
	private String teamName;
	private int numberOfRounds;
	private int[][] roundScores;

	public Scorecard(Golfer[] player, String teamName, int numberOfRounds, int[][] roundScores){
		this.player = player;
		this.teamName = teamName;
		this.numberOfRounds = numberOfRounds;
		this.roundScores = roundScores;
	}
		
	public static void main(String[] args){
		Scorecard scorecard = new Scorecard(null, "The Best Team", 3, null);
		System.out.println(scorecard.teamName);
	}

	public Golfer[] getPlayer() {
		return player;
	}

	public void setPlayer(Golfer[] player) {
		this.player = player;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getNumberOfRounds() {
		return numberOfRounds;
	}

	public void setNumberOfRounds(int numberOfRounds) {
		this.numberOfRounds = numberOfRounds;
	}

	public int[][] getRoundScores() {
		return roundScores;
	}

	public void setRoundScores(int[][] roundScores) {
		this.roundScores = roundScores;
	}
}
