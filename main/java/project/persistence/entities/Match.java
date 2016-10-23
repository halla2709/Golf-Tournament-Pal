package project.persistence.entities;

import java.util.Date;

public class Match {
	
	private Golfer[] players;
	private String results;
	private Date date;
	
	public Match (Golfer[] players, String results, Date date){
		this.players = players;
		this.results = results;
		this.date = date;
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
}
