package project.persistence.entities;

public class HeadOnTournament {
	
	boolean areBrackets;
	Bracket[] brackets;
	PlayOffTree playOffs;
	
	public HeadOnTournament(boolean areBrackets, Bracket[] brackets, PlayOffTree playOffs){
		this.areBrackets = areBrackets;
		this.brackets = brackets;
		this.playOffs = playOffs;
	}

	
	public static void main(String[] args) {
		HeadOnTournament headOnTournament = new HeadOnTournament(Null,Null,Null);
		
	}

}


