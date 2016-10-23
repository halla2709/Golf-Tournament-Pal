package project.persistence.entities;

public class Bracket {
	
	Match[] match;
	Golfer[] players;
	String name;
	
	public Bracket(Match[] match, Golfer[] players, String name){
		this.match = match;
		this.players = players;
		this.name = name;
	}
	
	public static void main(String[] args){
		Bracket bracket = new Bracket(null, null, "Halla");
		System.out.println(bracket.name);
	}

	public Match[] getMatch() {
		return match;
	}

	public void setMatch(Match[] match) {
		this.match = match;
	}

	public Golfer[] getPlayers() {
		return players;
	}

	public void setPlayers(Golfer[] players) {
		this.players = players;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
