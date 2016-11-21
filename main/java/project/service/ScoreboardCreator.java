package project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.persistence.entities.Golfer;
import project.persistence.entities.ScoreboardTournament;
import project.persistence.entities.Scorecard;

public class ScoreboardCreator {

	private List<Golfer> players;
	private int numberOfRounds;
	private String course;
	private String name;
	private Date startDate;
	private List<Scorecard> scorecards;
	private int[][] score;
	
	public ScoreboardCreator(List<Golfer> players, int numberOfRounds, String course, String name, Date startDate){
		this.players = players;
		this.numberOfRounds = numberOfRounds;
		this.course = course;
		this.name = name;
		this.scorecards = null;
	}
	
	public void createScorecards() {
		List<Scorecard> newscorecards = new ArrayList<Scorecard>();
		for(int i = 0; i <  players.size(); i++) {
			Scorecard s = new Scorecard(players.get(i), null, course, numberOfRounds);
			newscorecards.add(s);
		}
		setScorecards(newscorecards);
		System.out.println("Scorecards created");
	}
	
	// ra�ir eru skor � leikmann, fyrri talan
	// d�lkar eru skor � hring, seinni talan
	// seinasti d�lkurinn er summa fyrir leikmanninn
	public void createScoreboard() {
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
		
	}
	
	public ScoreboardTournament createTournament() { 
		
		createScorecards();
		createScoreboard();
		
		return new ScoreboardTournament(course, name, startDate, numberOfRounds, players, scorecards, score);
	}
	
	public static void main(String[] args){
		Golfer halla = new Golfer("Halla", 888, 4.3, "hallamammain");
		Golfer elvar = new Golfer("Elvar", 222, 36.0, "ilvar");
		Golfer mamma = new Golfer("begga", 111, 33.4, "hallamammain");
		Golfer pabbi = new Golfer("raggi", 444, 6.8, "ilvar");		
		Golfer hedda = new Golfer("hedda", 333, 12.2, "hallamammain");
		Golfer brynja = new Golfer("brynja", 555, 24.2, "ilvar");
		List<Golfer> unsorted = new ArrayList<Golfer>();
		unsorted.add(brynja);
		unsorted.add(elvar);
		unsorted.add(halla);
		unsorted.add(pabbi);
		unsorted.add(mamma);
		unsorted.add(hedda);
		ScoreboardCreator s = new ScoreboardCreator(unsorted, 3, "Grabbi", "BESTAMOTID", new Date());
		
		ScoreboardTournament tournament = s.createTournament();
		ScoreboardUpdater updater = new ScoreboardUpdater(tournament);
		
		for(int i = 0; i < tournament.getScores().length; i++) {
			System.out.print(tournament.getPlayers().get(i).getName());
			for(int j = 0; j < tournament.getScores()[i].length; j++) {
				System.out.print("  " + tournament.getScores()[i][j]);
			}
			System.out.println();
		}
		
		int[] roundscores = {2,3,4,5,4,3,2,3,4,5,4,3,2,3,4,5,6,5};
		tournament = updater.addScoresForRounds(888, roundscores, 0);
		
		for(int i = 0; i < tournament.getScores().length; i++) {
			System.out.print(tournament.getPlayers().get(i).getName());
			for(int j = 0; j < tournament.getScores()[i].length; j++) {
				System.out.print("  " + tournament.getScores()[i][j]);
			}
			System.out.println();
		}
		
		int[] roundscores2 = {2,3,4,5,4,3,4,3,4,5,4,3,6,3,4,5,6,5};
		tournament = updater.addScoresForRounds(222, roundscores2, 0);
		
		for(int i = 0; i < tournament.getScores().length; i++) {
			System.out.print(tournament.getPlayers().get(i).getName());
			for(int j = 0; j < tournament.getScores()[i].length; j++) {
				System.out.print("  " + tournament.getScores()[i][j]);
			}
			System.out.println();
		}
		
		int[] roundscores3 = {2,3,4,5,4,3,4,3,4,5,4,3,6,3,4,5,6,5};
		tournament = updater.addScoresForRounds(888, roundscores3, 1);
		
		for(int i = 0; i < tournament.getScores().length; i++) {
			System.out.print(tournament.getPlayers().get(i).getName());
			for(int j = 0; j < tournament.getScores()[i].length; j++) {
				System.out.print("  " + tournament.getScores()[i][j]);
			}
			System.out.println();
		}
		
		ScoreboardUpdater updater2 = new ScoreboardUpdater(tournament);
		
		int[] roundscores4 = {2,3,4,5,4,3,4,2,4,5,4,3,6,3,4,5,2,2};
		tournament = updater2.addScoresForRounds(555, roundscores4, 0);
		
		for(int i = 0; i < tournament.getScores().length; i++) {
			System.out.print(tournament.getPlayers().get(i).getName());
			for(int j = 0; j < tournament.getScores()[i].length; j++) {
				System.out.print("  " + tournament.getScores()[i][j]);
			}
			System.out.println();
		}
		
		
		
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

