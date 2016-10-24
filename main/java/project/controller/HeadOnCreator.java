package project.controller;

import java.util.Arrays;

import project.persistence.entities.Bracket;
import project.persistence.entities.Golfer;
import project.persistence.entities.HeadOnTournament;
import project.persistence.entities.PlayOffTree;

public class HeadOnCreator {
	
	private boolean areBrackets;
	private Golfer[] players;
	private int numInBracket;
	private int numOfBrackets;
	
	public HeadOnCreator(boolean areBrackets, Golfer[] players, int numInBracket){
		this.areBrackets = areBrackets;
		this.players = players;
		numOfBrackets = 0;
		if(areBrackets) this.numInBracket = numInBracket;
		else numInBracket = 0;
	}
	
	public static void main(String[] args){
		
		Golfer halla = new Golfer("Halla", 93939393, 4.3, "hallamammain");
		Golfer elvar = new Golfer("Elvar", 93939393, 36.0, "ilvar");
		Golfer mamma = new Golfer("begga", 93939393, 33.4, "hallamammain");
		Golfer pabbi = new Golfer("raggi", 93939393, 6.8, "ilvar");		
		Golfer hedda = new Golfer("hedda", 93939393, 12.2, "hallamammain");
		Golfer brynja = new Golfer("brynja", 93939393, 24.2, "ilvar");
		Golfer[] unsorted = {mamma, halla, elvar, pabbi, hedda, brynja};
		HeadOnCreator headOnCreator = new HeadOnCreator(true, unsorted, 3);
		
		System.out.println(headOnCreator.playerNumberValidator());
		Bracket[] brackets = headOnCreator.createBracket();
		for(int i = 0; i < brackets.length; i++) {
			System.out.println(brackets[i]);
		}
	}

	private Golfer[] sortByHandicap(Golfer[] unsorted) {
		Arrays.sort(unsorted);
		return unsorted;
	}
	
	private double changeToBase2(int input) { 
		return Math.log(input)/Math.log(2);
	}
	
	private boolean playerNumberValidator() {
		int playerNumber = players.length;
		
		if(areBrackets) {
			double dNumOfBrackets = playerNumber/numInBracket;
			numOfBrackets = (int) Math.floor(dNumOfBrackets);
			// Mega ekki vera færri en 2 riðlar og fjöldi leikmanna verður að ganga upp í riðlana
			if(numOfBrackets < 2 || numOfBrackets != dNumOfBrackets) return false;
			// Fjöldi riðla verður að vera veldi af 2.
			else if(Math.floor(changeToBase2(numOfBrackets)) == changeToBase2(numOfBrackets)) return true;
			else return false;
			
		}
		
		else {
			if(Math.floor(changeToBase2(playerNumber)) == changeToBase2(playerNumber)) {
				return true;
			}
			else return false;
		}
		
	}
	
	public Bracket[] createBracket() {
		if(!playerNumberValidator()) return null;
		if(!areBrackets) return null;
		else {
			Golfer[] sorted = sortByHandicap(players);
			Bracket[] brackets = new Bracket[(int) numOfBrackets];
			for(int i = 0; i < numOfBrackets; i++) {
				brackets[i] = new Bracket(null, "b" + i);
				for(int j = i; j < sorted.length; j = j+2*numOfBrackets) {
					brackets[i].addPlayer(sorted[j]);
					if(j+2*numOfBrackets-1-i < sorted.length)
						brackets[i].addPlayer(sorted[j+2*numOfBrackets-1-i]);
				}
			}
			return brackets;
		}
	}

	public PlayOffTree createPlayOffTree() {
		return null;
	}
	
	public HeadOnTournament createTournament() {
		return null;
	}
	
	public boolean saveTournament(HeadOnTournament tournament) {
		return true;
	}
	
	public void displayTournament(HeadOnTournament tournament) {
		
	}
	
	public boolean areBrackets() {
		return areBrackets;
	}

	public void setAreBrackets(boolean areBrackets) {
		this.areBrackets = areBrackets;
	}

	public Golfer[] getPlayers() {
		return players;
	}

	public void setPlayers(Golfer[] players) {
		this.players = players;
	}

	public int getNumInBracket() {
		return numInBracket;
	}

	public void setNumInBracket(int numInBracket) {
		this.numInBracket = numInBracket;
	}

}
