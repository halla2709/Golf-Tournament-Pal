package project.persistence.entities;


public class PlayOffTree {

	private Match[][] match;
	
	public PlayOffTree(Match[][] match){
		this.match = match;
	}
	
	public static void main(String[] args){
		PlayOffTree playOffTree = new PlayOffTree(null);
		System.out.println(playOffTree.match);

	}

	@Override
	public String toString() {
		System.out.println("ddd");
		String s = "This playofftree has " + match.length + " matches";
		return s;
	}

	public Match[][] getMatch() {
		return match;
	}

	public void setMatch(Match[][] match) {
		this.match = match;
	}
}
