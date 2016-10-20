package project.persistence.entities;

import java.util.Date;

public class SingleHeadOn extends HeadOnTournament{
	
	public SingleHeadOn(String course, Date startDate, int numberOfRounds, Golfer[] players) {
		super(course, startDate, numberOfRounds, players);
	}
	
	public static void main(String[] args) {
		HeadOnTournament ht = new SingleHeadOn("mammmaaaaa'in", new Date(), 4, null);
		System.out.println(ht.getCourse());
	}
}
