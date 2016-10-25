package project.persistence.entities;

import java.util.Date;

public class HeadOnTournament extends Tournament{
	
	private boolean areBrackets;
	private Bracket[] brackets;
	private PlayOffTree playOffs;
	
	public HeadOnTournament(String course, Date startDate, Golfer[] players, 
			boolean areBrackets, Bracket[] brackets, PlayOffTree playOffs) {
		super(course, startDate, players);
		this.areBrackets = areBrackets;
		this.brackets = brackets;
		this.playOffs = playOffs;
	}
	
	public static void main(String[] args) {
		HeadOnTournament ht = new HeadOnTournament("mammmaaaaa'in", new Date(), null, true, null, null);
		System.out.println(ht.getCourse());
	}

	@Override
	public String toString() {
		return "HeadOnTournament [playOffs=" + playOffs + "]";
	}

	public boolean isAreBrackets() {
		return areBrackets;
	}

	public void setAreBrackets(boolean areBrackets) {
		this.areBrackets = areBrackets;
	}

	public Bracket[] getBrackets() {
		return brackets;
	}

	public void setBrackets(Bracket[] brackets) {
		this.brackets = brackets;
	}

	public PlayOffTree getPlayOffs() {
		System.out.println(playOffs);
		return playOffs;
	}

	public void setPlayOffs(PlayOffTree playOffs) {
		this.playOffs = playOffs;
	}
}
