package project.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import project.persistence.entities.Bracket;
import project.persistence.entities.Golfer;
import project.persistence.entities.MatchPlayTournament;
import project.persistence.entities.Match;
import project.persistence.entities.PlayOffRound;
import project.persistence.entities.PlayOffTree;

public class MatchPlayCreator {
	
	private boolean areBrackets;
	private List<Golfer> players;
	private int numInBracket;
	private int numOfBrackets;
	private int numOutOfBrackets;
	
	public MatchPlayCreator(boolean areBrackets, List<Golfer> players, int numInBracket, int numOutOfBrackets) {
		this.areBrackets = areBrackets;
		this.players = players;
		numOfBrackets = 0;
		if(areBrackets) this.numInBracket = numInBracket;
		else numInBracket = 0;
		if(areBrackets) this.numOutOfBrackets = numOutOfBrackets;
		else numOutOfBrackets = 0;
		sortByHandicap(players);
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
		MatchPlayCreator headOnCreator = new MatchPlayCreator(true, unsorted, 3, 2);
		
		
		System.out.println(headOnCreator.numOfBrackets);
	}

	private void sortByHandicap(List<Golfer> unsorted) {
		Collections.sort(unsorted);
	}
	
	private double changeToBase2(int input) { 
		return Math.log(input)/Math.log(2);
	}
	
	/**
	 * Fj�ldi leikmanna �arf a� ganga upp � fj�ldi ri�la ef �a� eiga a� vera ri�lar.
	 * Einnig �arf fj�ldi ri�la a� vera veldi af tveimur. Ef �a� eru ekki ri�lar �arf
	 * fj�ldi leikmanna a� vera veldi af tveimur.
	 * @return true ef fj�ldinn passar, false annars.
	 */
	public boolean playerNumberValidator() {
		int playerNumber = players.size();
		
		if(areBrackets) {
			if(playerNumber < numInBracket) return false;
			double dNumOfBrackets = playerNumber/numInBracket;
			numOfBrackets = (int) Math.floor(dNumOfBrackets);
			// Mega ekki vera faerri en 2 ridlar og fjoldi leikmanna verdur ad ganga upp i ridlana
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
			for(int j = i; j < players.size(); j = j+2*numOfBrackets) {
				/* Eftir a� ra�a� er eftir forgj�f inniheldur players
				 * [0,1,2,3,4,...,n-2,n-1]
				 * Viljum a� ra�a� s� svona � ri�lana:
				 *		b0 	 b1  ... bm
				 *		0  	  1      m
				 *		2m-1	    m+1
				 * 		2m 	...
				 * 		...			n-1	
				 * 
				 *   T.d. ef sorted = {1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16} sem � a� ra�a � 4 ri�la �� ra�ast �a� svona
				 *   		b1		b2		b3		b4
				 *   		1		2		3		4
				 *   		8		7		6		5
				 *   		9		10		11		12
				 *   		16		15		14		13
				 */
				brackets[i].addPlayer(players.get(j));
				if(j+2*numOfBrackets-1-i < players.size())
					brackets[i].addPlayer(players.get(j+2*numOfBrackets-1-i));
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
		 *   
		 */
		
		
		List<PlayOffRound> rounds = new ArrayList<PlayOffRound>((int) changeToBase2(numIn));
		// Ef �etta er ekki ri�lam�t �� er h�gt a� stilla upp fyrstu umfer�inni
		if(!areBrackets) {
			List<Match> emptyMatches = new ArrayList<Match>(numOfMatches);
			for(int i = 0; i < numOfMatches; i++) {
				// R��um � umfer�ina eftir forgj�f.
				List<Golfer> playersInMatch = new ArrayList<Golfer>();
				playersInMatch.add(players.get(i));
				playersInMatch.add(players.get(players.size()-1-i));
				
				emptyMatches.add(i, new Match());
				emptyMatches.get(i).setPlayers(playersInMatch);
			}
			PlayOffRound p = new PlayOffRound(emptyMatches, 1);
			rounds.add(p);
		}
		
		return new PlayOffTree(rounds);
		
	}
	
	public MatchPlayTournament createTournament(String course, String name, Date startDate) {
		// Tjekkum hvort vi� getum sett m�ti� upp
		if(!playerNumberValidator()) return null;
		
		List<Bracket> brackets = new ArrayList<Bracket>();
		PlayOffTree playoffs = null;
		int numInPlayoffs = players.size();
		
		// B�um til ri�la ef �eir eiga a� vera. 
		// Fj�ldi � �tsl�ttarkeppni fer �� eftir �v�
		// hve margir komast upp �r ri�lunum.
		if(areBrackets) {
			brackets = Arrays.asList(createBracket());
			numInPlayoffs = numOutOfBrackets*brackets.size();
		}
		
		// B�um til �tsl�ttatr��
		playoffs = createPlayOffTree(numInPlayoffs);
		
		return new MatchPlayTournament(course, name, startDate, players, areBrackets, brackets, playoffs);
	}
	

	public boolean saveTournament(MatchPlayTournament tournament) {
		// Tenging vi� gagnagrunn
		return true;
	}
	
	public void displayTournament(MatchPlayTournament tournament) {
		
	}
		
	public boolean areBrackets() {
		return areBrackets;
	}

	public void setAreBrackets(boolean areBrackets) {
		this.areBrackets = areBrackets;
	}

	public List<Golfer> getPlayers() {
		return players;
	}

	public void setPlayers(List<Golfer> players) {
		this.players = players;
	}

	public int getNumInBracket() {
		return numInBracket;
	}

	public void setNumInBracket(int numInBracket) {
		this.numInBracket = numInBracket;
	}

}