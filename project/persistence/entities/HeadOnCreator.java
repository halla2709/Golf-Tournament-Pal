package project.persistence.entities;

public class HeadOnCreator {

	boolean areBrackets;
	Golfer [] players;
	
	public HeadOnCreator(boolean areBrackets, Golfer[] players){
		this.areBrackets = areBrackets;
		this.players = players;
	}
	
	public static void main (String[] args){
		HeadOnCreator headOnCreator = new HeadOnCreator(false, null);
		System.out.println(headOnCreator.areBrackets);
	}
	
}
