package project.persistence.entities;

public class PlayOffTree {
	
	Match[][] match;
	
	public PlayOffTree(Match[][] match){
		this.match = match;
	}
	
	public static void main(String[] args){
		PlayOffTree playOffTree = new PlayOffTree(null);
		System.out.println(playOffTree.match);
	}

}
