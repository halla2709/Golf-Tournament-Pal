package project.persistence.entities;

import java.util.Date;

public class HeadOnTournament extends Tournament {

	boolean areBrackets;
	
	
	public HeadOnTournament(String course, Date startDate, int numberOfRounds, Golfer[] players) {
		super(course, startDate, numberOfRounds, players);
	}
	
	public static void main(String[] args) {
		HeadOnTournament ht = new HeadOnTournament("mammmaaaaa'in", new Date(), 4, null);
		System.out.println(ht.getCourse());
	}

	public boolean isAreBrackets() {
		return areBrackets;
	}

	public void setAreBrackets(boolean areBrackets) {
		this.areBrackets = areBrackets;
	}
}
