	package project.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Bracket") 
public class Bracket {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Match[] match;
	
	@ManyToMany()
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

	@ManyToMany(cascade=CascadeType.ALL)  
	@JoinTable(name="BracketPlayer", joinColumns=@JoinColumn(name="bracket_id"), inverseJoinColumns=@JoinColumn(name="golfer_id")) 
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