package project.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import project.persistence.entities.Golfer;
import project.persistence.entities.ScoreboardTournament;
import project.persistence.entities.Scorecard;
import project.service.ArrayIndexComparator;

public class ScoreboardCreator {

	private List<Golfer> players;
	private int numberOfRounds;
	private String course;
	private Date startDate;
	private List<Scorecard> scorecards;
	private int[][] score;
	
	public ScoreboardCreator(List<Golfer> players, int numberOfRounds, String course, Date startDate){
		this.players = players;
		this.numberOfRounds = numberOfRounds;
		this.course = course;
		this.setScorecards(null);
	}
	
	public List<Scorecard> createScorecards() {
		List<Scorecard> newscorecards = new ArrayList<Scorecard>();
		for(int i = 0; i <  players.size(); i++) {
			Scorecard s = new Scorecard(players.get(i), null, course, numberOfRounds);
			newscorecards.add(s);
		}
		setScorecards(newscorecards);
		System.out.println("Scorecards created");
		return newscorecards;
	}
	
	// ra�ir eru skor � leikmann, fyrri talan
	// d�lkar eru skor � hring, seinni talan
	// seinasti d�lkurinn er summa fyrir leikmanninn
	public int[][] createScoreBoard() {
		score = new int[players.size()][numberOfRounds+1];
		
		for(int i = 0; i < players.size(); i++) {
			int[] scorecardi = scorecards.get(i).getTotalForRounds();
			int total = 0;
			for(int j = 0; j <  numberOfRounds; j++) {
				score[i][j] = scorecardi[j];
				total += scorecardi[j];
			}
			score[i][numberOfRounds] = total;
		}
		
		return score;
	}
	
	public void updateStatus() {
		int[] totalscores = new int[players.size()];
		for(int i = 0; i < players.size(); i++) {
			totalscores[i] = score[i][numberOfRounds];
		}
		
		ArrayIndexComparator comparator = new ArrayIndexComparator(totalscores);
		Integer[] indexes = comparator.createIndexArray();
		Arrays.sort(indexes, comparator);
		Arrays.sort(totalscores);

		List<Golfer> newplayers = new ArrayList<Golfer>();
		int[][] newscores = new int[players.size()][numberOfRounds + 1];
		
		for(int i = 0; i < players.size(); i++) {
			newplayers.add(players.get((int) indexes[i])); 
			newscores[i] = score[(int) indexes[i]];
		}
		
		players = newplayers;
		score = newscores;
	}
	
	private int[] findMinScore() {
		int min = numberOfRounds*150;
		int location = 0;
		for(int i = 0; i < players.size(); i++) {
			if(score[i][numberOfRounds] < min) {
				min = score[i][numberOfRounds];
				location = i;
			}			
		}
		
		int[] ret = {location, min};
		return ret;
	}
	
	public ScoreboardTournament createTournament() { 
		
		scorecards = createScorecards();
		score = createScoreBoard();
		
		return new ScoreboardTournament(course, startDate, numberOfRounds, players, score);
	}
	
	public static void main(String[] args){
		Golfer halla = new Golfer("Halla", 93939393, 4.3, "hallamammain");
		Golfer elvar = new Golfer("Elvar", 93939393, 36.0, "ilvar");
		Golfer mamma = new Golfer("begga", 93939393, 33.4, "hallamammain");
		Golfer pabbi = new Golfer("raggi", 93939393, 6.8, "ilvar");		
		Golfer hedda = new Golfer("hedda", 93939393, 12.2, "hallamammain");
		Golfer brynja = new Golfer("brynja", 93939393, 24.2, "ilvar");
		List<Golfer> unsorted = new ArrayList<Golfer>();
		unsorted.add(brynja);
		unsorted.add(elvar);
		unsorted.add(halla);
		unsorted.add(pabbi);
		unsorted.add(mamma);
		unsorted.add(hedda);
		ScoreboardCreator s = new ScoreboardCreator(unsorted, 3, "Grabbi", new Date());
		
		List<Scorecard> wow = s.createScorecards();
		int[][] scores = s.createScoreBoard();
		s.updateStatus();
		
		
	}

	public List<Golfer >getPlayers() {
		return players;
	}

	public void setPlayers(List<Golfer> players) {
		this.players = players;
	}

	public int getNumberOfRounds() {
		return numberOfRounds;
	}

	public void setNumberOfRounds(int numberOfRounds) {
		this.numberOfRounds = numberOfRounds;
	}

	public List<Scorecard> getScorecards() {
		return scorecards;
	}

	public void setScorecards(List<Scorecard> scorecards) {
		this.scorecards = scorecards;
	}
}
