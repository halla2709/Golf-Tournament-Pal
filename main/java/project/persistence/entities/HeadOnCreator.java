package project.persistence.entities;

public class HeadOnCreator {
	
	private boolean areBrackets;
	private Golfer[] players;
	
	public HeadOnCreator(boolean areBrackets, Golfer[] players){
		this.areBrackets = areBrackets;
		this.players = players;
	}
	
	public static void main(String[] args){
		HeadOnCreator headOnCreator = new HeadOnCreator(true, null);
		System.out.println(headOnCreator.areBrackets);
	}

	public boolean isAreBrackets() {
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

}
