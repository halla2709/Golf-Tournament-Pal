package project.controller;

import java.util.Arrays;
import java.util.Date;

import project.persistence.entities.Bracket;
import project.persistence.entities.Golfer;
import project.persistence.entities.HeadOnTournament;
import project.persistence.entities.Match;
import project.persistence.entities.PlayOffTree;

public class HeadOnCreator {
	
	private boolean areBrackets;
	private Golfer[] players;
	private Golfer[] sorted;
	private int numInBracket;
	private int numOfBrackets;
	private int numOutOfBrackets;
	
	public HeadOnCreator(boolean areBrackets, Golfer[] players, int numInBracket, int numOutOfBrackets){
		this.areBrackets = areBrackets;
		this.players = players;
		numOfBrackets = 0;
		if(areBrackets) this.numInBracket = numInBracket;
		else numInBracket = 0;
		if(areBrackets) this.numOutOfBrackets = numOutOfBrackets;
		else numOutOfBrackets = 0;
		sorted = sortByHandicap(players);
	}
	
	public static void main(String[] args){
		
		Golfer halla = new Golfer("Halla", 93939393, 4.3, "hallamammain");
		Golfer elvar = new Golfer("Elvar", 93939393, 36.0, "ilvar");
		Golfer mamma = new Golfer("begga", 93939393, 33.4, "hallamammain");
		Golfer pabbi = new Golfer("raggi", 93939393, 6.8, "ilvar");		
		Golfer hedda = new Golfer("hedda", 93939393, 12.2, "hallamammain");
		Golfer brynja = new Golfer("brynja", 93939393, 24.2, "ilvar");
		Golfer[] unsorted = {mamma, halla, elvar, pabbi};
		HeadOnCreator headOnCreator = new HeadOnCreator(false, unsorted, 3, 2);
		
		HeadOnTournament tournament = headOnCreator.createTournament();
		System.out.println(tournament.getPlayOffs());
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
			// Mega ekki vera f�rri en 2 ri�lar og fj�ldi leikmanna ver�ur a� ganga upp � ri�lana
			if(numOfBrackets < 2 || numOfBrackets != dNumOfBrackets) return false;
			// Fj�ldi ri�la ver�ur a� vera veldi af 2.
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
	
	private Bracket[] createBracket() {
		Bracket[] brackets = new Bracket[(int) numOfBrackets];
		for(int i = 0; i < numOfBrackets; i++) {
			// Ri�illinn hefur enn enga leikmenn en f�r nafni� b0, b1,.. osfrv
			brackets[i] = new Bracket(null, "b" + i);
			for(int j = i; j < sorted.length; j = j+2*numOfBrackets) {
				/* Eftir a� ra�a� er eftir forgj�f inniheldur sorted
				 * [0,1,2,3,4,...,n-2,n-1]
				 * Viljum a� ra�a� s� svona � ri�lana:
				 *		b0 	 b1  ... bm
				 *		0  	  1      m
				 *		2m-1	    m+1
				 * 		2m 	...
				 * 		...			n-1	
				 */
				brackets[i].addPlayer(sorted[j]);
				if(j+2*numOfBrackets-1-i < sorted.length)
					brackets[i].addPlayer(sorted[j+2*numOfBrackets-1-i]);
			}
		}
		return brackets;
	}

	private PlayOffTree createPlayOffTree(int numIn) {
		int numOfMatches = numIn/2;
		/*
		 * 	umferdir >
		 * 	leikir		0	1	2	3	...
		 *   ||		0
		 *   \/		1
		 *   		2
		 *   		...
		 *   numOfMatches er fj�ldi leikja � fyrstu umfer�
		 *   changeToBase2(numIn) er fj�ldi umfer�a �.e. log2(fj�ldi leikmanna � fyrstu umfer�)
		 */
		
		Match[][] emptyMatches = new Match[numOfMatches][(int) changeToBase2(numIn)];
		
		// Ef �etta er ekki ri�lam�t �� er h�gt a� stilla upp fyrstu umfer�inni
		if(!areBrackets) {
			for(int i = 0; i < numOfMatches; i++) {
				// R��um � umfer�ina eftir forgj�f.
				Golfer[] playersInMatch = {sorted[i], sorted[sorted.length-1-i]};
				for(int j = 0; j < emptyMatches[0].length; j++) {
					emptyMatches[i][j] = new Match();
				}
				emptyMatches[i][0].setPlayers(playersInMatch);
			}
		}
		
		
		return new PlayOffTree(emptyMatches);
		
	}
	
	public HeadOnTournament createTournament() {
		// Tjekkum hvort vi� getum sett m�ti� upp
		if(!playerNumberValidator()) return null;
		
		Bracket[] brackets = null;
		PlayOffTree playoffs = null;
		int numInPlayoffs = players.length;
		
		// B�um til ri�la ef �eir eiga a� vera. 
		// Fj�ldi � �tsl�ttarkeppni fer �� eftir �v�
		// hve margir komast upp �r ri�lunum.
		if(areBrackets) {
			brackets = createBracket();
			numInPlayoffs = numOutOfBrackets*brackets.length;
		}
		
		// B�um til �tsl�ttatr��
		playoffs = createPlayOffTree(numInPlayoffs);
		
		
		return new HeadOnTournament(getCourse(), getStartDate(), players, areBrackets, brackets, playoffs);
		
	}
	

	public boolean saveTournament(HeadOnTournament tournament) {
		// Tenging vi� gagnagrunn.
		return true;
	}
	
	public void displayTournament(HeadOnTournament tournament) {
		
	}
	
	private String getCourse() {
		// get info from view
		return null;
	}
	
	private Date getStartDate() {
		// get info from view
		return null;
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
