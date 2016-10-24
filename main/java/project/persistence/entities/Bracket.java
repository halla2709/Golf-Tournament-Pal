	package project.persistence.entities;

import java.util.ArrayList;
import java.util.List;

public class Bracket {
	
	private Match[] match;
	private List<Golfer> players;
	private String name;
	
	public Bracket(List<Golfer> players, String name){
		if(players == null) this.players = new ArrayList<Golfer>();
		else this.players = players;
		this.name = name;
	}
	
	public static void main(String[] args){
		Bracket bracket = new Bracket(null, "Halla");
		System.out.println(bracket);
	}

	public Match[] getMatch() {
		return match;
	}

	public void setMatch(Match[] match) {
		this.match = match;
	}

	public Golfer[] getPlayers() {
		return (Golfer[]) players.toArray();
	}

	public void setPlayers(Golfer[] players) {
		for(int i = 0; i <  players.length; i++){
			this.players.add(players[i]);
		}
		
	}

	public void addPlayer(Golfer player) {
		this.players.add(player);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		String s = "Bracket: " + getName();
		if (players == null) {
			s = s + "\n" + "This bracket has no players.";
			return s;
		}
		s = s + "\n" + "This bracket has players: ";
		
		for(int i = 0; i < players.size(); i++) {
			s = s + "\n" + players.get(i).getName();
		}
		return s;
	}

}
