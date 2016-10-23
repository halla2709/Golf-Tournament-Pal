package project.persistence.entities;

public class Golfer {
	
	private String name;
	private int social;
	private double handicap;
	private String email;
	
	public Golfer(String name, int social, double handicap, String email) {
		this.name = name;
		this.social = social;
		this.handicap = handicap;
		this.email = email;
	}
	
	public static void main(String[] args) {
		Golfer halla = new Golfer("Halla", 93939393, 4.3, "hallamammain");
		System.out.println(halla.social);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	public double getHandicap() {
		return handicap;
	}

	public void setHandicap(double handicap) {
		this.handicap = handicap;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
