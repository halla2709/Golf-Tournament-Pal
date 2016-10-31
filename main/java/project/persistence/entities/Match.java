package project.persistence.entities;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Match") 
public class Match {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="MatchPlayer", joinColumns=@JoinColumn(name="match_id"), inverseJoinColumns=@JoinColumn(name="golfer_id")) 
	private List<Golfer> players;
	private String results;
	private Date date;
	
	@ManyToOne()
	@JoinColumn(name="playoffs")
	private PlayOffRound round;
	
	@ManyToOne()
	@JoinColumn(name="bracket")
	private Bracket bracket;
	
	public Match () { 
		this.players = null;
		this.results = null;
		this.date = null;
		this.bracket = null;
		this.round = null;
	}
	
	public Match (List<Golfer> players, String results, Date date, Bracket bracket, PlayOffRound round){
		this.players = players;
		this.results = results;
		this.date = date;
		this.bracket = bracket;
		this.round = round;
	}
	
	public static void main(String[] args){
		Match  match = new Match (null, "Halla", new Date(), null, null);
		System.out.println(match.results);
	}

	public List<Golfer> getPlayers() {
		return players;
	}

	public void setPlayers(List<Golfer> players) {
		this.players = players;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

//	@Override
//	public String toString() {
//		return "Match [players=" + Arrays.toString(players) + ", results=" + results + ", date=" + date + "]";
//	}

	public Bracket getBracket() {
		return bracket;
	}

	public void setBracket(Bracket bracket) {
		this.bracket = bracket;
	}
}
