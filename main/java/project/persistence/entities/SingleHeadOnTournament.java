package project.persistence.entities;

import java.util.Date;

public class SingleHeadOnTournament extends HeadOnTournament{
	
	public SingleHeadOnTournament(String course, Date startDate, int numberOfRounds, Golfer[] players) {
		super(course, startDate, numberOfRounds, players);
	}
	
	public static void main(String[] args) {
		HeadOnTournament ht = new SingleHeadOnTournament("mammmaaaaa'in", new Date(), 4, null);
		System.out.println(ht.getCourse());
	}
}
