package project.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import project.persistence.entities.Golfer;
import project.persistence.entities.Scorecard;

public class ScoreboardCreator {

	private List<Golfer> players;
	private int numberOfRounds;
	private String course;
	
	private List<Scorecard> scorecards;
	private int[][] score;
	
	public ScoreboardCreator(List<Golfer> players, int numberOfRounds, String course){
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
	
	// raðir eru skor á leikmann, fyrri talan
	// dálkar eru skor á hring, seinni talan
	// seinasti dálkurinn er summa fyrir leikmanninn
	public int[][] createScoreBoard() {
		int[][] score = new int[players.size()][numberOfRounds+1];
		
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
	public static void main(String[] args){
		Golfer halla = new Golfer("Halla", 93939393, 4.3, "hallamammain");
		Golfer elvar = new Golfer("Elvar", 93939393, 36.0, "ilvar");
		Golfer mamma = new Golfer("begga", 93939393, 33.4, "hallamammain");
		Golfer pabbi = new Golfer("raggi", 93939393, 6.8, "ilvar");		
		Golfer hedda = new Golfer("hedda", 93939393, 12.2, "hallamammain");
		Golfer brynja = new Golfer("brynja", 93939393, 24.2, "ilvar");
		List<Golfer> unsorted = new ArrayList<>();
		unsorted.add(brynja);
		unsorted.add(elvar);
		unsorted.add(halla);
		unsorted.add(pabbi);
		unsorted.add(mamma);
		unsorted.add(hedda);
		ScoreboardCreator s = new ScoreboardCreator(unsorted, 3, "Grabbi");
		
		List<Scorecard> wow = s.createScorecards();
		int[][] scores = s.createScoreBoard();
		System.out.println(scores[0][3]);
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
