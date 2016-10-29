package project.persistence.entities;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Match") 
public class Match {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Golfer[] players;
	private String results;
	private Date date;
	
	public Match (Golfer[] players, String results, Date date){
		this.players = players;
		this.results = results;
		this.date = date;
	}
	
	public Match() { 
		players = null;
		results = null;
		date = null;
	}
	
	public static void main(String[] args){
		Match match = new Match(null, "Halla", new Date());
		System.out.println(match.results);
	}

	public Golfer[] getPlayers() {
		return players;
	}

	public void setPlayers(Golfer[] players) {
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

	@Override
	public String toString() {
		return "Match [players=" + Arrays.toString(players) + ", results=" + results + ", date=" + date + "]";
	}
}
