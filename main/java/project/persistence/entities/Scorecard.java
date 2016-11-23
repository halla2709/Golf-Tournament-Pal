package project.persistence.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Scorecard") 
public class Scorecard {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Round> rounds;
    
    public List<Round> getRounds() {
		return rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}

	@ManyToOne()
    @JoinColumn(name="player")
	private Golfer player;
	
    @ManyToOne()
    @JoinColumn(name="team")
	private Team team;
    
    private String course;
    
	private int numberOfRounds;

	public Scorecard(Golfer player, Team team, String course, int numberOfRounds){
		this.player = player;
		this.team = team;
		this.numberOfRounds = numberOfRounds;
		this.course = course;
		rounds = new ArrayList<Round>();
		for(int i = 0; i < numberOfRounds; i++) {
			rounds.add(new Round());
		}
	}
		
	public Scorecard() {
		super();
	}

	public int[] getTotalForRounds() { 
		int[] totals = new int[numberOfRounds];
		for(int i = 0; i < numberOfRounds; i++) {
			totals[i] = rounds.get(i).getTotal();
		}
		return totals;
	}
	
	public static void main(String[] args){
		Scorecard scorecard = new Scorecard(null, null, "Grabbi", 3);
	}

	public Golfer getPlayer() {
		return player;
	}

	public void setPlayer(Golfer player) {
		this.player = player;
	}

	public int getNumberOfRounds() {
		return numberOfRounds;
	}

	public void setNumberOfRounds(int numberOfRounds) {
		this.numberOfRounds = numberOfRounds;
	}
	
	public void setRound(int roundNumber, int[] scores) {
		rounds.get(roundNumber).setScore(scores);
	}

}
