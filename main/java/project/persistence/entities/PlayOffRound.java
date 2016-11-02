package project.persistence.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PlayOffRound {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne()
	@JoinColumn(name="tree")
	PlayOffTree playofftree;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Match> matches;
	
	int round;

	public PlayOffRound(PlayOffTree playofftree, List<Match> matches, int round) {
		this.playofftree = playofftree;
		this.matches = matches;
		this.round = round;
	}
	
	
	
	public PlayOffRound() {
		super();
	}



	public PlayOffTree getPlayofftree() {
		return playofftree;
	}

	public void setPlayofftree(PlayOffTree playofftree) {
		this.playofftree = playofftree;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	
}
